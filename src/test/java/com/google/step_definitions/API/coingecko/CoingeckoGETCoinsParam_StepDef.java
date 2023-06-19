package com.google.step_definitions.API.coingecko;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class CoingeckoGETCoinsParam_StepDef {

    String baseURL = "https://api.coingecko.com";
    Response response;



    @Given("user sent get request to {string} {string} endpoint")
    public void user_sent_get_request_to_endpoint(String endPoint, String param) {
        response = given().accept(ContentType.JSON)
//                .pathParam("coins", param)
                .when().get(baseURL+endPoint+param);
    }

    @Then("status code in case2 should be {int}")
    public void status_code_in_case_should_be(int statusCode) {
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(statusCode, response.statusCode());
    }
    @And("content type in case2 is {string}")
    public void content_type_in_case_is(String contentType) {
        assertEquals(contentType,response.contentType());
    }
}
