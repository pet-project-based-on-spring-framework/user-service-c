package com.trl.userservicec.cucumber.glue;

import com.trl.userservicec.dto.UserDto;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserSteps {

    private List<UserDto> expectedUsers;
    private List<UserDto> actualUsers;

    @Before
    void setUp() {
        expectedUsers = new ArrayList<>();
        actualUsers = new ArrayList<>();
    }

    @Before


    @Given("^the all users$")
    public void givenTheAllUsers(final List<UserDto> users) {
        System.out.println("************************** " + users);
    }

    @When("^the webClient requests all the users$")
    public void whenTheWebClientRequestsAllTheUsers() {
    }

    @Then("^all the users are returned$")
    public void thenAllTheUsersAreReturned() {
    }
}
