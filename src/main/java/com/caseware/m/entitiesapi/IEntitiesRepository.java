package com.caseware.m.entitiesapi;

import java.util.List;

// A class implementing this interface is responsible handling Entity requests
public interface IEntitiesRepository
{
    // Gets all accessible entities
    List<Entity> GetAllEntities();

    // Gets the entity with the associated id
    Entity GetEntityById(final Integer entityId);

    // Creates the entity passed, or updates the entity with the id if it already exists
    EntityResponseStatus CreateOrUpdateEntity(final Entity entity, Integer id);

    // Removes the entity with id
    EntityResponseStatus RemoveEntityWithId(final Integer entityId);

    // Creates a list of entities
    List<EntityResponseStatus> CreateEntities(final List<Entity> entities);
}