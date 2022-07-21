package com.betrybe;

import java.text.SimpleDateFormat;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "island")
public class Island extends PanacheMongoEntity {

  public String temperature;
  public String relativeHumidity;
  public boolean status = true;
  public String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").toString();
  public String soilMoisture;
  public String plantingDate;
  public boolean isHarvested;
  public String location;
  public String area;
  
  public Island() {}

  public Island(String temperature, String relativeHumidity, boolean status,
    String createdAt, String soilMString, String plantingDate, boolean isHarvested,
    String location, String area) {
    this.temperature = temperature;
    this.relativeHumidity = relativeHumidity;
    this.status = status;
    this.createdAt = createdAt;
    this.soilMoisture = soilMString;
    this.plantingDate = plantingDate;
    this.isHarvested  = isHarvested;
    this.location = location;
    this.area = area;
  }
}
