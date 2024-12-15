package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
     
     @FindBy (xpath="//span[text()='My Account']")
     WebElement MyAccountBtn;
     
     @FindBy(xpath="(//ul[@class='dropdown-menu dropdown-menu-right'])//a[1]")
     WebElement MyAccountOption;
     
     @FindBy(xpath="//*[text()='Edit your account information']")
     WebElement EditYourAccountInfoLink;
     
     @FindBy (xpath="//div[@class='alert alert-success alert-dismissible']")
     WebElement SuccessMsg;
     
     @FindBy(xpath="//*[text()='Modify your address book entries']")
     WebElement ModifyAddressLink;
     
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
	 
	 public void clickMyAccountBtn()
	 {
		 MyAccountBtn.click();
	 }
	 
	 public void clickOnMyAccountOption()
	 {
		 MyAccountOption.click();
	 }

	 
	public void clickonEditinfoLink()
	{
		//sol2
		//EditYourAccountInfoLink.click();
		 
		//EditYourAccountInfoLink.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(EditYourAccountInfoLink).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(EditYourAccountInfoLink)).click();
	}
	
	 
	 public boolean isSuccessMsgDisplayed()
	 {
		 try {
		 return(SuccessMsg.isDisplayed());
		 }catch(Exception e)
		 {
			return(false); 
		 }
	 }
	 
	 public void ClickOnModifyAddressLink()
	 {
		 ModifyAddressLink.click();
	 }
}
