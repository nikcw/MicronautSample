package com.caseware.m.entitiesapi;

import io.swagger.v3.oas.annotations.media.Schema;

// This enumeration represents the possible effects to Entity object from a request
@Schema(name="EntityStatus", description = "Provides status of request")
public enum EntityStatus
{
    FAILED_TO_EXECUTE,
    CREATED,
    UPDATED,
    DELETED,
    ENTITY_DOES_NOT_EXIST
}
