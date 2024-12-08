package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingcartPage;
import testBase.BaseClass;

public class TC_013_Validate_ReviewOnProduct extends BaseClass{
	
	@Test(groups= {"regression","master"})
	void ReviewOnProduct() throws InterruptedException 
	{

		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		SearchPage sp=new SearchPage(driver);
		ProductPage pp=new ProductPage(driver);
		ShoppingcartPage scp=new ShoppingcartPage(driver);
		logger.info("***Login with Existing User Account***");
		
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail("adarsha.krishnappa@gmail.com");
		lp.setPassword("Password");
		Thread.sleep(4000);
		lp.clickLogin();
		hp.enterProductdetails(P.getProperty("searchProductName"));
		hp.clksearchbutton();
		sp.ClickselectedProduct();
		Log.debug("***********Review Started***********");
		Thread.sleep(3000);
		pp.clicktabReview();
		Thread.sleep(3000);
		pp.setyourname("Ram Kumar");
		Thread.sleep(3000);
		pp.setyourReview("I loved the product, using from past 10 years could not found any issue and Thank you!!");
		pp.setRatingofProduct();
		pp.clickbtncontinue();
		boolean Targetmesage=pp.getConfirmationMsg();
		
		if(Targetmesage==true)
		{
		Assert.assertTrue(true);
		Log.info("***********Test Passed***********");
		}else
		{
			Assert.assertTrue(false);
			Log.error("***********Test Failed***********");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			Log.error("***********Test Finished***********");
		}
		
	}

}
