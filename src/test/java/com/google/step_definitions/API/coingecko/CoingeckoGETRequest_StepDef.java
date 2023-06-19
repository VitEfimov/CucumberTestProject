package com.google.step_definitions.API.coingecko;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CoingeckoGETRequest_StepDef {

    String baseURL = "https://api.coingecko.com";
    Response response;

    @Given("user sent get request to {string} endpoint")
    public void user_sent_get_request_to_endpoint(String string) {
        response = given().accept(ContentType.JSON)
                .header("Content-Type", "application/json; charset=utf-8")
                .when().get(baseURL+string);

    }
    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(statusCode, response.statusCode());


    }
    @Then("content type is {string}")
    public void content_type_is(String contentType) {
        assertEquals(contentType,response.contentType());
    }


}
