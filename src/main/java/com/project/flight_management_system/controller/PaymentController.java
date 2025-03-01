package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.service.PaymentService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = "Save Payemnet", description = "API is used to  Save Payemnet")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved Passport"),
		 })
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	@Operation(summary = "Fetch Payemnet", description = "API is used to  Fetch Payemnet")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Fetched Passport"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	

	@Operation(summary = "Delete Payemnet", description = "API is used to  Delete Payemnet")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Deleted Passport"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}

	@Operation(summary = "Update Payemnet", description = "API is used to  Update Payemnet")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Updated Passport"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}

	@Operation(summary = "FetchAll Payemnet", description = "API is used to  fetchAll Payemnet")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully FetchAll Passport"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@GetMapping("/fetchAllPayment")
	public ResponseStructureAll<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
}
