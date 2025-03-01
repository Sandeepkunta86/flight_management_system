package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PaymentDao;
import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.exceptiom.PaymentIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Payment> responseStructure;

	@Autowired
	ResponseStructureAll<Payment> responseStructureAll;

	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setMessage("Successfully Payment is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(paymentDao.savePayment(payment));
		return responseStructure;
	}

	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setMessage("Successfully Payment fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return responseStructure;
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setMessage("Successfully Payment deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.deletePaymentById(paymentId));
			return responseStructure;

		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		if (payment != null) {
			responseStructure.setMessage("Successfully Payment updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return responseStructure;
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseStructureAll<Payment> fetchAllPayment() {
		responseStructureAll.setMessage("Successfully Payments fetched from DB");
		responseStructureAll.setStatusCode(HttpStatus.OK.value());
		responseStructureAll.setData(paymentDao.fetchAllPayment());
		return responseStructureAll;
	}
}
