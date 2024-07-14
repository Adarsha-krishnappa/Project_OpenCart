package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingcartPage extends BasePage{

	WebDriver driver;
	public ShoppingcartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement msgShoopingCart;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tr[1]/td[1]//img")
	WebElement cnfproductAdded;
	
	public boolean getShoopingCartConfirmsg()
	{
		try 
		{
		return(msgShoopingCart.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	public boolean getproductAddtoCart()
	{
		try 
		{
		return(cnfproductAdded.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
}
