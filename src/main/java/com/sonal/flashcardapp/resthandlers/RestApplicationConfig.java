package com.sonal.flashcardapp.resthandlers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;



/*   See web.xml file for Jersey configuration  */
/*   Need to register classes with @PATH annotations and other JAX-RS components */
@ApplicationPath("/")
public class RestApplicationConfig extends Application {
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();
	
	public RestApplicationConfig() {
		/* AuthorizationFilter is a servlet filter that could automatically perform authorization on all incoming requests */
//		restClassSet.add(AuthorizationFilter.class);
		restClassSet.add(JacksonFeature.class);
		restClassSet.add(CardsRestHandler.class);
		restClassSet.add(DeckRestHandler.class);
		restClassSet.add(UsersRestHandler.class);
		/*restClassSet.add(InvalidAcctExResolver.class);
		restClassSet.add(UnknownResourceExResolver.class);*/
	}
	
	public Set<Class<?>> getClasses() {
		return restClassSet;
	}
}
