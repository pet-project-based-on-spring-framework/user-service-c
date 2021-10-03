package com.trl.userservicec.repository;

import com.trl.userservicec.entity.UserEntity;

import java.util.List;

public class UserRepository {

    private List<UserEntity> users = List.of(
            new UserEntity(1, "Carlos", "Lopez"),
            new UserEntity(2, "Julian", "Lopez"),
            new UserEntity(3, "Maria", "Lopez")
    );

    public UserEntity getUsers(final Integer id) {
        return users.get(id);
    }

    public List<UserEntity> getAllUsers() {
        return users;
    }

}
