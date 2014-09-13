package nl.rdj.beer.boundary;

import java.net.URI;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import nl.rdj.beer.entity.Beer;

@Path("beers")
public class BeerResource {
    
    @GET
    public JsonArray beers() {
        JsonObject object = Json.createObjectBuilder().add("brand", "La Chouffe").build();
        return Json.createArrayBuilder().add(object).build();
    }
    
    @GET
    @Path("{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public Beer beer(@PathParam("brand") String brand) {
        return new Beer(brand);
    }
    
    @GET
    @Path("exception")
    public String exception() {
        throw new RuntimeException("Something went terribly wrong!");
    }
    
    @GET
    @Path("async")
    public Response async(@Suspended AsyncResponse response) {
        return Response.status(Response.Status.OK).entity(new Beer("Async")).build();
        
//        JsonObject object = Json.createObjectBuilder().add("brand", "Async").build();
//        response.resume(object);
//        response.setTimeout(1, TimeUnit.DAYS);
//        response.setTimeoutHandler(new TimeoutHandler() {
//
//            @Override
//            public void handleTimeout(AsyncResponse asyncResponse) {
//
//            }
//            
//        });
    }
    
    @POST
    @Path("{brand}")
    public Response save(Beer beer, @Context UriInfo info) {
        URI uri = info.getAbsolutePathBuilder().path("/id-" + System.currentTimeMillis()).build();
        return Response.created(uri).build();
    }
}
