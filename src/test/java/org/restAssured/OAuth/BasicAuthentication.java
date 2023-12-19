package org.restAssured.OAuth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class BasicAuthentication {


    @Test
    public void postmanEchoServer() {

        Response response = given().auth().basic("postman", "password")
                .log().all()
                .get("https://postman-echo.com/basic-auth");

        response.prettyPrint();
    }

    @Test
    public void getAllWorkspaces() {

        String ApiKey = "PMAK-657865d2f082881f12e517a2-ff81b781be5e04b1cd554213227e0fde83";
        Response response = given().header("X-API-Key", ApiKey)
                .log().all()
                .get("https://api.getpostman.com/collections");

        response.prettyPrint();
    }

}
