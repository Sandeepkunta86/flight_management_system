package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AirhostessDao;
import com.project.flight_management_system.dao.FlightDao;
import com.project.flight_management_system.dao.PassengerDao;
import com.project.flight_management_system.dao.PilotDao;
import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.exceptiom.AirhostessIdNotFound;
import com.project.flight_management_system.exceptiom.FlightIdNotFound;
import com.project.flight_management_system.exceptiom.PassengerIdNotFound;
import com.project.flight_management_system.exceptiom.PilotIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class FlightService {
	@Autowired
	FlightDao flightDao;

	@Autowired
	PassengerDao passengerDao;

	@Autowired
	PilotDao pilotDao;

	@Autowired
	AirhostessDao airhostessDao;

	@Autowired
	ResponseStructure<Flight> responseStructure;

	@Autowired
	ResponseStructureAll<Flight> responseStructureAll;

	public ResponseStructure<Flight> saveFlight(Flight flight) {
		responseStructure.setMessage("Successfully Flight is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.saveFlight(flight));
		return responseStructure;
	}

	public ResponseStructure<Flight> fetchFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Successfully Flight is Fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(flightDao.fetchFlightById(flightId));
			return responseStructure;
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> deleteFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Successfully Flight is Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.deleteFlightById(flightId));
			return responseStructure;
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> updateFlightById(int oldFlightId, Flight newFlight) {
		Flight flight = flightDao.fetchFlightById(oldFlightId);
		if (flight != null) {
			responseStructure.setMessage("Successfully Flight is Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.updateFlightById(oldFlightId, newFlight));
			return responseStructure;

		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructureAll<Flight> fetchAllFlight() {
		responseStructureAll.setMessage("Successfully Flights fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(flightDao.fetchAllFlight());
		return responseStructureAll;
	}

	public ResponseStructure<Flight> addExistingPassengerToExistingFlight(int passengerId, int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Passenger passenger = passengerDao.fetchPassengerById(passengerId);
			if (passenger != null) {
				responseStructure.setMessage("Successfully Existing passenger added to existing Flight");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExistingPassengerToExistingFlight(passengerId, flightId));
				return responseStructure;

			} else {
				throw new PassengerIdNotFound();
			}
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> addExistingPilotToExistingFlight(int pilotId, int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Pilot pilot = pilotDao.fetchPilotById(pilotId);
			if (pilot != null) {
				responseStructure.setMessage("Successfully Existing pilot added to existing Flight");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExistingPilotToExistingFlight(pilotId, flightId));
				return responseStructure;
			} else {
				throw new PilotIdNotFound();
			}
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> addExistingAirhostessToExistingFlight(int airhostessId, int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
			if (airhostess != null) {
				responseStructure.setMessage("Successfully Existing Airhostess added to existing Flight");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExistingAirhostessToExistingFlight(airhostessId, flightId));
				return responseStructure;

			} else {
				throw new AirhostessIdNotFound();
			}
		} else {
			throw new FlightIdNotFound();
		}
	}
}
