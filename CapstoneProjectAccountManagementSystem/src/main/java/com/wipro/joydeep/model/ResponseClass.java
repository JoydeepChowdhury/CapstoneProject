package com.wipro.joydeep.model;

public class ResponseClass {
    private String response;
   
    public ResponseClass()
    {
    	
    }
    
	public ResponseClass(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseClass [response=" + response + "]";
	}
    
    
}
