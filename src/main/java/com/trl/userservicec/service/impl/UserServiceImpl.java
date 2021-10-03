package com.trl.userservicec.service.impl;

import com.trl.userservicec.converter.TypeConverter;
import com.trl.userservicec.dto.UserDto;
import com.trl.userservicec.entity.UserEntity;
import com.trl.userservicec.repository.UserRepository;
import com.trl.userservicec.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final TypeConverter<UserEntity, UserDto> converter;
    private final UserRepository repository = new UserRepository();

    public UserServiceImpl(final TypeConverter<UserEntity, UserDto> converter) {
        this.converter = converter;
    }

    @Override
    public UserDto getById(Integer id) {
        return converter.convert(repository.getUsers(id));
    }

    @Override
    public List<UserDto> getAll() {
        return converter.convert(repository.getAllUsers());
    }

}
