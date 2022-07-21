package com.betrybe;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;
import org.bson.types.ObjectId;
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
  
  @Test
  @DisplayName("3 - cadastra nova imagem")
  public void testPOSTImages() {
    Satellite satellite = new Satellite();
    satellite.imagePath = "imageTest";
    given()
      .body(satellite)
      .contentType(ContentType.JSON)
      .post("/images")
        .then()
          .statusCode(201);
    }

  @Test
  @DisplayName("4 - cadastra nova ilha")
  public void testPOSTIsland() {
    Island island = new Island();
    island.area = "10";
    island.createdAt = "01/01/2021";
    island.location = "N10E25";
    island.temperature = "25";
    island.relativeHumidity = "70";
    island.status = true;
    island.soilMoisture = "test";
    island.plantingDate = "05/01/2021";
    island.isHarvested = true;
    given()
        .body(island)
        .contentType(ContentType.JSON)
        .post("/images")
          .then()
            .statusCode(201);
  }

  @Test
  @DisplayName("5 - atualiza ilha")
  public void testPATCHIsland() {
    Island island = new Island();
    island.area = "10";
    island.createdAt = "01/01/2021";
    island.location = "N10E25";
    island.temperature = "25";
    island.relativeHumidity = "70";
    island.status = true;
    island.soilMoisture = "test";
    island.plantingDate = "05/01/2021";
    island.isHarvested = true;
    given()
        .body(island)
        .contentType(ContentType.JSON)
        .post("/images");

        Island land = new Island();
        land.area = "10000";
        land.createdAt = "01/01/2021";
        land.location = "N10E25";
        land.temperature = "25";
        land.relativeHumidity = "70";
        land.status = true;
        land.soilMoisture = "test";
        land.plantingDate = "05/01/2021";
        land.isHarvested = true;
    given()
        .body(land)
        .contentType(ContentType.JSON)
        .patch("/island/"+island.id)
          .then()
            .statusCode(202);
  }
}