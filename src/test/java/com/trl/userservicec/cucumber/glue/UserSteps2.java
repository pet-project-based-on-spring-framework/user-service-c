package com.trl.userservicec.cucumber.glue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trl.userservicec.AbstractIntegrationTest;
import com.trl.userservicec.converter.TypeConverter;
import com.trl.userservicec.dto.UserDto;
import com.trl.userservicec.entity.UserEntity;
import com.trl.userservicec.repository.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSteps2 extends AbstractIntegrationTest {

    private List<UserDto> expectedUsers = new ArrayList<>();
    private List<UserDto> actualUsers = new ArrayList<>();

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TypeConverter<UserDto, UserEntity> converter;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Given("^the all users$")
    public void givenTheAllUsers(final List<UserDto> users) {

        expectedUsers.addAll(users);
        repository.saveAll(converter.convert(users));
    }

    @When("^the webClient requests all the users$")
    public void whenTheWebClientRequestsAllTheUsers() throws Exception {
        final String url = "/v1.0/users";
        final String body = testRestTemplate.getForEntity(url, String.class).getBody();


        final UserDto[] userDtos = objectMapper.readValue(body, UserDto[].class);

//        actualUsers.addAll(Arrays.asList(userDtos));

    }

    @Then("^all the users are returned$")
    public void thenAllTheUsersAreReturned() {
        assertThat(actualUsers).isEqualTo(expectedUsers);
    }

}
