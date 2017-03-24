package it.rentcar.utility;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.rentcar.model.Vehicle;

public class ModelComparator {
 
	
	public List<Vehicle> studList=new  ArrayList<Vehicle>();
	public double sumScore;
	
	
	
	 

	public List<Vehicle> getStudList() {
		return studList;
	}

	public void setStudList(List<Vehicle> studList) {
		this.studList = studList;
	}
	
	/**
	 * 
	 * @param studList
	 *  - I check the list of items not ordered the manufacturer to manufacturer
	 *  - Add the list as an instance member, 
	 * -  Called the method that performs the sort on the list of items
	 */
	public ModelComparator(List<Vehicle> studList ){
		
		setStudList(studList);
		setModelComparator();
	}

	public ModelComparator(){}
	
	
	 
	public void setModelComparator(){
		
		Collections.sort(this.studList, new Comparator<Vehicle>(){
		    public int compare(Vehicle s1, Vehicle s2) {
		        return Double.valueOf(s1.getPrice()).compareTo(s2.getPrice());
		    }
		});
		
		
	}
	
	/**
	 * 
	 * @param studList
	 * @return List<Vehicle> order List by OutgoingRank properties;
	 * 
	 */
	public List<Vehicle> setModelComparator(List<Vehicle> studList){
		
		Collections.sort(studList, new Comparator<Vehicle>(){
		    public int compare(Vehicle s1, Vehicle s2) {
		        return Double.valueOf(s1.getPrice()).compareTo(s2.getPrice());
		    }
		});
		
		return studList;
	}
	
	/**
	 * 
	 * @param studList
	 * @return List<Vehicle> Print out the highest rated supplier per car type, descending order;
	 * 
	 */
	public List<Vehicle> setComparatorForRating(List<Vehicle> studList){
		
		Collections.sort(studList, new Comparator<Vehicle>(){
		    public int compare(Vehicle s1, Vehicle s2) {
		        return Double.valueOf(s1.getRating()).compareTo(s2.getRating());
		    }
		});
		
		return studList;
	}
	
	
	
	
	
	public Map<String, List<Vehicle>> groupByCategoryType(List<Vehicle> list) {
	    Map<String, List<Vehicle>> map = new TreeMap<String, List<Vehicle>>();
	    for (Vehicle o : list) {
	        List<Vehicle> group = map.get(o.getSipp());
	        if (group == null) {
	           group = new ArrayList();
	           map.put(o.getSipp(), group);
	        }
	        group.add(o);
	    }
	    return map;
	}

	public double getSumScore(List<Vehicle> list) {
		double total = 0.0;
		for(Vehicle bean:list){
			total = total + bean.getRating();
		}
		this.sumScore = Math.round(total);
		
		return this.sumScore;
	}

}