package com.betrybe;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "images")
public class Satellite extends PanacheMongoEntity {
  public String imagePath;

  public Satellite() {}

  public Satellite(String imagePath) {
    this.imagePath = imagePath;
  }
}
