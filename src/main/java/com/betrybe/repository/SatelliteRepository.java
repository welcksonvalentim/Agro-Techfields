package com.betrybe.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.betrybe.entity.Satellite;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class SatelliteRepository implements PanacheMongoRepository<Satellite> {
  public List<Satellite> findAllList() {
    return listAll();
  }
}
