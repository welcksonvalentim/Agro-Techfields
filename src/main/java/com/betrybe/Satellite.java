package com.betrybe;

import java.util.Collections;
import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "images")
public class Satellite extends PanacheMongoEntity {

  public List<Image> images = Collections.<Image>emptyList();

  public Satellite() {
    super();
  }

  public Satellite(List<Image> images) {
    super();
    this.images = images;
  }
}
