package com.google.step_definitions.UI;

import com.google.pages.GoogleMain_Page;
import com.google.pages.GoogleSearchResult_Page;

import com.google.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import org.junit.Assert;

public class MockarooFromGoogleSearch_StepDef {

    GoogleMain_Page googleMain_page = new GoogleMain_Page();
    GoogleSearchResult_Page googleSearchResult_page = new GoogleSearchResult_Page();

    @Given("user on a main google page")
    public void user_on_a_main_google_page() {
        Driver.get().get("https://google.com");
    }

    @When("user send key in a search box {string}")
    public void user_send_key_in_a_search_box(String string) {
        googleMain_page.getGoogleSearchBox().sendKeys(string + Keys.ENTER);
    }

    @When("user click first {string} link")
    public void user_click_first_link(String string) {
        System.out.println("googleSearchResult_page.searchGoogleResult(string).getText() = " + googleSearchResult_page.searchGoogleResult(string).getText());
        System.out.println("googleSearchResult_page.searchGoogleResult(string).getAttribute(\"id\") = " + googleSearchResult_page.searchGoogleResult(string).getAttribute("id"));
        googleSearchResult_page.searchGoogleResult(string).click();
    }

    @Then("user on main page of {string}")
    public void user_on_main_page_of(String string) {
        String currentTitle = Driver.get().getTitle();
        Assert.assertTrue(currentTitle.contains(string));
    }
}
