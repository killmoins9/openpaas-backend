package com.linagora.openpaas.backend.webservice;



import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.with;

import java.util.List;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class UserSupport {
    public UserSupport() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restWebService/rest/userService";
    }

    public void createUser() {
        String path = "/user";
        given().auth().basic("user1", "openpaas").
        given().formParam("login", "login1").
        given().formParam("firstname", "firstname1").
        given().formParam("lastname", "lastname1").
        given().formParam("mail", "mail1").
        expect().statusCode(204).when().post(path); 
    }

    public int findNumberUsers() {
        String path = "/users";
        Response rp = given().auth().basic("user1", "openpaas").expect().statusCode(200).when().get(path);
        
        List<String> list = with(rp.getBody().asInputStream()).get("login");
        return list.size();
    }
}
