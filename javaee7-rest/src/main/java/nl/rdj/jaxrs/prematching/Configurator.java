package nl.rdj.jaxrs.prematching;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

//@Provider
public class Configurator implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        System.out.println(resourceInfo.getResourceClass());
        System.out.println(resourceInfo.getResourceMethod());
        System.out.println(context.getConfiguration().getPropertyNames());
        context.register(new MethodRedirector());
    }
    
}
