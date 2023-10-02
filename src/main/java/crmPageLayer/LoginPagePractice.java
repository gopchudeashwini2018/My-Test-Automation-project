package crmPageLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;

public class LoginPagePractice extends CRMBaseClass {
	
	Utils objUtils = new Utils();
	
	
	@FindBy(xpath ="//input[@name='username']")
	WebElement username;

	@FindBy(xpath ="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clickonLogin;

	public LoginPagePractice() throws IOException {

		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginToApp(String Usrnm,String pswd) throws IOException
	{
		username.sendKeys(Usrnm);
		password.sendKeys(pswd);
		clickonLogin.click();
		
		
		return new HomePage();
	}

}
