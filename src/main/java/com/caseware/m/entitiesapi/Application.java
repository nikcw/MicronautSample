package com.caseware.m.entitiesapi;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Entities API Documentation",
                version = "3.0",
                description = "Documentation for all http requests for the Entities API",
                license = @License(name="Caseware License", url = "http://caseware.foo"),
                contact = @Contact(url = "http://caseware.foo", name = "John", email = "john.foo@caseware.com")
        )
)

public class Application {

    public static void main(final String[] args)
    {
        Micronaut.run(Application.class);
    }
}