package com.caseware.m.entitiesapi;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="OwnerType", description = "Type of the entity", example = "CLIENT")
public enum OwnerType
{
    CLIENT,
    OTHER,
    INTERNAL
}
