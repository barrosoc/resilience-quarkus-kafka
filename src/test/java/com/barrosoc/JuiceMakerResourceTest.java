package com.barrosoc;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class JuiceMakerResourceTest {

    @Test
    public void shouldMakeJuiceForAGivenFruit() {
        given()
            .header("Content-type", "application/json")
            .and()
            .body("apple")
            .when()
            .post("/juice-maker")
            .then()
            .statusCode(201);
    }

}