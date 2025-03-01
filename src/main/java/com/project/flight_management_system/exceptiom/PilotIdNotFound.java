package com.project.flight_management_system.exceptiom;

public class PilotIdNotFound extends RuntimeException{
	private String message= "Pilot Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
