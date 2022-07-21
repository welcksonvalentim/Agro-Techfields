package com.betrybe;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

@Path("/images")
public class SatelliteResource {
  @Inject
  SatelliteRepository satelliteRepository;

  @GET
  public Response getAll(@PathParam("id") String id) {
    try {
      return Response.ok(satelliteRepository.listAll()).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @GET
  @Path("/{id}")
  public Response findById(@PathParam("id") String id) {
    try {
      Satellite satellite = satelliteRepository.findById(new ObjectId(id));
      return Response.ok(satellite).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @POST
  public Response create(List<Image> images) {
    Satellite satellite = new Satellite(images);
    try {
      satelliteRepository.persist(satellite);
      return Response.created(new URI("/" + satellite.id)).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }
}
