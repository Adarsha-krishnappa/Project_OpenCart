package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingcartPage;
import testBase.BaseClass;


public class TC_011_Validate_Shopping_Cart_page extends BaseClass{
	
	@Test(groups= {"master","regression"})
	void Validate_ShopingCartPage()
	{
		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		SearchPage sp=new SearchPage(driver);
		ProductPage pp=new ProductPage(driver);
		ShoppingcartPage scp=new ShoppingcartPage(driver);
		
		
		hp.enterProductdetails("mac");
		hp.clksearchbutton();
		sp.ClickselectedProduct();
		pp.btnAddtoCart();
		pp.ClickShoppingcartLink();
		Thread.sleep(3000);
		boolean productExits=scp.AddProductPresent();
		
		if(productExits==true)
		{
			logger.info("********Test passed************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("********Test failed************");
			Assert.assertTrue(false);
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		finally 
		{
			logger.info("********Test Finished************");
		}
		
		
		
	}

}
