package com.barrosoc.juicemaker;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.verify;

import com.barrosoc.juicemaker.JuiceMakerService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import org.junit.jupiter.api.Test;

@QuarkusTest
class JuiceMakerResourceTest {

    @InjectSpy
    JuiceMakerService juiceMakerService;

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

        verify(juiceMakerService).makeJuice("apple");
    }

}