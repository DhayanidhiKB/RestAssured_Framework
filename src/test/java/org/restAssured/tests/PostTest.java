package org.restAssured.tests;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restAssured.frameworkConstants.FilePaths;
import org.restAssured.pojo.Employee;
import org.restAssured.reports.ExtentLogger;
import org.restAssured.requestBuilder.RequestBuilder;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.restAssured.tests.RandomUtils.*;

public class PostTest extends BaseTest {

    @Test
    public void postReq() {

        Employee postEmployee = Employee.builder().id(getId()).firstName(getFirstName()).lastName(getLastName()).email(getEmail()).build();

        Response response = RequestBuilder.postCalls()
                .body(postEmployee)
                .post("employees");


        ExtentLogger.logResponse(response.prettyPrint());

        assertThat(response.getStatusCode()).isEqualTo(201);

    }

    @Test
    public void postReqUsingExternalFile() {
        String resource = ApiUtils.readJsonGetAsString(FilePaths.getRequestJsonPath() + "/NewEmployee.json")
                .replace("number", String.valueOf(getId()))
                .replace("firstName", getFirstName())
                .replace("lastName", getLastName())
                .replace("email", getEmail());

        RequestSpecification requestSpecification = RequestBuilder.postCalls()
                .body(resource);

        ExtentLogger.logRequest(requestSpecification);

        Response response = requestSpecification.post("employees");

        ExtentLogger.logResponse(response.prettyPrint());

        ApiUtils.storeJsonResponse(FilePaths.getResponseJsonPath() + "/response.json", response);
        assertThat(response.getStatusCode()).isEqualTo(201);
    }
}

