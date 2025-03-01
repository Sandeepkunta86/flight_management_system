package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.repo.AirhostessRepo;

@Repository
public class AirhostessDao {
	@Autowired
	AirhostessRepo airhostessRepo;

	public Airhostess saveAirhostess(Airhostess airhostess) {
		return airhostessRepo.save(airhostess);
	}

	public Airhostess fetchAirhostessById(int airhostessId) {
		Optional<Airhostess> airhostess = airhostessRepo.findById(airhostessId);
		if (airhostess.isPresent()) {
			return airhostess.get();
		} else {
			return null;
		}
	}

	public Airhostess deleteAirhostessById(int airhostessId) {
		Airhostess airhostess = fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			airhostessRepo.delete(airhostess);
			return airhostess;
		} else {
			return null;
		}
	}

	public Airhostess updateAirhostessById(int oldAirhostessId, Airhostess newAirhostess) {
		Airhostess airhostess = fetchAirhostessById(oldAirhostessId);
		if (airhostess != null) {
			newAirhostess.setAirhostessId(oldAirhostessId);
			return saveAirhostess(newAirhostess);
		} else {
			return null;
		}
	}

	public List<Airhostess> fetchAllAirhostess() {
		return airhostessRepo.findAll();
	}
}
