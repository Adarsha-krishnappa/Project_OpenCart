package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	WebDriver driver;
	public  MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	 @FindBy (xpath="//h2[text()='My Account']") 
	 WebElement msgheading;
	 
	 @FindBy (xpath="//a[@class='list-group-item' and text()='Logout']")
	 WebElement linkLogOut;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtConfirm_Email;

@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
WebElement msgFrgtPswd;

@FindBy(xpath="//input[@value='Continue']")
WebElement btncontinue;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement txtPswdResetmailset;

	 public boolean isMyAccountPageExists()
	 {
		 try {
		 return(msgheading.isDisplayed());
		 }catch(Exception e)
		 {
			return(false); 
		 }
	 }
	 
	 public void ClickLogOut()
	 {
		 linkLogOut.click();
	 }
	 public boolean isForgetPswdExits()
	 {
		 try {
		 return (msgFrgtPswd.isDisplayed());
		 }catch(Exception e)
		 {
			 return(false);
		 }
	 }
	 public void setConfirmEmail(String email)
	 {
		 txtConfirm_Email.sendKeys(email);
	 }
	 public void clickContinue()
	 {
		 btncontinue.click();
	 }
	 public boolean isresetpasswordsent()
	 {
		 try
	 {
		 return (txtPswdResetmailset.isDisplayed());
	 }catch (Exception e)
		 {
		 return(false);
	 }
	 }
	 

}
