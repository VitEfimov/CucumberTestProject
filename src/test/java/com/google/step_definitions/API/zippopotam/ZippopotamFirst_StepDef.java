package com.google.step_definitions.API.zippopotam;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ZippopotamFirst_StepDef {

    Response response;
    JsonPath jsonPath;

    @Given("send get request to {string}, country is {string}, postal code is {int}")
    public void send_get_request_to_country_is_postal_code_is(String URL, String country, int postalCode) {
        response = given().accept(ContentType.JSON)
                .pathParam("country", country)
                .pathParam("postal-code", postalCode)
                .get(URL);
    }

    @Then("status code is {int}")
    public void status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
        Assert.assertEquals(ContentType.JSON.toString(), response.contentType());


    }

    @Then("post code is {string}")
    public void post_code_is(String postCode) {
        jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        Assert.assertEquals(postCode, jsonPath.getString("'post code'"));

    }

    @Then("country is {string}")
    public void country_is(String country) {
        Assert.assertEquals(country, jsonPath.getString("country"));

    }

    @Then("place name is {string}")
    public void place_name_is(String placeName) {
        Assert.assertEquals(placeName, jsonPath.getString("places[0].'place name'"));

    }

    @Then("state is {string}")
    public void state_is(String state) {
        Assert.assertEquals(state, jsonPath.getString("places[0].state"));
    }

}
