package com.google.pages;

import com.google.utilities.Driver;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class GoogleMain_Page {

    public GoogleMain_Page() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(name = "q")
    private WebElement googleSearchBox;
}
