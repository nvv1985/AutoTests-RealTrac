package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPageLoc {
    WebDriver driver;

    public MainPageLoc(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css="button[type=submit]")
    public WebElement submit;

    @FindBy(xpath="//*[@id=\"topPanel\"]/div/section/div[4]/div[3]/p[1]")
    public WebElement username;

    @FindBy(xpath="//*[@id=\"topPanel\"]/div/section/div[4]/button")
    public WebElement exit;
}


