package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;

	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}

	public Food fetchFoodById(int foodId) {
		Optional<Food> food = foodRepo.findById(foodId);
		if (food.isPresent()) {
			return food.get();
		} else {
			return null;
		}
	}

	public Food deleteFoodById(int foodId) {
		Food food = fetchFoodById(foodId);
		if (food != null) {
			foodRepo.delete(food);
			return food;
		} else {
			return null;
		}
	}

	public Food updateFoodById(int oldFoodId, Food newFood) {
		Food food = fetchFoodById(oldFoodId);
		if (food != null) {
			newFood.setFoodId(oldFoodId);
			return saveFood(newFood);
		} else {
			return null;
		}
	}

	public List<Food> fetchAllFood() {
		return foodRepo.findAll();
	}

}
