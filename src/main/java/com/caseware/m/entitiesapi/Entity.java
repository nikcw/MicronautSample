package com.caseware.m.entitiesapi;

import com.caseware.cloud.server.models.generated.EntityType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// This class represents the Entity object.
@Schema(name="Entity", description = "Represents an Entity")
@Getter
@Setter
@Data public class Entity
{
    @Schema(description = "The unique id for the entity", example = "1")
    private Integer id;

    @Schema(description = "Name of the entity", maxLength = 60, required = true, example = "EntityName")
    private String name;

    @Schema(description = "Client/Group code", maxLength = 10, required = true, example = "123")
    private String entityNumber;

    @Schema(description = "Type of the entity", required = true, example = "CLIENT")
    private OwnerType ownerType;

    @Schema(description = "Status of the entity", required = true, example="Active")
    private String status;

    @Schema(description = "First name", maxLength = 60, required = true, example = "John")
    private String firstName;

    @Schema(description = "Last name", maxLength = 60, required = true, example = "Doe")
    private String lastName;

    @Schema(description = "Inactive date DD-MM-YYYY", example = "12-12-2024")
    private String inactiveDate;

    @Schema(description = "Country code", maxLength = 2, example = "CA")
    private String countryCode;

    @Schema(description = "Organization type of the entity")
    private OrganizationType organizationType;

    @Schema(description = "Start date DD-MM-YYYY", example = "12-12-2024")
    private String startDate;

    @Schema(description = "Custom organization type defined in countrypluginregistration.js", example = "1") //todo: Change this example
    private String customOrganizationTypeId;

    @Schema(description = "The name under which the entity does day-to-day business", maxLength = 20, example = "416-111-1111")
    private String businessNumber;

    @Schema(description = "A memo", example = "This is a description")
    private String memo;

    @Schema(description = "-1 to clear value, 1 - January, 2 - February, etc...", example = "-1")
    private Integer yearEndMonth;

    @Schema(description = "Year end changed date DD-MM-YYYY", example = "12-12-2024")
    private String yearEndChangedDate;

    @Schema(description = "Dissolution date DD-MM-YYYY", example = "12-12-2024")
    private String dissolutionDate;

    @Schema(description = "Exchange name", example = "NASDAQ")
    private String exchangeName;

    @Schema(description = "Incorporation date DD-MM-YYYY", example = "12-12-2024")
    private String incorporationDate;

    @Schema(description = "Referred by", example = "Foo")
    private String referredBy;

    @Schema(description = "Reporting framework", example = "Foo")
    private String reportingFramework;

    @Schema(description = "Trading symbol", example = "HUF")
    private String tradingSymbol;

    @Schema(description = "List of service ID's defined in collaborate.js")
    private List<String> servicesPerformed;

    @Schema(description = "Website URL", example = "www.casewareexample.com")
    private String website;

    public Entity() {}
}
