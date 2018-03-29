package com.school.automation.util;

import com.school.registerdb.util.Constants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 * @author jhonny
 */
public class RestClienUtil {               
    public static WebTarget getTargetClient(String url) {
        ClientConfig clientConfig = new ClientConfig();
	    clientConfig.register(JacksonFeature.class);	
        final Client client = ClientBuilder.newClient(clientConfig);
        return client.target(Constants.BASE_URL + url);
    }
    
    public static ResteasyWebTarget getResteasyTargetClient(String url) {
        ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
        return resteasyClient.target(Constants.BASE_URL + url);        
    }
}