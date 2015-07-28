package example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class MyServices  extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(Products.class);
	    return s;
	}
	
}
