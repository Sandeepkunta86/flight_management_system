package com.project.flight_management_system.exceptiom;

public class PassportIdNotFound extends RuntimeException{
	private String message= "Passport Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
