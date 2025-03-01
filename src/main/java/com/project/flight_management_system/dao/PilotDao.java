package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.repo.PilotRepo;

@Repository
public class PilotDao {
	@Autowired
	PilotRepo pilotRepo;

	public Pilot savePilot(Pilot pilot) {
		return pilotRepo.save(pilot);
	}

	public Pilot fetchPilotById(int pilotId) {
		Optional<Pilot> pilot = pilotRepo.findById(pilotId);
		if (pilot.isPresent()) {
			return pilot.get();
		} else {
			return null;
		}
	}

	public Pilot deletePilotById(int pilotId) {
		Pilot pilot = fetchPilotById(pilotId);
		if (pilot != null) {
			pilotRepo.delete(pilot);
			return pilot;
		} else {
			return null;
		}
	}

	public Pilot updatePilotById(int oldPilotId, Pilot newPilot) {
		Pilot pilot = fetchPilotById(oldPilotId);
		if (pilot != null) {
			newPilot.setPilotId(oldPilotId);
			return savePilot(newPilot);
		} else {
			return null;
		}
	}

	public List<Pilot> fetchAllPilot() {
		return pilotRepo.findAll();
	}
}
