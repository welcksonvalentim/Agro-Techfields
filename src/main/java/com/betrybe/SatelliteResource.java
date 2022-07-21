package com.betrybe;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
  public Response getById(@PathParam("id") String id) {
    try {
      Satellite satellite = satelliteRepository.findById(new ObjectId(id));
      return Response.ok(satellite).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @POST
  public Response create(Satellite satellite) {
    try {
      satelliteRepository.persist(satellite);
      return Response.created(new URI("/"+satellite.id)).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @PUT
  @Path("/{id}")
  public Response update(@PathParam("id") String id, Satellite satellite) {
    try {
      satellite.id = new ObjectId(id);
      satelliteRepository.update(satellite);
      return Response.ok(satellite).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") String id) {
    try {
      Satellite satellite = satelliteRepository.findById(new ObjectId(id));
      satelliteRepository.delete(satellite);
      return Response.noContent().build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }
}
