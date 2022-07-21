package com.betrybe;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "image")
public class Image extends PanacheMongoEntity {

  public String imagePath;
  public String imageDate;
  public String location;

  /**
   *
   */
  public Image() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param imagePath
   * @param imageDate
   * @param location
   */
  public Image(String imagePath, String imageDate, String location) {
    super();
    this.imagePath = imagePath;
    this.imageDate = imageDate;
    this.location = location;
  }

}
