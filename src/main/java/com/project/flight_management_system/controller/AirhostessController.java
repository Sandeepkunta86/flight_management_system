package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.service.AirhostessService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AirhostessController {
	@Autowired
	AirhostessService airhostessService;
	
	@Operation(summary = "Save Airhostess", description = "API is used to save the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Airhostess created"),
			@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	@PostMapping("/saveAirhostess")
	public ResponseStructure<Airhostess> saveAirhostess(@RequestBody Airhostess airhostess) {
		return airhostessService.saveAirhostess(airhostess);
	}
	
	@Operation(summary = "Fetch Airhostess", description = "API is used to Fetch the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Airhostess fetched"),
			@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	@GetMapping("/fetchAirhostessById")
	public ResponseStructure<Airhostess> fetchAirhostessById(@RequestParam int airhostessId) {
		return airhostessService.fetchAirhostessById(airhostessId);
	}
	
	@Operation(summary = "Delete Airhostess", description = "API is used to Delete the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Airhostess Deleted"),
			@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	@DeleteMapping("/deleteAirhostessById")
	public ResponseStructure<Airhostess> deleteAirhostessById(@RequestParam int airhostessId) {
		return airhostessService.deleteAirhostessById(airhostessId);	
	}
	
	@Operation(summary = "Update Airhostess", description = "API is used to Update the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Airhostess updated"),
			@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	@PutMapping("/updateAirhostessById")
	public ResponseStructure<Airhostess> updateAirhostessById(@RequestParam int oldAirhostessId,@RequestBody Airhostess newAirhostess) {
		return airhostessService.updateAirhostessById(oldAirhostessId, newAirhostess);
	}
	
	@Operation(summary = "FetchAll Airhostess", description = "API is used to FetchAll the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully all Airhostess fetched"),
		 })
	@GetMapping("/fetchAllAirhostess")
	public ResponseStructureAll<Airhostess> fetchAllAirhostess() {
		return airhostessService.fetchAllAirhostess();
	}
}
