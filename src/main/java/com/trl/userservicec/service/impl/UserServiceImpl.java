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

    private final UserRepository repository;
    private final TypeConverter<UserEntity, UserDto> converter;

    public UserServiceImpl(final TypeConverter<UserEntity, UserDto> converter, UserRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public UserDto getById(Long id) {
        return converter.convert(repository.findById(id).get());
    }

    @Override
    public List<UserDto> getAll() {
        return converter.convert(repository.findAll());
    }

}
