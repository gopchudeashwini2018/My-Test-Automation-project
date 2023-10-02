package crmPageLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;

public class HomePage extends CRMBaseClass {

	Utils objUtils = new Utils();
	public List<String> element;

	By all_links = By.xpath("//div[@id='navmenu']/ul/li");

	public HomePage() throws IOException {

	}

	public void uIElements(List<String> element) {
		element.add("home");
		element.add("Calendar");
		element.add("Companies");
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
		;

	}

	public List<String> listOfElement(List<String> listElement) {
		listElement = new ArrayList();

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

}
