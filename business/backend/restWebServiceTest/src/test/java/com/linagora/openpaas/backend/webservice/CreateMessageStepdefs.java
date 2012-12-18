package com.linagora.openpaas.backend.webservice;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateMessageStepdefs {
    private MessageSupport messageSupport = new MessageSupport();
    private int initial;
    

    @Given("^user has already a current number of message to send$")
    public void user() {
    	initial = messageSupport.getMessagesNumber();
    }

    @When("^user creates one new message$")
    public void createOneMessage() {
        messageSupport.createMessage();
    }

    @Then("^there is one more message for the user$")
    public void oneMoreMessage() {
        int actualnumber = messageSupport.getMessagesNumber();
        assertThat(actualnumber, is(initial +1));
    }
}
