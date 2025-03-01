package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.PassengerRepo;

@Repository
public class PassengerDao {
	@Autowired
	PassengerRepo passengerRepo;

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

	public Passenger savePassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}

	public Passenger fetchPassengerById(int passengerId) {
		Optional<Passenger> passenger = passengerRepo.findById(passengerId);
		if (passenger.isPresent()) {
			return passenger.get();
		} else {
			return null;
		}

	}

	public Passenger deletePassengerById(int passengerId) {
		Passenger passenger = fetchPassengerById(passengerId);
		if (passenger != null) {
			passengerRepo.delete(passenger);
			return passenger;
		} else {
			return null;
		}
	}

	public Passenger updatePassengerById(int oldPassengerId, Passenger newPassenger) {
		Passenger passenger = fetchPassengerById(oldPassengerId);
		if (passenger != null) {
			newPassenger.setPassengerId(oldPassengerId);
			return savePassenger(newPassenger);
		} else {
			return null;
		}
	}

	public List<Passenger> fetchAllPassenger() {
		return passengerRepo.findAll();
	}

	public Passenger addExistingPassportforExistingPassenger(int passportId, int passengerId) {
		Passport passport = passportDao.fetchPassportById(passportId);
		if (passport != null) {
			Passenger passenger = fetchPassengerById(passengerId);
			if (passenger != null) {
				passenger.setPassport(passport);
				return passengerRepo.save(passenger);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Passenger addExistingSeatforExistingPassenger(int seatId, int passengerId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			Passenger passenger = fetchPassengerById(passengerId);
			if (passenger != null) {
				passenger.setSeat(seat);
				return passengerRepo.save(passenger);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Passenger addExistingAddressforExistingPassenger(int addressId, int passengerId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			Passenger passenger = fetchPassengerById(passengerId);
			if (passenger != null) {
				passenger.setAddress(address);
				return passengerRepo.save(passenger);

			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Passenger addExistingTicketToExistingPassenger(int ticketId, int passengerId) {
		Passenger passenger = fetchPassengerById(passengerId);
		if (passenger != null) {
			Ticket ticket = ticketDao.fetchTicketById(ticketId);
			if (ticket != null) {
				List<Ticket> list = passenger.getTickets();
				list.add(ticket);
				passenger.setTickets(list);
				return passengerRepo.save(passenger);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Passenger addExistingFoodToExistingPassenger(int foodId, int passengerId) {
		Passenger passenger = fetchPassengerById(passengerId);
		if (passenger != null) {
			Food food = foodDao.fetchFoodById(foodId);
			if (food != null) {
				List<Food> list = passenger.getFoods();
				list.add(food);
				passenger.setFoods(list);
				return passengerRepo.save(passenger);
			} else {
				return null;
			}

		} else {
			return null;
		}
	}
}
