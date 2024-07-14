package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ShoppingcartPage;
import testBase.BaseClass;

public class TC_009_AddtoCartTest2 extends BaseClass{

	@Test(groups= {"sanity","regression","master"})
	public void Addtocarttest2()
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.clickbtnDesktops();
		hp.clickbtnshowAllDesktops();
		
		DesktopsPage dp=new DesktopsPage(driver);
		dp.clickonMacElement();
		dp.clickonAddtoCart();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", dp.linkShoopingCart);
		
		ShoppingcartPage sp=new ShoppingcartPage(driver);
		boolean targetpage=sp.getShoopingCartConfirmsg();
		
		if(targetpage==true)
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.fail();
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
			logger.info("***************** Test Completed *******************");
		}
	
   }
	
}
