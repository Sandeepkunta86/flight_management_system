package com.project.flight_management_system.exceptiom;

public class PaymentIdNotFound extends RuntimeException{
	private String message= "Payment Id is not found In the db";

	public String getMessage() {
		return message;
	}
}
