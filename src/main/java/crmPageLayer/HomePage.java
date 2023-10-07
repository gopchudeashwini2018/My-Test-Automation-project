package crmPageLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;

public class HomePage extends CRMBaseClass {

	Utils objUtils = new Utils();
	public List<String> element;

	By all_links = By.xpath("//div[@id='navmenu']/ul/li");

	@FindBy(xpath = "//ul[@style='width: 83px; margin-top: 1px; opacity: 0; visibility: hidden; filter: none;']/li")
	public List<WebElement> listofcalenderSuboptions;

	public HomePage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public By textValue(String elements) {
		By link = By.xpath("//a[text()='" + elements + "']");

		return link;

	}

	public void verifyTab(String elements) {

		driver.findElement(textValue(elements)).isDisplayed();

	}

	public void clickOnTab(String elements) {

		driver.findElement(textValue(elements)).click();

	}

	public List<String> listOfElement() {
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

		return listElement;
	}

	public void webElementMouseHover(String elements) {

		WebElement mouse = driver.findElement(textValue(elements));
		objUtils.moveToElementUI(mouse);

	}

	public void getTextOfTab(String element) {
		WebElement ValueOfTab = driver.findElement(textValue(element));

		// System.out.println(objUtils.getTheText(ValueOfTab));

		objUtils.getTheText(ValueOfTab);

	}

	public List<String> calenderOptions() {

		List<String> caloptions = new ArrayList<String>();
		caloptions.add("New Event");
		caloptions.add("View Today");
		caloptions.add("Week View");
		caloptions.add("Month View");

		return caloptions;
	}

	public List<String> companiesOptions() {

		List<String> caloptions = new ArrayList<String>();
		caloptions.add("New Company");
		caloptions.add("Combined Form");
		caloptions.add("Full Search Form");

		return caloptions;
	}

	

}
