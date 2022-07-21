package com.betrybe;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {

  public List<Island> findAllList() {
    return listAll(Sort.by("createdAt"));
  }
}
