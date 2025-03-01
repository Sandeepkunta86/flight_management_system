package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.repo.AirportRepo;
import com.project.flight_management_system.repo.FlightRepo;

@Repository
public class AirportDao {
	@Autowired
	AirportRepo airportRepo;

	@Autowired
	AddressDao addressDao;

	@Autowired
	FlightDao flightDao;

	@Autowired
	FlightRepo flightRepo;

	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}

	public Airport fetchAirportById(int airportId) {
		Optional<Airport> airport = airportRepo.findById(airportId);
		if (airport.isPresent()) {
			return airport.get();
		} else {
			return null;
		}
	}

	public Airport deleteAirportById(int airportId) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			airportRepo.delete(airport);
			return airport;
		} else {
			return null;
		}
	}

	public Airport updateAirportById(int oldAirportId, Airport newAirport) {
		Optional<Airport> airport = airportRepo.findById(oldAirportId);
		if (airport.isPresent()) {
			newAirport.setAirportId(oldAirportId);
			return saveAirport(newAirport);
		} else {
			return null;
		}
	}

	public List<Airport> fetchAllAirport() {
		return airportRepo.findAll();
	}

	public Airport addExistingAddressToExistingAirport(int addressId, int airportId) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				airport.setAddress(address);
				return airportRepo.save(airport);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Airport addExistingFlightForExistingAirport(int flightId, int airportId) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			Flight flight = flightDao.fetchFlightById(flightId);
			if (flight != null) {
				List<Flight> list = airport.getFlights();
				list.add(flight);
				airport.setFlights(list);
				return saveAirport(airport);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Airport addNewFlightForExistingAirport(int airportId, Flight newFlight) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			List<Flight> list = airport.getFlights();
			list.add(newFlight);
			airport.setFlights(list);
			return saveAirport(airport);
		} else {
			return null;
		}
	}

	public Airport addNewAddressForExistingAirport(int airportId, Address newAddress) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			airport.setAddress(newAddress);
			return saveAirport(airport);
		} else {
			return null;
		}
	}

}
