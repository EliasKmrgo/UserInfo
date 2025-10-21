package com.papers_dev.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    FoodItemRepo foodItemRepo;

    public List<FoodItemDTO> findAllfoodItems() {
        List<FoodItem> foodItems = foodItemRepo.findAll();
        return foodItems.stream()
                .map(FoodItemMapper.INSTANCE::mapFoodItemToFoodItemDTO).collect(Collectors.toList());
    }

    public FoodItemDTO addfoodItemInDB(FoodItemDTO foodItemDTO) {
        FoodItem savafoodItem = 
            foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(savafoodItem);
    }

    public ResponseEntity<FoodItemDTO> fetchfoodItemById(Long id) {
        Optional<FoodItem> foodItem = foodItemRepo.findById(id);
        if (foodItem.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem.get()),
                HttpStatus.OK);
    }

}
