package com.project.flight_management_system.exceptiom;

public class SeatIdNotFound extends RuntimeException{
	private String message= "Seat Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
