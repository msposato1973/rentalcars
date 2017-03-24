package it.rentcar.utility;

import java.util.HashMap;
import java.util.Map;

import it.rentcar.model.Vehicle;


public class UtilityMap {
	
	public   HashMap <String,String> mCarType=new HashMap<String,String>();
	public   HashMap <String,String> mDoorsCarType = new HashMap<String,String>();
	public   HashMap <String,String> mTrasmission = new HashMap<String,String>();
	public   HashMap <String,String> mFuelAirCon = new HashMap<String,String>();
	
	public Map<String, String> getmCarType() {
		return mCarType;
	}

	public Map<String, String> getmDoorsCarType() {
		return mDoorsCarType;
	}

	public Map<String, String> getmTrasmission() {
		return mTrasmission;
	}

	public Map<String, String> getmFuelAirCon() {
		return mFuelAirCon;
	}

	 

	
	
	public UtilityMap(){
		
		mCarType.put("M", "Mini");
		mCarType.put("E", "Economi");
		mCarType.put("C", "Compact");
		mCarType.put("I", "Intermediate");
		mCarType.put("S", "Standard");
		mCarType.put("F", "Full size");
		mCarType.put("P", "Premium");
		mCarType.put("L", "Luxury");
		mCarType.put("X", "Special");
		
	 
		 
		mDoorsCarType.put("B", "2 doors");
		mDoorsCarType.put("C", "4 doors");
		mDoorsCarType.put("D", "5 doors");
		mDoorsCarType.put("W", "Estate");
		mDoorsCarType.put("T", "Convertible");
		mDoorsCarType.put("F", "SUV");
		mDoorsCarType.put("P", "Pick up");
		mDoorsCarType.put("V", "Passenger Van");
		
	 
		mTrasmission.put("M", "Manual");
		mTrasmission.put("A", "Automatic");
		
	 
		mFuelAirCon.put("N", "Petrol/no AC");
		mFuelAirCon.put("R", "Petrol/AC");
		
	}
	
	public String getRowPrint(Vehicle bean){
		StringBuffer printLine = new StringBuffer(bean.getName() );
		printLine.append(" - "+ bean.getSipp() );
		
		String k = bean.getSipp().substring(0, 1);
		printLine.append(" - "+this.mCarType.get(k));
		
	    String door = this.mDoorsCarType.get(bean.getSipp().substring(1, 2));
	    printLine.append(" - "+door);
	    
	    String trasmission = this.mTrasmission.get(bean.getSipp().substring(2, 3));
		printLine.append(" - "+trasmission);
		
		String fluel_airc = this.mFuelAirCon.get(bean.getSipp().substring(2, 3));
		fluel_airc = fluel_airc.replace('/', '-');
		printLine.append(" - "+fluel_airc);
		 
		return printLine.toString();
	}
	
	
	public String getCarType(Vehicle bean){
		String carType="";
		
		String k = bean.getSipp().substring(0, 1);
		carType = this.mCarType.get(k);
		
		return carType;
	}

}
