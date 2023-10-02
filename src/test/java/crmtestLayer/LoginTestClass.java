package crmtestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRMpracticeBasePack.CRMBaseClass;
import crmPageLayer.HomePage;
import crmPageLayer.LoginPagePractice;

public class LoginTestClass extends CRMBaseClass {

	LoginPagePractice objLoginPagePractice;
	HomePage objHomePage;

	public LoginTestClass() throws IOException {

		super();

	}

	@BeforeMethod()
	public void setUp() throws IOException {

		objLoginPagePractice = new LoginPagePractice();
		
		CRMBaseClass.setUpBrowser();

		
	}
	
	 
    @Test(priority=1)
    public void verifyTitle ()
    {
    	//objLoginPage.verifylinks(objLoginPage.gethomelink());
    	
    	String ActualTile=driver.getTitle();
    	
    	String ExpectedTile="Free CRM software for customer relationship management, sales, and support.";
    	
    	Assert.assertEquals(ActualTile, ExpectedTile);
    }

	@Test(priority = 2)
	public void Login() throws IOException {
		 objLoginPagePractice = new LoginPagePractice();
		objHomePage = objLoginPagePractice.loginToApp(prop.getProperty("Username"),prop.getProperty("Password"));
		
	}

}
