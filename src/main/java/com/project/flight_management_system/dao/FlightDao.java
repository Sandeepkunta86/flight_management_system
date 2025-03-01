package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.repo.FlightRepo;

@Repository
public class FlightDao {
	@Autowired
	FlightRepo flightRepo;

	@Autowired
	PassengerDao passengerDao;

	@Autowired
	PilotDao pilotDao;

	@Autowired
	AirhostessDao airhostessDao;

	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}

	public Flight fetchFlightById(int flightId) {
		Optional<Flight> flight = flightRepo.findById(flightId);
		if (flight.isPresent()) {
			return flight.get();
		} else {
			return null;
		}
	}

	public Flight deleteFlightById(int flightId) {
		Flight flight = fetchFlightById(flightId);
		if (flight != null) {
			flightRepo.delete(flight);
			return flight;
		} else {
			return null;
		}
	}

	public Flight updateFlightById(int oldFlightId, Flight newFlight) {
		Flight flight = fetchFlightById(oldFlightId);
		if (flight != null) {
			newFlight.setFlightId(oldFlightId);
			return saveFlight(newFlight);
		} else {
			return null;
		}
	}

	public List<Flight> fetchAllFlight() {
		return flightRepo.findAll();
	}

	public Flight addExistingPassengerToExistingFlight(int passengerId, int flightId) {
		Flight flight = fetchFlightById(flightId);
		if (flight != null) {
			Passenger passenger = passengerDao.fetchPassengerById(passengerId);
			if (passenger != null) {
				List<Passenger> list = flight.getPassengers();
				list.add(passenger);
				flight.setPassengers(list);
				return flightRepo.save(flight);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Flight addExistingPilotToExistingFlight(int pilotId, int flightId) {
		Flight flight = fetchFlightById(flightId);
		if (flight != null) {
			Pilot pilot = pilotDao.fetchPilotById(pilotId);
			if (pilot != null) {
				List<Pilot> list = flight.getPilots();
				list.add(pilot);
				flight.setPilots(list);
				return flightRepo.save(flight);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Flight addExistingAirhostessToExistingFlight(int airhostessId, int flightId) {
		Flight flight = fetchFlightById(flightId);
		if (flight != null) {
			Airhostess Airhostess = airhostessDao.fetchAirhostessById(airhostessId);
			if (Airhostess != null) {
				List<Airhostess> list = flight.getAirhostesses();
				list.add(Airhostess);
				flight.setAirhostesses(list);
				return flightRepo.save(flight);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
