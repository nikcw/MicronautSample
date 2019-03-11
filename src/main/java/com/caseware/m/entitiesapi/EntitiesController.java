package com.caseware.m.entitiesapi;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("/Entities")
@Validated
// This class is responsible for handling HTTP requests for Entities
public class EntitiesController
{
    private final IEntitiesRepository entitiesRepository;

    public EntitiesController()
    {
        entitiesRepository = new TestRepository();
    }

    @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all entities", description = "Gets a list of all the entities", tags = "Entity",
    responses = {
            @ApiResponse(description = "A list of entities", responseCode = "200", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = Entity.class)))),
            @ApiResponse(description = "Entity not found", responseCode = "404")
    })
    public HttpResponse<List<Entity>> ExportEntities()
    {
        final List<Entity> entities = entitiesRepository.GetAllEntities();

        if (entities != null)
        {
            // Returns the entity
            return HttpResponse.ok(entities);
        }

        // Entity not found
        return HttpResponse.noContent();
    }

    @Get(uri = "/{id}", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Entity Details", description = "Gets the details of the entity with the specified id", tags = "Entity",
            responses = {
                    @ApiResponse(description = "Created entity", responseCode = "200", content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = Entity.class)))),
                    @ApiResponse(description = "Entity not found", responseCode = "404")})
    public HttpResponse<Entity> GetEntityDetails(@NotBlank final Integer id)
    {
        final Entity entity = entitiesRepository.GetEntityById(id);

        if (entity != null)
        {
            // Returns the entity
            return HttpResponse.ok(entity);
        }

        // Entity not found
        return HttpResponse.notFound();
    }

    @Post(uri = "/")
    @Operation(summary = "Create entities", description = "Create a list of entities", tags = "Entity",
            responses = {
                    @ApiResponse(description = "A list of Entity responses for the created entities", responseCode = "200", content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = EntityResponseStatus.class)))),
                    @ApiResponse(description = "Entity not found", responseCode = "404")}
                    )
    public HttpResponse<List<EntityResponseStatus>> ImportEntities(@RequestBody Entity[] entities)
    {
        ArrayList<Entity> e = new ArrayList<Entity>(Arrays.asList(entities));
        final List<EntityResponseStatus> statuses = entitiesRepository.CreateEntities(e);

        if (statuses != null && !statuses.isEmpty())
        {
            // Returns the entity
            return HttpResponse.ok(statuses);
        }

        // Entity not found
        return HttpResponse.badRequest();
    }

    @Put(uri = "/{id}", consumes = MediaType.APPLICATION_JSON)
    @Operation(summary = "Save/Update Entity", description = "From the given id, creates an entity with specified id, " +
            "otherwise it overwrites the existing entity with new information",tags = "Entity",
            responses = {
                    @ApiResponse(description = "Response status indicating if entity was created", responseCode = "200", content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = EntityResponseStatus.class)))),
                    @ApiResponse(description = "Entity not found", responseCode = "404")}
    )
    public HttpResponse<EntityResponseStatus> UpdateEntity(@NotBlank final Integer id, @RequestBody Entity request)
    {
        // TODO: Should verify for all mandatory fields here, otherwise throw a bad request
        final EntityResponseStatus entityRequestStatus = entitiesRepository.CreateOrUpdateEntity(request, id);
        return HttpResponse.ok(entityRequestStatus);
    }

    @Delete(uri = "/{id}")
    @Operation(summary = "Delete entity", description = "Deletes the entity with the specified id", tags = "Entity",
            responses = {
                    @ApiResponse(description = "Response status indicating if entity was deleted", responseCode = "200", content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = EntityResponseStatus.class)))),
                    @ApiResponse(description = "Entity not found", responseCode = "404")})
    public HttpResponse<EntityResponseStatus> DeleteEntity(@NotBlank final Integer id)
    {
        EntityResponseStatus entityResponseStatus = entitiesRepository.RemoveEntityWithId(id);
        if (entityResponseStatus.getEntityStatus() == EntityStatus.DELETED)
        {
            return HttpResponse.ok(entityResponseStatus);
        }

        return HttpResponse.notFound(entityResponseStatus);
    }
}
