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
    given().when().get("/images").then().statusCode(200);
  }

  @Test
  @DisplayName("2 - Retorna as ilhas cadastradas")
  public void testHelloEndpointIsland() {
    given().when().get("/island").then().statusCode(200);
  }

  @Test
  @DisplayName("3 - cadastra nova imagem")
  public void testPOSTImages() {
    given().body("").contentType(ContentType.JSON).post("/images").then()
        .statusCode(201);
  }

  @Test
  @DisplayName("4 - cadastra nova ilha")
  public void testPOSTIsland() {
    Island island = new Island();
    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + island.id);
    island.area = "10";
    island.location = "N10E25";
    island.temperature = "25";
    island.relativeHumidity = "70";
    island.status = true;
    island.soilMoisture = "test";
    island.isPlanted = false;
    island.isFertilized = false;
    island.isHarvested = true;
    given().body(island).contentType(ContentType.JSON).post("/island").then()
        .statusCode(201);
  }

  @Test
  @DisplayName("5 - atualiza ilha")
  public void testPATCHIsland() {
    Island island = new Island();
    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + island.id);
    island.area = "10";
    island.location = "N10E25";
    island.temperature = "25";
    island.relativeHumidity = "70";
    island.status = true;
    island.soilMoisture = "test";
    island.isPlanted = false;
    island.isFertilized = false;
    island.isHarvested = true;
    given().body(island).contentType(ContentType.JSON).post("/island");
    Island newIsland = new Island();
    newIsland.area = "10";
    newIsland.location = "N10E25";
    newIsland.temperature = "25";
    newIsland.relativeHumidity = "70";
    newIsland.status = true;
    newIsland.soilMoisture = "test";
    newIsland.isPlanted = false;
    newIsland.isFertilized = false;
    newIsland.isHarvested = false;
    given().body(newIsland).contentType(ContentType.JSON)
        .patch("/island/" + island.id).then().statusCode(202);
  }
}
