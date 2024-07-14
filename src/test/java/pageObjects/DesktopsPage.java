package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends BasePage{

	WebDriver driver;
	public DesktopsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='list-group']//a[3]")
	WebElement buttonMacElement;
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement buttonAddCart;
	
	@FindBy(xpath="//a[normalize-space()='shopping cart']")
	public WebElement linkShoopingCart;
	
	
	public void clickonMacElement()
	{
		buttonMacElement.click();
	}
	public void clickonAddtoCart()
	{
		buttonAddCart.click();
	}
	public void clickonlinkShoopingCart()
	{
		linkShoopingCart.click();
	}
}
