package com.trl.userservicec.service;

import com.trl.userservicec.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAll();
}

