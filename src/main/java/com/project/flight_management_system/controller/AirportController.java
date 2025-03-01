package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.service.AirportService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
public class AirportController {
	@Autowired
	AirportService airportService;
	
	@Operation(summary = "Save Airport", description = "API is used to save the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport created"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PostMapping("/saveAirport")
	public ResponseStructure<Airport> saveAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}
	
	
	@Operation(summary = "Fetch Airport", description = "API is used to Fetch the Airport based on Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport is fetched"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@GetMapping("/fetchAirportById")
	public ResponseStructure<Airport> fetchAirportById(@RequestParam int airportId) {
		return airportService.fetchAirportById(airportId);
	}

	@Operation(summary = "Delete Airport", description = "API is used to Delete the Airport based on Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport is Deleted"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@DeleteMapping("/deleteAirportById")
	public ResponseStructure<Airport> deleteAirportById(@RequestParam int airportId) {
		return airportService.deleteAirportById(airportId);
	}

	
	@Operation(summary = "Update Airport", description = "API is used to Update the Airport based on Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport is Updated"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/updateAirportById")
	public ResponseStructure<Airport> updateAirportById(@RequestParam int oldAirportId,@RequestBody Airport newAirport) {
		return airportService.updateAirportById(oldAirportId, newAirport);
	}
	
	@Operation(summary = "FetchAll Airport", description = "API is used to FetchAll Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  airports fetched") })
	@GetMapping("/fetchAllAirport")
	public ResponseStructureAll<Airport> fetchAllAirport() {
		return airportService.fetchAllAirport();
	}
	
	
	@Operation(summary = "Add Existing Address To Existing Airport", description = "API is used to Add Existing Address To Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Added Existing Address To Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/addExistingAddressToExistingAirport")
	public ResponseStructure<Airport> addExistingAddressToExistingAirport(@RequestParam int addressId,@RequestParam int airportId) {
		return airportService.addExistingAddressToExistingAirport(addressId, airportId);
	}
	
	@Operation(summary = "Add Existing Flight For Existing Airport", description = "API is used to Add Existing Flight For Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added Existing Flight For Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/addExistingFlightForExistingAirport")
	public ResponseStructure<Airport> addExistingFlightForExistingAirport(@RequestParam int flightId,@RequestParam int airportId) {
		return airportService.addExistingFlightForExistingAirport(flightId, airportId);
	}
	
	@Operation(summary = "Add New Flight For Existing Airport", description = "API is used to Add New Flight For Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added New Flight For Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/addNewFlightForExistingAirport")
	public ResponseStructure<Airport> addNewFlightForExistingAirport(@RequestParam int airportId,@RequestBody Flight newFlight) {
		return airportService.addNewFlightForExistingAirport(airportId, newFlight);
	}
	
	@Operation(summary = "Add New Address For Existing Airport", description = "API is used to Add New Address For Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Added New Ad For Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/addNewAddressForExistingAirport")
	public ResponseStructure<Airport> addNewAddressForExistingAirport(@RequestParam int airportId,@RequestBody Address newAddress) {
		return airportService.addNewAddressForExistingAirport(airportId, newAddress);
	}
}
