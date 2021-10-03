package com.trl.userservicec.api.v1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trl.userservicec.config.ApiVersion;
import com.trl.userservicec.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = UserController.BASE_URL
)
@Validated
public class UserController {

    public static final String BASE_URL = ApiVersion.VERSION_1_0 + "/users";

    private final UserService service;

    private final ObjectMapper objectMapper;

    public UserController(final UserService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/{userId:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserById(@PathVariable(name = "userId") Long userId) throws JsonProcessingException {
        return objectMapper.writeValueAsString(service.getById(userId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers() throws JsonProcessingException {
        return objectMapper.writeValueAsString(service.getAll());
    }

}
