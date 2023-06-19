package com.google.pages;

import com.google.utilities.Driver;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Data
public class GoogleSearchResult_Page {
    public GoogleSearchResult_Page() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='https://www.mockaroo.com/']")
    private WebElement mockarooSearchResultLink;


    public WebElement searchGoogleResult(String string) {
        return Driver.get().findElement(By.xpath("(//a[contains(.,'"+string+"')])[1]"));
    }
}
