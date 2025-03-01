package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.service.TicketService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@Operation(summary = "Save Ticket", description = "API is used to save the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Ticket saved"),
		 })
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}
	
	@Operation(summary = "Fetch Ticket", description = "API is used to Fetch the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Ticket fetched"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {
		return ticketService.fetchTicketById(ticketId);
	}

	@Operation(summary = "Delete Ticket", description = "API is used to Delete the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Ticket deleted"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {
		return ticketService.deleteTicketById(ticketId);
	}

	@Operation(summary = "Update Ticket", description = "API is used to update the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Ticket updated"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}

	@Operation(summary = "FetchAll Ticket", description = "API is used to FetchAll the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  all Ticket fetched"),
			 })
	@GetMapping("/fetchAllTicket")
	public ResponseStructureAll<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}
	
	@Operation(summary = "Add Payment For Existing Ticket", description = "API is used to Add Payment For Existing Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Payment For Existing Ticket"),
			@ApiResponse(responseCode = "404", description = "Ticket not found for the given id") })
	@PutMapping("/addPaymentForExistingTicket")
	public ResponseStructure<Ticket> addPaymentForExistingTicket(@RequestParam int paymentId,@RequestParam int ticketId) {
		return ticketService.addPaymentForExistingTicket(paymentId, ticketId);
	}
}
