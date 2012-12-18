package com.linagora.openpaas.backend.webservice;



import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class MessageSupport {
    public MessageSupport() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restWebService/rest/messageService";
    }

    public void createMessage() {
        String path = "/message";
        given().formParam("body", "body of the message 1").
        given().formParam("subject", "subject 1").
        expect().statusCode(204).when().post(path); //204 no content void
    }

    public int getMessagesNumber() {
        String path = "/messages/number";
        Response rp = expect().statusCode(200).when().get(path);
        return Integer.valueOf(rp.asString());
    }
}
