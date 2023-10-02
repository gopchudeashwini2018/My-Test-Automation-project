package CRMpracticeUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CRMpracticeBasePack.CRMBaseClass;

public class Utils extends CRMBaseClass {

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static int PAGE_LOAD_TIMEOUT = 60;

	public static int IMPLICITLY_WAIT = 60;

	public Utils() throws IOException {

	}
	
	
	public List<WebElement> findElementMethods(By by)
	{
		return driver.findElements(by);
		
	}
	
	
	

	public void frameHandler(String frame) {
		driver.switchTo().frame(frame);
	}

	public void selectOptionsFromDropdown(WebElement drowdownelement, String value) {
		Select select = new Select(drowdownelement);
		select.selectByValue(value);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void moveToElementUI(WebElement element) {
		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

	}

	public static Object[][] getTestData(String SheetName) throws EncryptedDocumentException, IOException {

		FileInputStream file = null;

		String TestDataPath = "";
		file = new FileInputStream(TestDataPath);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(SheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; i < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}

		}

		return data;
	}
	

}
