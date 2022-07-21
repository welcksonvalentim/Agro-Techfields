package com.betrybe;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class GreetingResourceTest {

  @Test
  @DisplayName("1 - Retorna as imagens cadastradas")
  public void testEndPonitImages() {
    given()
        .when().get("/images")
        .then()
          .statusCode(200);
    }

  @Test
  @DisplayName("2 - Retorna as ilhas cadastradas")
  public void testHelloEndpointIsland() {
    given()
      .when().get("/island")
      .then()
        .statusCode(200);
  }    
}