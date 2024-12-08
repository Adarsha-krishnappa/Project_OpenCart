package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[text()='0 reviews']")
	WebElement tabReview;
	
	@FindBy(xpath="//input[@id='input-name']")
	WebElement txtyourname;
	
	@FindBy(xpath="//textarea[@id='input-review']")
	WebElement txtyourReview;
	
	@FindBy(xpath="//input[@type='radio' and @value='4']")
	WebElement ratingRadiobtn;
	
	@FindBy(xpath="//button[@id='button-review']")
	WebElement buttonContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement ReviewConfirmation;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement buttonAddtoCart;
	
	@FindBy(xpath="//a[normalize-space()='shopping cart']")
	WebElement ShoppingCartLink;
	
	@FindBy(xpath="//a[text()='Reviews (0)']")
	WebElement ReviewBtn;
	
	
	
	public String randomeStringName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}
	public String randomeStringReview()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(30);
		return generatedString;
	}
	
	
	
	public void clicktabReview()
	{
		tabReview.click();
	}
	public void setyourname(String yourname)
	{
		txtyourname.sendKeys(yourname);
	}
	public void setyourReview(String yourreview)
	{
		txtyourReview.sendKeys(yourreview);
	}
	public void setRatingofProduct()
	{
		ratingRadiobtn.click();
	}
	public void clickbtncontinue()
	{
		buttonContinue.click();
	}
	
	public boolean getConfirmationMsg()
	{
		try {
		return(ReviewConfirmation.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
	public void btnAddtoCart()
	{
		buttonAddtoCart.click();
	}
	public void ClickShoppingcartLink()
	{
		ShoppingCartLink.click();
	}
	
	
	
}
