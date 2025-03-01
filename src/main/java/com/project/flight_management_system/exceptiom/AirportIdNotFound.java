package com.project.flight_management_system.exceptiom;

public class AirportIdNotFound extends RuntimeException{
	private String message= "Airport Id is not found In the db";

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
//	
}
