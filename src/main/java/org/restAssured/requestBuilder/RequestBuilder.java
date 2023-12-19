package org.restAssured.requestBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.restAssured.tests.PropertyUtils;

import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder() {
    }

    public static RequestSpecification getCalls() {
        return given()
                .baseUri(PropertyUtils.getValue("baseUrl"))
                .log()
                .all();
    }

    public static RequestSpecification postCalls() {
        return given()
                .baseUri(PropertyUtils.getValue("baseUrl"))
                .log().all()
                .header("Content-Type", ContentType.JSON);
    }
}
