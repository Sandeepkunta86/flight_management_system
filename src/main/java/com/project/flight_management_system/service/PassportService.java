package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PassportDao;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.exceptiom.PassportIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class PassportService {
	@Autowired
	PassportDao passportDao;

	@Autowired
	ResponseStructure<Passport> responseStructure;

	@Autowired
	ResponseStructureAll<Passport> responseStructureAll;

	public ResponseStructure<Passport> savePassport(Passport passport) {
		responseStructure.setMessage("Successfully Passport is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passportDao.savePassport(passport));
		return responseStructure;
	}

	public ResponseStructure<Passport> fetchPassportById(int passportId) {
		Passport passport = passportDao.fetchPassportById(passportId);
		if (passport != null) {
			responseStructure.setMessage("Successfully Passport is fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(passportDao.fetchPassportById(passportId));
			return responseStructure;
		} else {
			throw new PassportIdNotFound();
		}
	}

	public ResponseStructure<Passport> deletePassportById(int passportId) {
		Passport passport = passportDao.fetchPassportById(passportId);
		if(passport!=null) {
		responseStructure.setMessage("Successfully Passport is deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passportDao.deletePassportById(passportId));
		return responseStructure;
	} else {
		throw new PassportIdNotFound();
	}
}

	public ResponseStructure<Passport> updatePassportById(int oldPassportId, Passport newPassport) {
		Passport passport = passportDao.fetchPassportById(oldPassportId);
		if(passport!=null) {
		responseStructure.setMessage("Successfully Passport is updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passportDao.updatePassportById(oldPassportId, newPassport));
		return responseStructure;
	}else {
		throw new PassportIdNotFound();
	}
}

	public ResponseStructureAll<Passport> fetchAllPassport() {
		responseStructureAll.setMessage("Successfully Passport is updated in DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(passportDao.fetchAllPassport());
		return responseStructureAll;
	}
}
