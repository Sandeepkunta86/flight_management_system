package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AirhostessDao;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.exceptiom.AirhostessIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AirhostessService {
	@Autowired
	AirhostessDao airhostessDao;

	@Autowired
	ResponseStructure<Airhostess> responseStructure;

	@Autowired
	ResponseStructureAll<Airhostess> responseStructureAll;

	public ResponseStructure<Airhostess> saveAirhostess(Airhostess airhostess) {
		responseStructure.setMessage("Successfully Airhostess saved in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(airhostessDao.saveAirhostess(airhostess));
		return responseStructure;
	}

	public ResponseStructure<Airhostess> fetchAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully Airhostess  Fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airhostessDao.fetchAirhostessById(airhostessId));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructure<Airhostess> deleteAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully Airhostess  deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.deleteAirhostessById(airhostessId));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructure<Airhostess> updateAirhostessById(int oldAirhostessId, Airhostess newAirhostess) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(oldAirhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully Airhostess Updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.updateAirhostessById(oldAirhostessId, newAirhostess));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructureAll<Airhostess> fetchAllAirhostess() {
		responseStructureAll.setMessage("Successfully Airhostess Updated in DB");
		responseStructureAll.setStatusCode(HttpStatus.OK.value());
		responseStructureAll.setData(airhostessDao.fetchAllAirhostess());
		return responseStructureAll;

	}
}
