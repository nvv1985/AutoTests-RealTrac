package realTracTests;
import Locators.MainPageLoc;
import Methods.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
public class MainPageTests extends BaseClass {
	private MainPageLoc mp;
	private AllureListener al;
	
	@BeforeClass 
	public void setUp() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://192.168.88.218/");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		mp = PageFactory.initElements(driver, MainPageLoc.class);
		al = PageFactory.initElements(driver, AllureListener.class);
	}

	
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=1, description="Авторизация в приложение Real-Trac")
	@Description("Авторизация в приложение Real-Trac")
	@Epic("RealTrac 3.3")
	@Feature("Feature1: RT460")
	@Story("Story:Auth")
	@Step("Авторизация и проверка успешной авторизации")
	public void RT460()
	{
		mp.login.sendKeys("admin");
		mp.password.sendKeys("admin");
		al.saveSuccessScreenShot(driver);
		mp.submit.click();
		Assert.assertEquals(mp.username.getText(), "Иван");
		mp.exit.click();
		al.saveSuccessScreenShot(driver);


	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
