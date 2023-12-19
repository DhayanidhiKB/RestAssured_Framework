package org.restAssured.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restAssured.listeners.TestListener;
import org.restAssured.reports.ExtentLogger;
import org.restAssured.requestBuilder.RequestBuilder;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class GetTest extends BaseTest {

    public ExtentLogger extentLogger;


    @Test
    public void getAllEmployeesDetails() {

        RequestSpecification requestSpecification = RequestBuilder.getCalls();

        ExtentLogger.logRequest(requestSpecification);

        Response response = requestSpecification.get("employees");

        ExtentLogger.logResponse(response.prettyPrint());

        response.prettyPrint();
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void getEmployeeDetails() {

        Response response = RequestBuilder.getCalls()
                .pathParam("id", 1)
                .get("employees/{id}");

        response.prettyPrint();
        ExtentLogger.logResponse(response.asPrettyString());

        assertThat(response.jsonPath().getString("first_name"))
                .as("Comparing the first_name in given id")
                .isEqualTo("LeoDas");
    }

}
