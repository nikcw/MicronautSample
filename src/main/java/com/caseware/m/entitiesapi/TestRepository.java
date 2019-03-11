package com.caseware.m.entitiesapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This class is responsible for getting/setting entity data from the requests
public class TestRepository implements IEntitiesRepository
{
    private final Map<Integer, Entity> fakeEntities = new HashMap<Integer, Entity>();

    public TestRepository()
    {
    }

    // Gets all accessible entities
    public List<Entity> GetAllEntities()
    {
        return new ArrayList<Entity>(fakeEntities.values());
    }

    // Gets the entity with the associated id
    public Entity GetEntityById(final Integer entityId)
    {
        return fakeEntities.get(entityId);
    }

    // Creates the entity passed, or updates the entity with the id if it already exists
    public EntityResponseStatus CreateOrUpdateEntity(final Entity entity, final Integer id)
    {
        entity.setId(id);
        final EntityStatus entityStatus = AddEntity(entity);
        return new EntityResponseStatus(id, entityStatus);
    }

    // Removes the entity with id
    public EntityResponseStatus RemoveEntityWithId(final Integer entityId)
    {
        EntityStatus deleteStatus = RemoveEntity(entityId);
        return new EntityResponseStatus(entityId, deleteStatus);
    }

    // Creates a list of entities
    public List<EntityResponseStatus> CreateEntities(final List<Entity> entities)
    {
        List<EntityResponseStatus> entityResponses = new ArrayList<EntityResponseStatus>();
        for (Entity entity: entities)
        {
            EntityStatus entityStatus = AddEntity(entity);
            EntityResponseStatus entityResponseStatus = new EntityResponseStatus(entity.getId(), entityStatus);
            entityResponses.add(entityResponseStatus);
        }

        return entityResponses;
    }

    private EntityStatus AddEntity(final Entity entity)
    {
        final Integer id = entity.getId();
        EntityStatus entityStatus = EntityStatus.CREATED;
        if (fakeEntities.containsKey(id))
        {
            entityStatus = EntityStatus.UPDATED;
        }

        fakeEntities.put(id, entity);
        return entityStatus;
    }

    private EntityStatus RemoveEntity(final Integer id)
    {
        if (fakeEntities.containsKey(id))
        {
            fakeEntities.remove(id);
            return EntityStatus.DELETED;
        }

        return EntityStatus.ENTITY_DOES_NOT_EXIST;
    }
}
