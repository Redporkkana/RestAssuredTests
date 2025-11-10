package com.singularix.restfulws.users;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.jupiter.api.Test;

public class TestUserSchemaValidation {
	@Test
    public void userResponse_shouldMatchSchema() {
        given()
            .auth().basic("username", "password")
        .when()
            .get("/users/1")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("user-schema.json"));
    }
}

