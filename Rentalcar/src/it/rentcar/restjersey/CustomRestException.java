package it.rentcar.restjersey;

import org.json.JSONException;

public class CustomRestException extends JSONException{
	 
	private static final long serialVersionUID = 1L;
	private String globalCode;
	private String localCode;

	
	public CustomRestException(String message, Throwable cause) {
		super(message);
	}

	public CustomRestException(String message) {
		super(message);
	}

	public CustomRestException(Throwable cause) {
		super(cause);
	}

	public CustomRestException(String globalCode, String localCode) {
		super(localCode);
		this.globalCode = globalCode;
		this.localCode = localCode;
	}

	public String getGlobalCode() {
		return globalCode;
	}

	public void setGlobalCode(String globalCode) {
		this.globalCode = globalCode;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

}