package com.papers_dev.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.papers_dev.userinfo.dto.UserDTO;
import com.papers_dev.userinfo.entity.User;


@Mapper

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO(User user);
}
