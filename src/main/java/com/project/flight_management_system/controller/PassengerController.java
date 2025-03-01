package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.service.PassengerService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	
	@Operation(summary = "Save Passenger", description = "API is used to  Save Passenger in DB")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Food is Saved"),
		 })
	@PostMapping("/savePassenger")
	public ResponseStructure<Passenger> savePassenger(@RequestBody Passenger passenger) {
		return passengerService.savePassenger(passenger);
	}
	
	@Operation(summary = "Fetch Passenger", description = "API is used to Fetch the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Passenger Fetched"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@GetMapping("/fetchPassengerById")
	public ResponseStructure<Passenger> fetchPassengerById(@RequestParam int passengerId) {
		return passengerService.fetchPassengerById(passengerId);
	}
	
	@Operation(summary = "Delete Passenger", description = "API is used to Delete passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Passenger is Deleted"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@DeleteMapping("/deletePassengerById")
	public ResponseStructure<Passenger> deletePassengerById(@RequestParam int passengerId) {
		return passengerService.deletePassengerById(passengerId);
	}

	@Operation(summary = "Update Passenger", description = "API is used to Update the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Passenger is updated"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@PutMapping("/updatePassengerById")
	public ResponseStructure<Passenger> updatePassengerById(@RequestParam int oldPassengerId,@RequestBody Passenger newPassenger) {
		return passengerService.updatePassengerById(oldPassengerId, newPassenger);
	}

	@Operation(summary = "FetchAll Passenger", description = "API is used to FetchAll Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully All Passengers Fetched"),
			@ApiResponse(responseCode = "404", description = "Passenger Not found") })
	@GetMapping("/fetchAllPassenger")
	public ResponseStructureAll<Passenger> fetchAllPassenger() {
		return passengerService.fetchAllPassenger();
	}
	
	@Operation(summary = "Add Existing Passport for Existing Passenger", description = "API is used to Add Existing Passport for Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Added Existing Passport for Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passport or Passenger not found for the given id") })
	@PutMapping("/addExistingPassportforExistingPassenger")
	public ResponseStructure<Passenger> addExistingPassportforExistingPassenger(@RequestParam int passportId,@RequestParam int passengerId) {
		return passengerService.addExistingPassportforExistingPassenger(passportId, passengerId);
	}
	
	@Operation(summary = "Add Existing Seat for Existing Passenger", description = "API is used to Add Existing Seat for Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Existing Seat for Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Seat or Passenger not found for the given id") })
	@PutMapping("/addExistingSeatforExistingPassenger")
	public ResponseStructure<Passenger> addExistingSeatforExistingPassenger(@RequestParam int seatId,@RequestParam int passengerId) {
		return passengerService.addExistingSeatforExistingPassenger(seatId, passengerId);
	}
	
	
	@Operation(summary = "Add Existing Address for Existing Passenger", description = "API is used to Add Existing Address for Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Existing Address for Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Address or Passenger not found for the given id") })
	@PutMapping("/addExistingAddressforExistingPassenger")
	public ResponseStructure<Passenger> addExistingAddressforExistingPassenger(@RequestParam int addressId,@RequestParam int passengerId) {
		return passengerService.addExistingAddressforExistingPassenger(addressId, passengerId);
	}
	
	@Operation(summary = "Add Existing Ticket To Existing Passenger", description = "API is used to Add Existing Ticket To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Existing Ticket To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Ticket or Passenger not found for the given id") })
	@PutMapping("/addExistingTicketToExistingPassenger")
	public ResponseStructure<Passenger> addExistingTicketToExistingPassenger(@RequestParam int ticketId,@RequestParam int passengerId) {
		return passengerService.addExistingTicketToExistingPassenger(ticketId, passengerId);
	}
	
	@Operation(summary = "Add Existing Food To Existing Passenger", description = "API is used to Add Existing Food To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Existing Food To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Food or Passenger not found for the given id") })
	@PutMapping("/addExistingFoodToExistingPassenger")
	public ResponseStructure<Passenger> addFoodToExistingPassenger(@RequestParam int foodId,@RequestParam int passengerId) {
		return passengerService.addExistingFoodToExistingPassenger(foodId, passengerId);
	}
}
