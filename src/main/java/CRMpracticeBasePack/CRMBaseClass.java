package CRMpracticeBasePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	public String takeScreenShot(String TestName) throws IOException {
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = "C:\\NewAutomationFrame\\My-Test-Automation-project\\FailedTestCasesScreenShots\\"+TestName+"Test.png";
		FileUtils.copyFile(SourceFile, new File(destinationPath));
		return destinationPath;

	}
	
	

}
