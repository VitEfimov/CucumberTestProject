package com.google.pages;

import com.google.utilities.Driver;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class MockarooMain_Page {

    public MockarooMain_Page() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']")
    private List<WebElement> listOfCloseBtn;

    @FindBy(xpath = "//input[@name='name']")
    private List<WebElement> listOfNames;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root jss76 MuiButton-outlined']")
    private List<WebElement> listOfTypes;

    @FindBy(xpath = "//p[.='First Name']/..")
    private WebElement chooseATypeFirstName;

    @FindBy(css = "input[value=\"1000\"]")
    private WebElement rowsNumber;

    @FindBy(xpath = "//span[.='Preview']")
    private WebElement previewBtn;

    @FindBy(xpath = "//span[.='Generate Data']")
    private WebElement downloadData;

    @FindBy(xpath = "//li[@role='option']")
    private List<WebElement> listOfFormatOptions;

    @FindBy(xpath = "//div[.='CSV']")
    private WebElement formatBtn;


    //div[.='CSV']

    /**
     * Choose from: CVS, JSON, Tab-Delimited, SQL, Cassandra CQL, Firebase, InfluxDB, Custom, Excel, XML, DBUnit XML
     * @param type
     * @return WebElement
     */
    public WebElement chooseFormat(String type) {
        getFormatBtn().click();
        return Driver.get().findElement(By.xpath("//li[.='" + type + "']"));
    }

    private static WebElement buttonBarBtns(String type) {
        return Driver.get().findElement(By.xpath("//span[.='" + type + "']"));
    }

    private static WebElement chooseAType(String type) {
        return Driver.get().findElement(By.xpath("//p[.='" + type + "']/.."));
    }
}
