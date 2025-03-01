package com.project.flight_management_system.exceptiom;

public class AddressIdNotFound extends RuntimeException{
	private String message= "Address Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
