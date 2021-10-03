package com.trl.userservicec.converter.impl;

import com.trl.userservicec.converter.TypeConverter;
import com.trl.userservicec.dto.UserDto;
import com.trl.userservicec.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserEntityConverter implements TypeConverter<UserDto, UserEntity> {

    private final ModelMapper modelMapper;

    public UserDtoToUserEntityConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Class<UserDto> getSourceClass() {
        return UserDto.class;
    }

    @Override
    public Class<UserEntity> getTargetClass() {
        return UserEntity.class;
    }

    @Override
    public UserEntity convert(UserDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

}

