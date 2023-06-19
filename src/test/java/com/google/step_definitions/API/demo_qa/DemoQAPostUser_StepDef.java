package com.google.step_definitions.API.demo_qa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import static org.junit.Assert.assertEquals;

public class DemoQAPostUser_StepDef {
//6f2fc048-534f-462f-9627-62b51994f774

    static String userName;
    static String userPassword;
    static String userID;
    static String userToken;

    static Response response;
    static JsonPath jsonPath;
    Map<String, Object> requestBody;


    @Given("user parameters {string} and {string}")
    public void user_parameters_and(String user, String password) {

        requestBody = new LinkedHashMap<>();
        requestBody.put("userName", user);
        requestBody.put("password", password);
        System.out.println("requestBody = " + requestBody);
        userName = user;
        userPassword =password;
        System.out.println("userName1 = " + userName);
        System.out.println("userPassword = " + userPassword);

    }

    @When("user sent post request to {string} endpoint")
    public void user_sent_post_request_to_endpoint(String endPoint) {

        response = given().accept(ContentType.JSON).log().body()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post(endPoint).prettyPeek();
        jsonPath = response.jsonPath();
//        userID = jsonPath.getString("userID");
//        System.out.println("userID = " + userID);

    }

    @Then("userName should be equal {string}")
    public void user_name_should_be_equal(String string) {

        String actualName = jsonPath.getString("username");
        Assert.assertEquals(userName, actualName);

    }

    @Then("extract userId")
    public void extract_user_id() {

        userID = jsonPath.getString("userID");
        System.out.println("userID = " + userID);

    }

    @Then("extract userToken")
    public void extract_user_token() {

        userToken = jsonPath.getString("token");

    }

    @Then("message {string} should be appear")
    public void message_should_be_appear(String expectedMessage) {

        String actualMessage = jsonPath.getString("message");
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Given("user sent get request with userToken, path param UUID, userID to {string} endpoint")
    public void user_sent_get_request_with_user_token_path_param_uuid_user_id_to_endpoint(String endPoint) {
        System.out.println("userID = " + userID);
        given().accept(ContentType.JSON)
                .auth().oauth2(userToken)
                .pathParam("UUID", userID)
                .when().get(endPoint).prettyPeek()
                .then().statusCode(200);
    }

    @Given("user sent delete req with userToken, path param UUID, userID to {string} endpoint")
    public void user_sent_delete_req_with_user_token_path_param_uuid_user_id_to_endpoint(String endPoint) {
        System.out.println("userID = " + userID);
        given()
                .auth().basic(userName,userPassword)
                .pathParam("UUID", userID)
                .when().delete(endPoint).prettyPeek()
                .then().statusCode(204);
    }

    @Then("status code {int}")
    public void status_code(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("content type {string}")
    public void content_type(String contentType) {
        assertEquals(contentType,response.contentType());
    }



}
