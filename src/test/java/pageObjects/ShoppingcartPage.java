package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingcartPage extends BasePage{

	WebDriver driver;
	public ShoppingcartPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement ShoopingCartheader;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tr[1]/td[1]//img")
	WebElement cnfproductAdded;
	
	@FindBy(xpath="//*[text()='iMac']")
	WebElement addedProduct;
	
	@FindBy (xpath="//*[text()= 'Use Coupon Code ']")
	WebElement UseCouponCodeBtn;
		
	@FindBy (xpath="//*[text()='Estimate Shipping & Taxes ']")
	WebElement ShippingTaxesBtn;
	
	@FindBy (xpath="//*[text()='Use Gift Certificate ']")
	WebElement UseGiftcertificateBtn;
		
	@FindBy (xpath="//*[@id='input-postcode']")
	WebElement postcode;
	
	@FindBy (xpath="//*[@id='button-quote']")
	WebElement GetQuoteBtn;
	
	@FindBy (xpath="//*[@id='button-coupon']")
	WebElement ApplyCouponBtn;
	
	@FindBy (xpath="//*[@class='alert alert-danger alert-dismissible']")
	WebElement CouponErrorAlert;
	
	@FindBy (xpath="//*[@id='input-voucher']")
	WebElement GiftcodeTextfeild;
	
	@FindBy (xpath="//*[@class='close']")
	WebElement CloseWarningBtn;
	
	@FindBy (xpath="//*[@id='button-voucher']")
	WebElement ApplyGiftCodeBtn;
	
	@FindBy (xpath="//select[@id='input-country']")
	WebElement CountrydropdownOption;
		
	@FindBy (xpath="//select[@id='input-zone']")
	WebElement StatedropdownOption;
	
	@FindBy (xpath="//div[@class='modal-content']")
	WebElement ModalContent;
	
	
	public boolean IsShoppingCartExists()
	{
		try 
		{
		return(ShoopingCartheader.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	
	public boolean AddProductPresent()
	{
		try 
		{
		return(cnfproductAdded.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	
	public void UseCouponCodeOption()
	{
		UseCouponCodeBtn.click();
	}
	
	public void ShippingTaxesOption()
	{
		ShippingTaxesBtn.click();
	}
	
	public void UseGiftcertificateOption()
	{
		UseGiftcertificateBtn.click();
	}
	
	public void ApplyCouponbutton()
	{
		ApplyCouponBtn.click();
	}
	
	public boolean IsCouponErrorAlertExists()
	{
		try {
		return(CouponErrorAlert.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	
	public void CloseWarning()
	{
		CloseWarningBtn.click();
	}

	public void SetGiftCode(String Code)
	{
		GiftcodeTextfeild.sendKeys(Code);
	}
	
	public void ApplyGiftCode()
	{
		ApplyGiftCodeBtn.click();
	}	
	
	public void Setpostcode(String pinCode)
	{
		postcode.sendKeys(pinCode);
	}
	
	public void GetQuotesButton()
	{
		GetQuoteBtn.click();
	}
		
	public void SelectCountry()
	{
		Select sct=new Select(CountrydropdownOption);
		System.out.println(sct.getOptions());
		sct.selectByValue("99");
	}
	
	public void SelectState()
	{
		Select sct=new Select(StatedropdownOption);
		System.out.println(sct.getOptions());
		List<WebElement> options=sct.getOptions();
		for(WebElement option:options)
		{
			String coutry=option.getText();
			if(coutry.contentEquals("Karnataka"))
			{
				option.click();
				break;
			}
			
		}
	}
	
	public boolean IsModalContentExists()
	{
		try {
		return(ModalContent.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	
}
