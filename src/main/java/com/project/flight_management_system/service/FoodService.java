package com.project.flight_management_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.FoodDao;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.exceptiom.FoodIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;

	@Autowired
	ResponseStructureAll<Food> responseStructureAll;
	
	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setMessage("Successfully Food is Saved In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.saveFood(food));
		return responseStructure;
		
	}

	public ResponseStructure<Food> fetchFoodById(int foodId) {
		Food food=foodDao.fetchFoodById(foodId);
		if(food!= null) {
		responseStructure.setMessage("Successfully Food is Fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(foodDao.fetchFoodById(foodId));
		return responseStructure;
		
	}else {
		throw new FoodIdNotFound();
	}
	}

	public ResponseStructure<Food> deleteFoodById(int foodId) {
		Food food=foodDao.fetchFoodById(foodId);
		if(food!= null) {
		responseStructure.setMessage("Successfully Food is deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return responseStructure;
		
	}else {
		throw new FoodIdNotFound();
	}
	}

	public ResponseStructure<Food> updateFoodById(int oldFoodId, Food newFood) {
		Food food=foodDao.fetchFoodById(oldFoodId);
		if(food!= null) {
		responseStructure.setMessage("Successfully Food is updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
		return responseStructure;
	}else {
		throw new FoodIdNotFound();
	}
	}


	public ResponseStructureAll<Food> fetchAllFood() {
		responseStructureAll.setMessage("successfully foods are fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(foodDao.fetchAllFood());
		return responseStructureAll;
	}
}
