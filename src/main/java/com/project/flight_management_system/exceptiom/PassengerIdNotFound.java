package com.project.flight_management_system.exceptiom;

public class PassengerIdNotFound extends RuntimeException{
	private String message= "Passenger Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
