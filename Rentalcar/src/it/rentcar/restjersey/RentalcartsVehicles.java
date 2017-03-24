package it.rentcar.restjersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import it.rentcar.model.URLConnectionReader;
import it.rentcar.model.Vehicle;
import it.rentcar.utility.ModelComparator;
import it.rentcar.utility.UtilityJson;
import it.rentcar.utility.UtilityMap;




@Path("/carsService")
public class RentalcartsVehicles {
	
	private String print1  = String.format("%s, %s",  " Vehicle name "," Price ");
	private String print2a = String.format("%s, %s",  " Letter ", " Value ");
	private String print3  = String.format("%s, %s, %s, %s"," Vehicle name  " , "Car type  ", "Supplier "," Rating ");
	private String print4  = String.format("%s, %s, %s, %s"," Vehicle name ", " Vehicle score "," Supplier rating "," Sum of scores ");
	
	
	  @GET @Produces(MediaType.TEXT_PLAIN)
	  @Path("/print1")
	  public Response print1() throws JSONException {
		  
		  URLConnectionReader urlConnectionReader = new URLConnectionReader();
		  String stringToParse = "";
		  stringToParse =  urlConnectionReader.reasUrl();
		  UtilityJson utility = new UtilityJson();
		  ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
			
			String  print1a = "";
			try {
				vehicleList = utility.getVehicleListFromJson(stringToParse);
				ModelComparator mc = new ModelComparator();
				vehicleList = (ArrayList<Vehicle>) mc.setModelComparator(vehicleList);
				
				String print1 = String.format("%s, %s",  " Vehicle name "," Price ");
				System.out.printf(print1);
				for(Vehicle bean:vehicleList){
					print1a = String.format("%s, %.2f",  bean.getName(), bean.getPrice());
					System.out.println(print1a.toString());
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		 

		String result = "@Produces(\"application/json\") print1: \n\n";
		return Response.status(200).entity(result).build();
	  }
	  
	  
	  @GET @Produces(MediaType.TEXT_PLAIN)
	  @Path("/print2")
	  public Response print2() throws JSONException {
		  URLConnectionReader urlConnectionReader = new URLConnectionReader();
			String stringToParse = "";
			ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
			
			UtilityJson utility = new UtilityJson();
			ModelComparator mc = new ModelComparator();
			
			try {
				stringToParse =  urlConnectionReader.reasUrl();
				vehicleList = utility.getVehicleListFromJson(stringToParse);
				
				vehicleList = (ArrayList<Vehicle>) mc.setModelComparator(vehicleList);
				UtilityMap carMap = new UtilityMap();
				
			 
				for(Vehicle bean:vehicleList){
					System.out.println(carMap.getRowPrint(bean));
				} 
				
			} catch (CustomRestException e) {
				e.printStackTrace();
			 
			}
			
		  String result = "@Produces(\"application/json\") print2: \n\n";
		  return Response.status(200).entity(result).build();
	  }
	  
	  @GET @Produces(MediaType.TEXT_PLAIN)
	  @Path("/print3")
	  public Response print3() throws JSONException {
		  URLConnectionReader urlConnectionReader = new URLConnectionReader();
			String stringToParse = "";
			UtilityJson utility = new UtilityJson();
			
			ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
			ModelComparator mc = new ModelComparator();
			
			try {
				stringToParse =  urlConnectionReader.reasUrl();
				vehicleList = utility.getVehicleListFromJson(stringToParse);
				UtilityMap carMap = new UtilityMap();
				
				vehicleList = (ArrayList<Vehicle>) mc.setComparatorForRating(vehicleList);
				//String print3 = String.format("%s, %s, %s, %s"," Vehicle name  " , "Car type  ", "Supplier "," Rating ");
				for(Vehicle bean:vehicleList){
					String print3 = String.format("%s, %s, %s, %s",bean.getName() , carMap.getCarType(bean), bean.getSupplier(), bean.getRating());
					System.out.println(print3);
				}
				
				
			} catch (CustomRestException e) {
				e.printStackTrace();
			 
			}
		  
		  String result = "@Produces(\"application/json\") print3: \n\n";
		  return Response.status(200).entity(result).build();
	  }
	  
	  @GET @Produces(MediaType.TEXT_PLAIN)
	  @Path("/print4")
	  public Response print4() throws JSONException {
		  URLConnectionReader urlConnectionReader = new URLConnectionReader();
			String stringToParse = "";
			ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
			UtilityJson utility = new UtilityJson();
			ModelComparator mc = new ModelComparator();
			
			try {
				stringToParse =  urlConnectionReader.reasUrl();
				vehicleList = utility.getVehicleListFromJson(stringToParse);
				UtilityMap carMap = new UtilityMap();
				
				Map<String, List<Vehicle>> mapEntity = mc.groupByCategoryType(vehicleList);
				 
				final Set<Map.Entry<String, List<Vehicle>>> entries = mapEntity.entrySet();

				for (Map.Entry<String, List<Vehicle>> entry : entries) {
				    String key = entry.getKey();
				    List<Vehicle> tmpList = entry.getValue();
				    tmpList = (ArrayList<Vehicle>) mc.setComparatorForRating(tmpList);
				    
				    for(Vehicle bean:tmpList){
				    	String print4 = String.format("%s, %s, %s, %d",bean.getName() , bean.getRating(), bean.getSupplier(), mc.getSumScore(tmpList));
				    	System.out.println(print4);
				    }
				}
				 
				
			} catch (CustomRestException e) {
				e.printStackTrace();
			 
			}
		  
		  String result = "@Produces(\"application/json\") print4: \n\n";
		  return Response.status(200).entity(result).build();
	  }

}
