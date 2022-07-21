package com.betrybe;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

@Path("/island")
public class IslandResource {

  @Inject
  IslandRepository islandRepository;

  @GET
  public Response ListAll(@PathParam("id") String id) {
    try {
      return Response.ok(islandRepository.listAll()).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @GET
  @Path("/{id}")
  public Response findById(@PathParam("id") String id) {
    try {
      Island island = islandRepository.findById(new ObjectId(id));
      return Response.ok(island).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @POST
  public Response create(Island island) {
    try {
      islandRepository.persist(island);
      return Response.created(new URI("/" + island.id)).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @PATCH
  @Path("/{id}")
  public Response update(@PathParam("id") String id, Island island) {
    try {
      island.id = new ObjectId(id);
      islandRepository.update(island);
      return Response.accepted(island).build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") String id) {
    try {
      Island island = islandRepository.findById(new ObjectId(id));
      islandRepository.delete(island);
      return Response.noContent().build();
    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }
}
