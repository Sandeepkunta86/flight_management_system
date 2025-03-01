package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AddressDao;
import com.project.flight_management_system.dao.FoodDao;
import com.project.flight_management_system.dao.PassengerDao;
import com.project.flight_management_system.dao.PassportDao;
import com.project.flight_management_system.dao.SeatDao;
import com.project.flight_management_system.dao.TicketDao;
import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.exceptiom.AddressIdNotFound;
import com.project.flight_management_system.exceptiom.FoodIdNotFound;
import com.project.flight_management_system.exceptiom.PassengerIdNotFound;
import com.project.flight_management_system.exceptiom.PassportIdNotFound;
import com.project.flight_management_system.exceptiom.SeatIdNotFound;
import com.project.flight_management_system.exceptiom.TicketIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class PassengerService {
	@Autowired
	PassengerDao passengerDao;

	@Autowired
	PassportDao passportDao;

	@Autowired
	SeatDao seatDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	TicketDao ticketDao;

	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Passenger> responseStructure;

	@Autowired
	ResponseStructureAll<Passenger> responseStructureAll;

	public ResponseStructure<Passenger> savePassenger(Passenger passenger) {
		responseStructure.setMessage("Successfully Passenger is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.savePassenger(passenger));
		return responseStructure;
	}

	public ResponseStructure<Passenger> fetchPassengerById(int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {

			responseStructure.setMessage("Successfully Passenger is fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(passengerDao.fetchPassengerById(passengerId));
			return responseStructure;
		} else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructure<Passenger> deletePassengerById(int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			responseStructure.setMessage("Successfully Passenger is deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passengerDao.deletePassengerById(passengerId));
			return responseStructure;

		} else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructure<Passenger> updatePassengerById(int oldPassengerId, Passenger newPassenger) {
		Passenger passenger = passengerDao.fetchPassengerById(oldPassengerId);
		if (passenger != null) {
			responseStructure.setMessage("Successfully Passenger is updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passengerDao.updatePassengerById(oldPassengerId, newPassenger));
			return responseStructure;
		} else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructureAll<Passenger> fetchAllPassenger() {
		responseStructureAll.setMessage("Successfully Passenger is updated in DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(passengerDao.fetchAllPassenger());
		return responseStructureAll;
	}

	public ResponseStructure<Passenger> addExistingPassportforExistingPassenger(int passportId, int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			Passport passport = passportDao.fetchPassportById(passportId);
			if (passport != null) {
				responseStructure.setMessage("Successfully Existing Passport is added to existing Passenger");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure
						.setData(passengerDao.addExistingPassportforExistingPassenger(passportId, passengerId));
				return responseStructure;
			} else {
				throw new PassportIdNotFound();
			}
		} else {
			throw new PassengerIdNotFound();

		}
	}

	public ResponseStructure<Passenger> addExistingSeatforExistingPassenger(int seatId, int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			Seat seat = seatDao.fetchSeatById(seatId);
			if (seat != null) {
				responseStructure.setMessage("Successfully Existing Seat is added to existing Passenger");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(passengerDao.addExistingSeatforExistingPassenger(seatId, passengerId));
				return responseStructure;
			} else {
				throw new SeatIdNotFound();
			}
		} else {
			throw new PassengerIdNotFound();

		}
	}

	public ResponseStructure<Passenger> addExistingAddressforExistingPassenger(int addressId, int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				responseStructure.setMessage("Successfully Existing Address is added to existing Passenger");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(passengerDao.addExistingAddressforExistingPassenger(addressId, passengerId));
				return responseStructure;
			} else {
				throw new AddressIdNotFound();
			}
		} else {
			throw new PassengerIdNotFound();

		}
	}

	public ResponseStructure<Passenger> addExistingTicketToExistingPassenger(int ticketId, int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			Ticket ticket = ticketDao.fetchTicketById(ticketId);
			if (ticket != null) {
				responseStructure.setMessage("Successfully Existing Ticket is added to existing Passenger");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(passengerDao.addExistingTicketToExistingPassenger(ticketId, passengerId));
				return responseStructure;
			} else {
				throw new TicketIdNotFound();
			}
		} else {
			throw new PassengerIdNotFound();

		}
	}

	public ResponseStructure<Passenger> addExistingFoodToExistingPassenger(int foodId, int passengerId) {
		Passenger passenger = passengerDao.fetchPassengerById(passengerId);
		if (passenger != null) {
			Food food = foodDao.fetchFoodById(foodId);
			if (food != null) {
				responseStructure.setMessage("Successfully Existing Food is added to existing Passenger");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(passengerDao.addExistingFoodToExistingPassenger(foodId, passengerId));
				return responseStructure;
			} else {
				throw new FoodIdNotFound();
			}
		} else {
			throw new PassengerIdNotFound();

		}
	}

}
