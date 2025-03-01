package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AddressDao;
import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.exceptiom.AddressIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructureAll<Address> responseStructureAll;

	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("successfully address is saved in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("successfully address is fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("successfully address is deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setMessage("successfully address is updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return responseStructure;
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructureAll<Address> fetchAllAddress() {
		responseStructureAll.setMessage("successfully all the addresses fetched from DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(addressDao.fetchAllAddress());
		return responseStructureAll;
	}

}
