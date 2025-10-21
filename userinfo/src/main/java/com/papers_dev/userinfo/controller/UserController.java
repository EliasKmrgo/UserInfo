package com.papers_dev.userinfo.controller;

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

import com.papers_dev.userinfo.dto.UserDTO;
import com.papers_dev.userinfo.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService UserService;
    
    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers() {
        List<UserDTO> allUsers = UserService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO UserDTO) {
        UserDTO UserAdded = UserService.addUserInDB(UserDTO);
        return new ResponseEntity<>(UserAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        return UserService.fetchUserById(id);
    }

}

