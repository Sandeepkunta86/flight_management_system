package com.project.flight_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.flight_management_system.dto.Food;

public interface FoodRepo extends JpaRepository<Food, Integer>{

}
