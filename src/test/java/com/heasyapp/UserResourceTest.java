package com.heasyapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testListEndpoint() {
        given()
          .when().get("/user/list")
          .then()
             .statusCode(200);
    }

}