package com.google.step_definitions.API.coingecko;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CoingeckoGETMulti_StepDef {

    String baseURL = "https://api.coingecko.com";
    Response response;

    @Given("user sent get request case3 to {string} endpoint")
    public void user_sent_get_request_case3_to_endpoint(String endPoint) {
        response = given().accept(ContentType.JSON)
                      .when().get(baseURL+endPoint).prettyPeek();
    }
    @Then("status code in case3 should be {int}")
    public void status_code_in_case3_should_be(int statusCode) {
//        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(statusCode, response.statusCode());
    }
    @Then("content type in case3 is {string}")
    public void content_type_in_case3_is(String contentType) {
        assertEquals(contentType,response.contentType());
    }
}
