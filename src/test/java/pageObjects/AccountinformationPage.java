package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountinformationPage extends BasePage{
	
	WebDriver driver;
	
	public AccountinformationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//*[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath="//*[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id='input-telephone']")
	WebElement txtTelePhone;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ContinueBtn;
	
	public void UpdateFirstname(String Firstname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(Firstname);
	}
	
	public void UpdateLastname(String Lastname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(Lastname);
	}
	
	public void UpdateEmail(String Email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}
	
	public void UpdateTelephone(String Telephone)
	{
		txtTelePhone.clear();
		txtTelePhone.sendKeys(Telephone);
	}
	
	public void clickOnContinueBtn()
	{
		ContinueBtn.submit();//click
	}
	

}
