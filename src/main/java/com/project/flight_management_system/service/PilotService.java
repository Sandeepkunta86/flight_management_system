package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PilotDao;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.exceptiom.PilotIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class PilotService {
	@Autowired
	PilotDao pilotDao;
	@Autowired
	ResponseStructure<Pilot> responseStructure;

	@Autowired
	ResponseStructureAll<Pilot> responseStructureAll;

	public ResponseStructure<Pilot> savePilot(Pilot pilot) {
		responseStructure.setMessage("Successfully Pilot is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(pilotDao.savePilot(pilot));
		return responseStructure;
	}

	public ResponseStructure<Pilot> fetchPilotById(int pilotId) {
		Pilot pilot = pilotDao.fetchPilotById(pilotId);
		if (pilot != null) {
			responseStructure.setMessage("Successfully Pilot is Fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(pilotDao.fetchPilotById(pilotId));
			return responseStructure;

		} else {
			throw new PilotIdNotFound();
		}
	}

	public ResponseStructure<Pilot> deletePilotById(int pilotId) {
		Pilot pilot = pilotDao.fetchPilotById(pilotId);
		if (pilot != null) {
			responseStructure.setMessage("Successfully Pilot is Deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pilotDao.deletePilotById(pilotId));
			return responseStructure;
		} else {
			throw new PilotIdNotFound();
		}
	}

	public ResponseStructure<Pilot> updatePilotById(int oldPilotId, Pilot newPilot) {
		Pilot pilot = pilotDao.fetchPilotById(oldPilotId);
		if (pilot != null) {
			responseStructure.setMessage("Successfully Pilot is updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pilotDao.updatePilotById(oldPilotId, newPilot));
			return responseStructure;
		} else {
			throw new PilotIdNotFound();
		}
	}

	public ResponseStructureAll<Pilot> fetchAllPilot() {
		responseStructureAll.setMessage("Successfully Pilots fetched from DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(pilotDao.fetchAllPilot());
		return responseStructureAll;
	}
}
