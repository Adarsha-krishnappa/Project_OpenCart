package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingcartPage;
import testBase.BaseClass;

public class TC_008_AddtoCartTest1 extends BaseClass{
	
	@Test(groups= {"sanity","regression","master"})
	public void AddtoCartTest1()
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProductdetails("iMac");
		hp.clksearchbutton();
		
		SearchPage sp=new SearchPage(driver);
		
		sp.ClickAddtoCart();
		//sp.linkShoppingCart();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", sp.linkshoopingcart);	
		ShoppingcartPage scp=new ShoppingcartPage(driver);
		boolean targetpage=scp.AddProductPresent();
		
		System.out.println(targetpage);
		if(targetpage==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}catch(Exception e)
		{
		Assert.fail();
		}
		finally
		{
			logger.info("******************* Test Completed ****************************");
		}
	}
}
	
	
