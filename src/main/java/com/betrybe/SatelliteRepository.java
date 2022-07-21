package com.betrybe;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class SatelliteRepository implements PanacheMongoRepository<Satellite>{
  public List<Satellite> findAllList() {
    return listAll(Sort.by("imagePath"));
  }
}
