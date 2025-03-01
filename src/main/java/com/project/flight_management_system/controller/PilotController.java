package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.service.PilotService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PilotController {
	@Autowired
	PilotService pilotService;
	
	@Operation(summary = "Save Pilot", description = "API is used to  save pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved Pilot"),
			 })
	@PostMapping("/savePilot")
	public ResponseStructure<Pilot> savePilot(@RequestBody Pilot pilot) {
		return pilotService.savePilot(pilot);
	}

	@Operation(summary = "Fetch Pilot", description = "API is used to  fetch pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Fetched Pilot"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@GetMapping("/fetchPilotById")
	public ResponseStructure<Pilot> fetchPilotById(@RequestParam int pilotId) {
		return pilotService.fetchPilotById(pilotId);
	}

	@Operation(summary = "Delete Pilot", description = "API is used to  Delete pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted Pilot"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@DeleteMapping("/deletePilotById")
	public ResponseStructure<Pilot> deletePilotById(@RequestParam int pilotId) {
		return pilotService.deletePilotById(pilotId);
	}

	@Operation(summary = "Update Pilot", description = "API is used to  Upadted pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Updated Pilot"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@PutMapping("/updatePilotById")
	public ResponseStructure<Pilot> updatePilotById(@RequestParam int oldPilotId,@RequestBody Pilot newPilot) {
		
		return pilotService.updatePilotById(oldPilotId, newPilot);
	}

	@Operation(summary = "FetchAll Pilot", description = "API is used to  fetchAll pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully FetchedAll Pilot"),
			})
	@GetMapping("/fetchAllPilot")
	public ResponseStructureAll<Pilot> fetchAllPilot() {
		return pilotService.fetchAllPilot();
	}
}
