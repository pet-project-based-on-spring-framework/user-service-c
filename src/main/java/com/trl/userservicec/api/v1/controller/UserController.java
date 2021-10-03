package com.trl.userservicec.api.v1.controller;

import com.trl.userservicec.config.ApiVersion;
import com.trl.userservicec.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/{userId:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserById(@PathVariable(name = "userId") Integer userId) {
        return service.getById(userId).toString();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers() {
        return service.getAll().toString();
    }

}
