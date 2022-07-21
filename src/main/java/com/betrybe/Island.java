package com.betrybe;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "island")
public class Island extends PanacheMongoEntity {

  public String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
      .toString();
  public String temperature;
  public String relativeHumidity;
  public String soilMoisture;
  public boolean isFertilized;
  public String fertilizingDate = "";
  public boolean isPlanted;
  public String plantingDate = "";
  public boolean isHarvested;
  public String harvestDate = "";
  public String location;
  public String area;
  public List<Satellite> imageList = Collections.<Satellite>emptyList();;
  public boolean status = true;

  /**
  *
  */
  public Island() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Instantiates a new island.
   *
   * @param temperature      the temperature
   * @param relativeHumidity the relative humidity
   * @param soilMoisture     the soil moisture
   * @param isFertilized     the is fertilized
   * @param isPlanted        the is planted
   * @param isHarvested      the is harvested
   * @param location         the location
   * @param area             the area
   * @param status           the status
   */
  public Island(String temperature, String relativeHumidity,
      String soilMoisture, boolean isFertilized, boolean isPlanted,
      boolean isHarvested, String location, String area, boolean status) {
    super();
    this.temperature = temperature;
    this.relativeHumidity = relativeHumidity;
    this.soilMoisture = soilMoisture;
    this.isFertilized = isFertilized;
    this.isPlanted = isPlanted;
    this.isHarvested = isHarvested;
    this.location = location;
    this.area = area;
    this.status = status;
  }
}
