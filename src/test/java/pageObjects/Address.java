package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Address extends BasePage{
	
	WebDriver driver;
	public  Address(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//*[text()='New Address']")
	WebElement NewAddressBtn;
	
	@FindBy (id="input-firstname")
	WebElement FirstName;
	
	@FindBy (id="input-lastname")
	WebElement LastName;
	
	@FindBy (id="input-company")
	WebElement company;	
	
	@FindBy (id="input-address-1")
	WebElement Address1;
	
	@FindBy (id="input-address-2")
	WebElement Address2;	
	
	@FindBy (id="input-city")
	WebElement City;
	
	@FindBy (id="input-postcode")
	WebElement PostCode;
	
	@FindBy (xpath="//*[@value='Continue']")
	WebElement ContinueBtn;
	
	@FindBy (xpath="//select[@id='input-country']")
	WebElement CountrydropdownOption;
		
	@FindBy (xpath="//select[@id='input-zone']")
	WebElement StatedropdownOption;
	
	@FindBy (xpath="(//*[@type='radio'])[1]")
	WebElement DefaultAddress_Yes;
	
	@FindBy (xpath="(//*[@type='radio'])[2]")
	WebElement DefaultAddress_No;
	
	@FindBy (xpath="//*[text()='Your address has been successfully added']")
	WebElement Successfull_Msg;
	
	public void ClickOnNewAddressBtn()
	{
		NewAddressBtn.click();
	}
	
	public boolean SuccessfyllMessage()
	{
		try {
		return Successfull_Msg.isDisplayed();
		}catch(Exception e)
		{
			return(false);
		}
	}
	
	public void ClickOnElement()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Successfull_Msg).click().build().perform();
	}
	
	public void SetFirstName(String FName)
	{
		FirstName.sendKeys(FName);
	}
	
	public void SetLastName(String LName)
	{
		LastName.sendKeys(LName);
	}
	
	public void Setcompany(String Compny)
	{
		company.sendKeys(Compny);
	}
	
	public void SetAddress1(String address1)
	{
		Address1.sendKeys(address1);
	}
	
	public void SetAddress2(String address2)
	{
		Address2.sendKeys(address2);
	}
	
	public void SetCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void SetPostCode(String postCode)
	{
		PostCode.sendKeys(postCode);
	}
	
	public void SelectCountry()
	{
		Select sct=new Select(CountrydropdownOption);
		sct.selectByValue("99");
	}
	
	public void SelectState()
	{
		Select sct=new Select(StatedropdownOption);
		sct.selectByVisibleText("Karnataka");
	}
	
	public void SetDeafultAddress_Yes()
	{
		DefaultAddress_Yes.click();
	}
	
	public void SetDeafultAddress_No()
	{
		DefaultAddress_No.click();
	}
	
	public void ClickOnContinueBtn()
	{
		ContinueBtn.click();
	}
	
	
	
	

}
