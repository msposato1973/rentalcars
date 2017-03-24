package it.read.main;

import it.read.rest.client.CustomRestException;
import it.read.rest.client.NetClientPost;

public class MainClass {

	public static void main(String[] args) {
		 
		try {
			
			NetClientPost nClient = new NetClientPost();
			nClient.print1();
 			nClient.print2();
 			nClient.print3();
 			nClient.print4();
			
		} catch (CustomRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
	
	
	

}
