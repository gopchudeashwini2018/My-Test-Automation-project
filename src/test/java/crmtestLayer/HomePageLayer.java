package crmtestLayer;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;
import crmPageLayer.HomePage;
import crmPageLayer.LoginPagePractice;

public class HomePageLayer extends CRMBaseClass {

	LoginPagePractice objLoginPagePractice;
	HomePage objHomePage;
	Utils objUtils;

	public HomePageLayer() throws IOException {

	}

	@BeforeMethod()
	public void setUp() throws IOException {
		setUpBrowser();
		objLoginPagePractice = new LoginPagePractice();
		objHomePage = new HomePage();
		objUtils = new Utils();
		objHomePage = objLoginPagePractice.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));

	}

	// @Test(priority = 1)
	public void verifyTabIsAvailable() {

		List<String> HomeLinks = objHomePage.listOfElement();
		objUtils.frameHandler("mainpanel");

		for (String verifyLinksOnHomePage : HomeLinks) {
			objHomePage.verifyTab(verifyLinksOnHomePage);
		}

	}

	// @Test(priority = 2)
	public void verifyIsTabClickable() {
		List<String> Homelinks = objHomePage.listOfElement();
		objUtils.frameHandler("mainpanel");
		for (String verifyLinksOnHomePage : Homelinks) {
			objHomePage.clickOnTab(verifyLinksOnHomePage);
		}
	}

	 @Test(priority = 3)
	public void mouseHoverOnTab() {
		List<String> Homelinks = objHomePage.listOfElement();
		objUtils.frameHandler("mainpane");
		for (String verifyLinksOnHomePage : Homelinks) {
			objHomePage.webElementMouseHover(verifyLinksOnHomePage);

		}

	}

	 @Test(priority = 4)
	public void verifyOptionsPresent() {
		List<String> Homelinks = objHomePage.listOfElement();
		objUtils.frameHandler("mainpanel");
		for (String verifyLinksOnHomePage : Homelinks) {
			objHomePage.getTextOfTab(verifyLinksOnHomePage);
		}

	}

	//@Test(priority = 5)
	public void verifyCalenderOptions() {

		List<String> calOptions = objHomePage.calenderOptions();
		objUtils.frameHandler("mainpanel");

		for (String calSubOptions : calOptions) {
			objHomePage.webElementMouseHover("Calendar");

			objHomePage.clickOnTab(calSubOptions);
		}

		
        List<String> comOptions = objHomePage.companiesOptions();

		for (String comOption : comOptions) {
			objHomePage.webElementMouseHover("Companies");
			objHomePage.clickOnTab(comOption);

		}

	}


	

}
