package crmtestLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;
import crmPageLayer.HomePage;
import crmPageLayer.LoginPagePractice;

public class HomeTestLayer extends CRMBaseClass {

	LoginPagePractice objLoginPagePractice;
	HomePage objHomePage = new HomePage();
	Utils objUtils;

	public HomeTestLayer() throws IOException {
		super();
	}

	@BeforeMethod()
	public void setUp() throws IOException {
		setUpBrowser();
		objLoginPagePractice = new LoginPagePractice();
		objHomePage = new HomePage();
		objUtils = new Utils();

		objHomePage = objLoginPagePractice.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));

	}

	@Test(priority = 1)
	public void verifyLinksHomeTab() throws IOException {

		List<String> element = new ArrayList();
		element.add("Home");
		element.add("Calendar");
		element.add("Companies");
		element.add("Contacts");
		element.add("Deals");
		element.add("Tasks");
		element.add("Cases");
		element.add("Call");
		element.add("Email");
		element.add("Text/SMS");
		element.add("Print");
		element.add("Campaigns");
		element.add("Docs");
		element.add("Forms");
		element.add("Reports");

		objUtils.frameHandler("mainpanel");
		for (String elements : element) {
			objHomePage.verifyTab(elements);
			System.out.println(element);
		}
	}

	@Test(priority = 2)
	public void verifyTabIsClickable() throws IOException {

		List<String> listElement = new ArrayList();

		listElement.add("Home");
		listElement.add("Calendar");
		listElement.add("Companies");
		listElement.add("Contacts");
		listElement.add("Deals");
		listElement.add("Tasks");
		listElement.add("Cases");
		listElement.add("Call");
		listElement.add("Email");
		listElement.add("Text/SMS");
		listElement.add("Print");
		listElement.add("Campaigns");
		listElement.add("Docs");
		listElement.add("Forms");
		listElement.add("Reports");

		System.out.println(listElement);
		objUtils.frameHandler("mainpanel");

		for (String elements : listElement) {

			objHomePage.clickOnTab(elements);
			System.out.println(listElement);

		}
	}

	@Test(priority = 3)
	public void mouseHoverAction() throws IOException {

		List<String> listElement = new ArrayList();

		listElement.add("Home");
		listElement.add("Calendar");
		listElement.add("Companies");
		listElement.add("Contacts");
		listElement.add("Deals");
		listElement.add("Tasks");
		listElement.add("Cases");
		listElement.add("Call");
		listElement.add("Email");
		listElement.add("Text/SMS");
		listElement.add("Print");
		listElement.add("Campaigns");
		listElement.add("Docs");
		listElement.add("Forms");
		listElement.add("Reports");

		System.out.println(listElement);
		objUtils.frameHandler("mainpanel");

		for (String elements : listElement) {

			objHomePage.webElementMouseHover(elements);

			System.out.println(listElement);

		}
	}
	@Test(priority=4)
	public void testRepo()
	{
		System.out.println("this is new method for master");
	}
}
