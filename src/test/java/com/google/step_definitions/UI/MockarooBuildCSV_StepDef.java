package com.google.step_definitions.UI;

import com.google.pages.MockarooMain_Page;
import com.google.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MockarooBuildCSV_StepDef {

    MockarooMain_Page mockarooMain_page = new MockarooMain_Page();

    @Test
    public void jUnit(){
        Driver.get().get("https://mockaroo.com");
        List<WebElement> listOfNames = mockarooMain_page.getListOfNames();
        List<WebElement> listOfCloseBtn = mockarooMain_page.getListOfCloseBtn();
        for (int i = 0; i < listOfNames.size(); i++) {
            if (listOfNames.get(i).getAttribute("value").equals("first_name")||listOfNames.get(i).getAttribute("value").equals("email")||listOfNames.get(i).getAttribute("value").equals("gender")){
                continue;
            }
           listOfCloseBtn.get(i).click();
        }
        mockarooMain_page.getRowsNumber().click();
        mockarooMain_page.getRowsNumber().sendKeys(Keys.DELETE);
        mockarooMain_page.getRowsNumber().sendKeys("10");
        mockarooMain_page.chooseFormat("JSON").click();
        mockarooMain_page.getDownloadData().click();
        Driver.closeDriver();
    }
}
