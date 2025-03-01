package com.project.flight_management_system.exceptiom;

public class TicketIdNotFound extends RuntimeException {
	private String message= "ticket Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
