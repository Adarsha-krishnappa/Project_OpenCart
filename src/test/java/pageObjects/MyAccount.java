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
	 

}
