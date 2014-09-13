package nl.rdj.jaxrs.subresources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class BeanResource {
    private final String name;

    @Context
    HttpHeaders headers;
    
    public BeanResource(String name) {
        this.name = name;
    }
    
    @GET
    public Bean beans() {
        System.out.println("Got headers: " + headers);
        return new Bean(name, true);
    }
    
    
}
