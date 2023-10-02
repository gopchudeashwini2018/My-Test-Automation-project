package CRMpracticeBasePack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CRMpracticeUtility.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMBaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public CRMBaseClass() throws IOException {

		prop = new Properties();
		String path = "C:\\Users\\agopchude\\eclipse-workspace\\CRM_Practice\\src\\main\\java\\CRMpractice.properties";
		FileInputStream file = new FileInputStream(path);
		prop.load(file);

	}

	public static void setUpBrowser() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIMEOUT));
		driver.get(prop.getProperty("url"));

	}

}
