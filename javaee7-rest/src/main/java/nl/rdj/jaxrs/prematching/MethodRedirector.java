package nl.rdj.jaxrs.prematching;

import java.io.IOException;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class MethodRedirector implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
//        System.out.println("-->" + requestContext.getMethod());
//        requestContext.setMethod(HttpMethod.POST); 
    }

}
