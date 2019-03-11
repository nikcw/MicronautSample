package com.caseware.m.entitiesapi;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="OrganizationType", description = "Organization type of the entity", example = "CORPORATION")
public enum OrganizationType
{
    CORPORATION,
    GOVERNMENT,
    REGISTERED_CHARITY,
    PARTNERSHIP,
    TRUST,
    COOPERATIVE,
    PENSION_FUND,
    NONE,
    INDIVIDUAL,
    PUBLIC_COMPANY
}
