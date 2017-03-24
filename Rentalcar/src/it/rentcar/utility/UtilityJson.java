package it.rentcar.utility;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import it.rentcar.model.Vehicle;
import it.rentcar.restjersey.CustomRestException;

public class UtilityJson {

	public UtilityJson(){}
		
	public ArrayList<Vehicle> getVehicleListFromJson(String jsonStr) throws CustomRestException {

        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        JSONObject obj = new JSONObject(jsonStr);
        JSONObject arrObj = obj.getJSONObject("Search");
		JSONArray items = arrObj.optJSONArray("VehicleList");
		
		if(obj!=null){
			for (int i = 0; i < items.length(); i++){
				JSONObject currentVehicle = items.optJSONObject(i);
			    vehicleList.add(new Vehicle(
			    		currentVehicle.getDouble("price"),
			    		currentVehicle.getString("name"),
			    		currentVehicle.getDouble("rating"),
			    		currentVehicle.getString("sipp"),
			    		currentVehicle.getString("supplier")));
			    		
			}
		}
		
		
		 
        return (ArrayList<Vehicle>) vehicleList;
    }
}
