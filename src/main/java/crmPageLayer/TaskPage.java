package crmPageLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRMpracticeBasePack.CRMBaseClass;
import CRMpracticeUtility.Utils;

public class TaskPage extends CRMBaseClass{
	
	Utils objUtils=new Utils();

	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath="//select[@name='auto_extend']") 
	WebElement Autoexntend;														// dropdown
	
	@FindBy(xpath="//select[@name='status']")
	WebElement Status;                                                      // dropdown
	
	@FindBy(xpath="//input[@id='completion']")
	WebElement Completion;
	
	@FindBy(xpath="//select[@name='task_type']")
	WebElement Type;                                           // dropdown
	
	@FindBy(xpath="//select[@name='priority']")
	WebElement Priority;                                            // dropdown
	
	@FindBy(xpath="//input[@name='prospect_lookup']")
	WebElement Deal;
	
	@FindBy(xpath="//input[@name='case_lookup']")
	WebElement Elecase;
	
	@FindBy(xpath="//input[@id='tags']")
	WebElement Tags;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement KeyContact;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement KeyComapany;
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement Identifier;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement Description;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebutton;
	
	
	
	
	
	public TaskPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void createTask(String title, String autoexntend, String status,String completion, String type, String priority,
			String deal, String elecase, String tags, String keyContact, String keyComapany, String identifier, String description  )
	{
		
		Title.sendKeys(title);
		objUtils.selectOptionsFromDropdown(Autoexntend, autoexntend);
		objUtils.selectOptionsFromDropdown(Status, status);
		Completion.sendKeys(completion);
		objUtils.selectOptionsFromDropdown(Type, type);
		objUtils.selectOptionsFromDropdown(Priority, priority);
		Deal.sendKeys(deal);
		Elecase.sendKeys(elecase);
		Tags.sendKeys(tags);
		KeyContact.sendKeys(keyContact);
		KeyComapany.sendKeys(keyComapany);
		Identifier.sendKeys(identifier);
		Description.sendKeys(description);
		savebutton.click();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
