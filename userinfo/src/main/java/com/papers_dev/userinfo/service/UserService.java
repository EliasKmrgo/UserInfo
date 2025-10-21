package com.papers_dev.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.papers_dev.userinfo.dto.UserDTO;
import com.papers_dev.userinfo.entity.User;
import com.papers_dev.userinfo.mapper.UserMapper;
import com.papers_dev.userinfo.repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::mapUserToUserDTO).collect(Collectors.toList());
    }

    public UserDTO addUserInDB(UserDTO userDTO) {
        User saveuser = 
            UserRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(saveuser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Long id) {
        Optional<User> user = UserRepo.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()),
                HttpStatus.OK);
    }

}
