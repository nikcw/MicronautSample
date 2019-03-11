package com.caseware.m.entitiesapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Schema(name="EntityResponseStatus", description = "Provides information of id/entity")
@Setter
@Getter
// This class is responsible for creating the relationship between an entity id and a requests
// result.
@Data public class EntityResponseStatus
{
    private final EntityStatus entityStatus;

    @Schema(description = "Entity id")
    private final Integer entityId;

    // todo: Add Entity name???

    // todo: Add entity error message if it returned???

    public EntityResponseStatus(final Integer entityId, final EntityStatus entityStatus)
    {
        this.entityId = entityId;
        this.entityStatus = entityStatus;
    }
}
