package it.read.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class NetClientPost {
	
	public  void print1() throws CustomRestException {
		
		try {
		
			Client c = Client.create();
			WebResource webResource = c.resource("http://localhost:8080/Rentalcar/crunchify/carsService/print1");
			String response = webResource.type(MediaType.APPLICATION_JSON).get(String.class);
			 
			System.out.println("response "+response);
			
		
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void print2() throws CustomRestException {
		try {
			
			Client c = Client.create();
			WebResource resource = c.resource("http://localhost:8080/Rentalcar/crunchify/carsService/print2");
			String response = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println("response "+response);
			
		
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 

	public  void print3() throws CustomRestException {
		 
		try {
			
			Client c = Client.create();
			WebResource resource = c.resource("http://localhost:8080/Rentalcar/crunchify/carsService/print3");
			String response = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println("response "+response);
			
		
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public  void print4() throws CustomRestException {
    	
    	try {
    			
    		Client c = Client.create();
			WebResource resource = c.resource("http://localhost:8080/Rentalcar/crunchify/carsService/print4");
			String response = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println("response "+response);
    			
    		
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    				
	
	
	 
    }
}
