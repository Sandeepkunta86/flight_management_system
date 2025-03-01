package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AddressDao;
import com.project.flight_management_system.dao.AirportDao;
import com.project.flight_management_system.dao.FlightDao;
import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.exceptiom.AddressIdNotFound;
import com.project.flight_management_system.exceptiom.AirportIdNotFound;
import com.project.flight_management_system.exceptiom.FlightIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AirportService {
	@Autowired
	AirportDao airportDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	FlightDao flightDao;

	@Autowired
	ResponseStructure<Airport> responseStructure;

	@Autowired
	ResponseStructureAll<Airport> responseStructureAll;

	public ResponseStructure<Airport> saveAirport(Airport airport) {
		responseStructure.setMessage("Successfully Airport saved in Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airportDao.saveAirport(airport));
		return responseStructure;
	}

	public ResponseStructure<Airport> fetchAirportById(int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("successfully Airport is fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airportDao.fetchAirportById(airportId));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> deleteAirportById(int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("successfully Airport is deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.deleteAirportById(airportId));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> updateAirportById(int oldAirportId, Airport newAirport) {
		Airport airport = airportDao.fetchAirportById(oldAirportId);
		if (airport != null) {
			responseStructure.setMessage("successfully Airport is Updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.updateAirportById(oldAirportId, newAirport));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructureAll<Airport> fetchAllAirport() {
		responseStructureAll.setMessage("Successfully fetched all the airports from DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(airportDao.fetchAllAirport());
		return responseStructureAll;
	}

	public ResponseStructure<Airport> addExistingAddressToExistingAirport(int addressId, int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				responseStructure.setMessage("Successfully added existing address to existing Airport");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(airportDao.addExistingAddressToExistingAirport(addressId, airportId));
				return responseStructure;
			} else {
				throw new AddressIdNotFound();
			}
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> addExistingFlightForExistingAirport(int flightId, int airportId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Airport airport = airportDao.fetchAirportById(airportId);
			if (airport != null) {
				responseStructure.setMessage("Successfully added existing Flight to existing Airpor");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(airportDao.addExistingFlightForExistingAirport(flightId, airportId));
				return responseStructure;
			} else {
				throw new AirportIdNotFound();
			}
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Airport> addNewFlightForExistingAirport(int airportId, Flight newFlight) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Successfully added New Flight to existing Airpor");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.addNewFlightForExistingAirport(airportId, newFlight));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> addNewAddressForExistingAirport(int airportId, Address newAddress) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Successfully added New Address to existing Airpor");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.addNewAddressForExistingAirport(airportId, newAddress));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

}
