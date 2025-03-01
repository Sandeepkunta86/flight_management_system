package com.project.flight_management_system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.service.FlightService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	
	@Operation(summary = "Save Flight", description = "API is used to save the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Flight created"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PostMapping("/saveFlight")
	public ResponseStructure<Flight> saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}
	
	@Operation(summary = "Fetch Flight", description = "API is used to fetch the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Flight fetchd"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@GetMapping("/fetchFlightById")
	public ResponseStructure<Flight> fetchFlightById(@RequestParam int flightId) {
		return flightService.fetchFlightById(flightId);
	}

	@Operation(summary = "Delete Flight", description = "API is used to delete the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Flight Deleted"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@DeleteMapping("/deleteFlightById")
	public ResponseStructure<Flight> deleteFlightById(@RequestParam int flightId) {
		return flightService.deleteFlightById(flightId);
	}
	
	@Operation(summary = "Update Flight", description = "API is used to update the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Flight updated"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/updateFlightById")
	public ResponseStructure<Flight> updateFlightById(@RequestParam int oldFlightId,@RequestBody  Flight newFlight) {
		return flightService.updateFlightById(oldFlightId, newFlight);
	}

	@Operation(summary = "FetchAll Flight", description = "API is used to FetchAll the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully all Flight fetched"),
			})
	@GetMapping("/fetchAllFlight")
	public ResponseStructureAll<Flight> fetchAllFlight() {
		return flightService.fetchAllFlight();
	}
	
	@Operation(summary = "Add Passenger To Existing Flight", description = "API is used to Add Passenger To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Passenger To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addExistingPassengerToExistingFlight")
	public ResponseStructure<Flight> addPassengerToExistingFlight(@RequestParam int passengerId,@RequestParam int flightId){
		return flightService.addExistingPassengerToExistingFlight(passengerId, flightId);
	}
	@Operation(summary = "Add Pilot To Existing Flight", description = "API is used to Add Pilot To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Pilot To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addExistingPilotToExistingFlight")
	public ResponseStructure<Flight> addPilotToExistingFlight(@RequestParam int pilotId,@RequestParam int flightId) {
		return flightService.addExistingPilotToExistingFlight(pilotId, flightId);
	}
	
	@Operation(summary = "Add Airhostess To Existing Flight", description = "API is used to Add Airhostess To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Airhostess To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addExistingAirhostessToExistingFlight")
	public ResponseStructure<Flight> addAirhostessToExistingFlight(@RequestParam int airhostessId,@RequestParam int flightId) {
		return flightService.addExistingAirhostessToExistingFlight(airhostessId, flightId);
	}
}
