package com.linagora.openpaas.backend.webservice;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUserStepdefs {
    private UserSupport userSupport = new UserSupport();
    private int initial;
    

    @Given("^we have a number of user in the system$")
    public void user() throws Throwable {
    	initial = userSupport.findNumberUsers();
    }

    @When("^we create one user which does not exist$")
    public void createOneUser() throws Throwable {
        userSupport.createUser();
    }

    @Then("^there is one more user in the system$")
    public void oneMoreMessage() throws Throwable {
        int actualnumber = userSupport.findNumberUsers();
        assertThat(actualnumber, is(initial +1));
    }
}
