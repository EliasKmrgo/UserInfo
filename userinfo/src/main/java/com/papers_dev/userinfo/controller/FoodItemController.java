package com.papers.foodcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papers.foodcatalogue.dto.FoodItemDTO;
import com.papers.foodcatalogue.service.FoodItemService;

@RestController
@RequestMapping("/foodItem")
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;
    
    @GetMapping("/fetchAllfoodItems")
    public ResponseEntity<List<FoodItemDTO>> fetchAllfoodItems() {
        List<FoodItemDTO> allfoodItems = foodItemService.findAllfoodItems();
        return new ResponseEntity<>(allfoodItems, HttpStatus.OK);
    }
    
    @PostMapping("/addfoodItem")
    public ResponseEntity<FoodItemDTO> savefoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO foodItemAdded = foodItemService.addfoodItemInDB(foodItemDTO);
        return new ResponseEntity<>(foodItemAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<FoodItemDTO> findfoodItemById(@PathVariable Long id) {
        return foodItemService.fetchfoodItemById(id);
    }

}

