package org.linagora.rentit;



import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import static com.jayway.restassured.RestAssured.expect;

public class RentACarSupport {
    public RentACarSupport() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/RestWebServiceOpenPaas/rest";
    }

    public void createCars(int availableCars) {
        String path = "/create/" + availableCars;
        expect().statusCode(201).when().post(path);
    }

    public void rentACar() {
        String path = "/rent";
        expect().statusCode(200).when().post(path);
    }

    public int getAvailableNumberOfCars() {
        String path = "/availableCars";
        Response response = expect().statusCode(200).when().get(path);
        ResponseBody body = response.getBody();
        String availableCarsAsString = body.asString();

        return Integer.parseInt(availableCarsAsString);
    }
}
