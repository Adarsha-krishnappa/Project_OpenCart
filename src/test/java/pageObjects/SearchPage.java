package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//div[@class='button-group']/button[3]")
WebElement btncompareprdct;
	
@FindBy(xpath="//div[@class='button-group']/button[2]")
WebElement btnAddtoWishList;
	
@FindBy(xpath="//a[normalize-space()='product comparison']")
public WebElement clickPrdtcomparLink;

@FindBy(xpath="//a[normalize-space()='wish list']")
WebElement clickWishList;

@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
WebElement msgNoExistingProducts;

@FindBy(xpath="//img[@title='iMac']")
WebElement clkonselectedproduct;

@FindBy(xpath="//span[normalize-space()='Add to Cart']")
WebElement buttonAddtoCart;

@FindBy(xpath="//a[normalize-space()='shopping cart']")
public WebElement linkshoopingcart;

public void bottonProductCompare()
{
	btncompareprdct.click();
}
public void clickonAddtoWishList()
{
	btnAddtoWishList.click();
}
public boolean IsWishListlinkExists()
{
	try {
	return(clickWishList.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
}
public void linkproductcomparition()
{
	clickPrdtcomparLink.click();
}
public boolean isExistingproductavailabe()
{
	try {
	return (msgNoExistingProducts.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
}
public void ClickselectedProduct()
{
	clkonselectedproduct.click();
}
public void ClickAddtoCart()
{
	buttonAddtoCart.click();
}
public void linkShoppingCart()
{
	linkshoopingcart.click();
}

}
