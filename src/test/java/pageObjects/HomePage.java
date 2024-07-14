package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkRegister;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement lnkLogin;

@FindBy(xpath="//input[@name='search']")
WebElement txt_productname;

@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
WebElement clickSearch;

@FindBy(xpath="//a[normalize-space()='Desktops']")
WebElement buttonDesktops;

@FindBy(xpath="//a[normalize-space()='Show AllDesktops']")
WebElement buttonShowAllDesktops;

public void clickMyAccount()
{
	lnkMyaccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}
public void enterProductdetails(String product)
{
	txt_productname.sendKeys(product);
}
public void clearproductdeatils()
{
	txt_productname.clear();
}
public void clksearchbutton()
{
	clickSearch.click();
}
public void clickbtnDesktops()
{
	buttonDesktops.click();
}
public void clickbtnshowAllDesktops()
{
	buttonShowAllDesktops.click();
}
}