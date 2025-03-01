package com.project.flight_management_system.exceptiom;

public class FoodIdNotFound extends RuntimeException{
	private String message= "Food Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
