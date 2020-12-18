package Methods;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseClass {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("headless");
		options.addArguments("--disable-dev-shm-usage");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}


}
