package com.trl.userservicec.converter.impl;

import com.trl.userservicec.converter.TypeConverter;
import com.trl.userservicec.dto.UserDto;
import com.trl.userservicec.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDtoConverter implements TypeConverter<UserEntity, UserDto> {

    private final ModelMapper modelMapper;

    public UserEntityToUserDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Class<UserEntity> getSourceClass() {
        return UserEntity.class;
    }

    @Override
    public Class<UserDto> getTargetClass() {
        return UserDto.class;
    }

    @Override
    public UserDto convert(UserEntity entity) {
        return modelMapper.map(entity, UserDto.class);
    }

}

