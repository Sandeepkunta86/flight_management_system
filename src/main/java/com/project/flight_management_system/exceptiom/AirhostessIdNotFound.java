package com.project.flight_management_system.exceptiom;

public class AirhostessIdNotFound extends RuntimeException{
	private String message= "Airhostess Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
