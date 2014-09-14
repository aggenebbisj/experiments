package nl.rdj.jaxrs.prematching;



import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("prematching")
@RequestScoped
public class BeansResource {
    
    @POST
    public List<Bean> beans() {
        return Arrays.asList(new Bean("java", false), new Bean("enterprise", true));
    }
    
}
