package it.rentcar.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	final static String uri = "http://www.rentalcars.com/js/vehicles.json";
	public URLConnectionReader(){}
	
	public String reasUrl()  {
		String jsonData = "";
		BufferedReader in = null;
        try {
			URL oracle = new URL(uri);
			URLConnection uConn = oracle.openConnection();
			 
			in = new BufferedReader(new InputStreamReader(uConn.getInputStream()));
			String inputLine;
			StringBuilder sbjsonData=new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
			    sbjsonData.append(inputLine);
			}
			jsonData = sbjsonData.toString().trim();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return jsonData;
    }
	
}
