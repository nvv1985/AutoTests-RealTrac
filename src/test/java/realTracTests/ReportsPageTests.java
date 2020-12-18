package realTracTests;

import Locators.MainPageLoc;
import Locators.ReportsPageLoc;
import Methods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class ReportsPageTests extends BaseClass {
    private MainPageLoc mp;
    private AllureListener al;
    private ReportsPageLoc rp;

    @BeforeClass
    public void setUp() {
        BaseClass bs= new BaseClass();
        driver = bs.initialize_driver();
        driver.get("https://192.168.88.218/reports.html");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        mp = PageFactory.initElements(driver, MainPageLoc.class);
        al = PageFactory.initElements(driver, AllureListener.class);
        rp = PageFactory.initElements(driver, ReportsPageLoc.class);
    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=1, description="Создание нового отчета")
    @Description("Создание нового отчета")
    @Epic("RealTrac 3.4")
    @Feature("Feature1: create_report")
    @Story("Story:create_report")
    @Step("Создание отчета и проверка успешно созданного отчета")
    public void create_report() throws InterruptedException
    {
        mp.login.sendKeys("admin");
        mp.password.sendKeys("admin");
        mp.submit.click();
        rp.newreport.click();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
