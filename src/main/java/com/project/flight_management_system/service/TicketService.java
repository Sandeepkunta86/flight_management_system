package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PaymentDao;
import com.project.flight_management_system.dao.TicketDao;
import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.exceptiom.PaymentIdNotFound;
import com.project.flight_management_system.exceptiom.TicketIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Ticket> responseStructure;

	@Autowired
	ResponseStructureAll<Ticket> responseStructureAll;

	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setMessage("Successfully Ticket is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setMessage("Successfully Ticket is Fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ticketDao.fetchTicketById(ticketId));
			return responseStructure;
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setMessage("Successfully Ticket is deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.deleteTicketById(ticketId));
			return responseStructure;
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
		Ticket ticket = ticketDao.fetchTicketById(oldTicketId);
		if (ticket != null) {
			responseStructure.setMessage("Successfully Ticket is updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
			return responseStructure;
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseStructureAll<Ticket> fetchAllTicket() {
		responseStructureAll.setMessage("Successfully Tickets are fetched from DB");
		responseStructureAll.setStatusCode(HttpStatus.OK.value());
		responseStructureAll.setData(ticketDao.fetchAllTicket());
		return responseStructureAll;
	}

	public ResponseStructure<Ticket> addPaymentForExistingTicket(int paymentId, int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			Payment payment = paymentDao.fetchPaymentById(paymentId);
			if (payment != null) {
				responseStructure.setMessage("Successfully existing payment is added to existing Ticket");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(ticketDao.addPaymentForExistingTicket(paymentId, ticketId));
				return responseStructure;
			} else {
				throw new PaymentIdNotFound();
			}
		} else {
			throw new TicketIdNotFound();
		}
	}
}
