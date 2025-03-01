package com.project.flight_management_system.exceptiom;

public class FlightIdNotFound extends RuntimeException{
	private String message= "Flight Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
