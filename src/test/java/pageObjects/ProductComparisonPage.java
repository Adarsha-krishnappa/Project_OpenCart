package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage{
	WebDriver driver;

	public ProductComparisonPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h1[text()='Product Comparison']")
	WebElement txtProductComparition;
	
	public boolean msgproductcomparisonexist()
	{
		try {
		return (txtProductComparition.isDisplayed());
	}catch(Exception e)
	{
		return(false);
	}
	}
}
