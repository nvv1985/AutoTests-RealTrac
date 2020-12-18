package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ReportsPageLoc {
    WebDriver driver;

    public ReportsPageLoc(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div/button")
    public WebElement newreport;


}


