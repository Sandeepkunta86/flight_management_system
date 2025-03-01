package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.service.PassportService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PassportController {
	@Autowired
	PassportService passportService;
	
	@Operation(summary = "Save Passport", description = "API is used to Save Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Saved Passport"),
			 })
	@PostMapping("/savePassport")
	public ResponseStructure<Passport> savePassport(@RequestBody Passport passport) {
		return passportService.savePassport(passport);
	}

	@Operation(summary = "Fetch Passport", description = "API is used to fetch Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Fetched Passport"),
			@ApiResponse(responseCode = "404", description = "Passport not found for the given id") })
	@GetMapping("/fetchPassportById")
	public ResponseStructure<Passport> fetchPassportById(@RequestParam int passportId) {
		return passportService.fetchPassportById(passportId);
	}
	
	@Operation(summary = "Delete Passport", description = "API is used to Delete Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Deleted Passport"),
			@ApiResponse(responseCode = "404", description = "Passport not found for the given id") })
	@DeleteMapping("/deletePassportById")
	public ResponseStructure<Passport> deletePassportById(@RequestParam int passportId) {
		return passportService.deletePassportById(passportId);
	}

	@Operation(summary = "Update Passport", description = "API is used to Update Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Updated Passport"),
			@ApiResponse(responseCode = "404", description = "Passport not found for the given id") })
	@PutMapping("/updatePassportById")
	public ResponseStructure<Passport> updatePassportById(@RequestParam int oldPassportId,@RequestBody Passport newPassport) {
		return passportService.updatePassportById(oldPassportId, newPassport);
	}
	@Operation(summary = "FetchAll Passport", description = "API is used to FetchAll Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched All Passport"),
			@ApiResponse(responseCode = "404", description = "Passport not found for the given id") })
	@GetMapping("/fetchAllPassport ")
	public ResponseStructureAll<Passport> fetchAllPassport() {
		return passportService.fetchAllPassport();
	}
}
