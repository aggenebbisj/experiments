package nl.rdj.jaxrs.subresources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

@RequestScoped
@Path("beans")
public class BeansResource {
    
    @Context
    ResourceContext rc;
    
    @Path("{name}")
    public BeanResource bean(@PathParam("name") String name) {
        return rc.initResource(new BeanResource(name));
    }
    
}
