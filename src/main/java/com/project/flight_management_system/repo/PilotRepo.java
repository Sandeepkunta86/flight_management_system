package com.project.flight_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.flight_management_system.dto.Pilot;

public interface PilotRepo extends JpaRepository<Pilot, Integer> {

}
