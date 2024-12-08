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

public class TC_014_Validate_CouponCode_Functionality extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void CouponCode_Functionality()
	{
		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		SearchPage sp=new SearchPage(driver);
		ProductPage pp=new ProductPage(driver);
		ShoppingcartPage scp=new ShoppingcartPage(driver);
		Log.info("********Login with Existing Acount**********");
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(P.getProperty("email"));
		lp.setPassword(P.getProperty("password"));
		lp.clickLogin();
		hp.enterProductdetails(P.getProperty("searchProductName"));
		hp.clksearchbutton();
		sp.ClickselectedProduct();
		pp.btnAddtoCart();
        pp.ClickShoppingcartLink();
		scp.UseCouponCodeOption();
		scp.ApplyCouponbutton();
		Thread.sleep(3000);
		boolean target=scp.IsCouponErrorAlertExists();
		if(target==true)
		{
			Assert.assertTrue(true);
			Log.info("*************Test Passed*****************");
		}else
		{
			Assert.assertTrue(false);
			Log.info("*************Test Failed*****************");
		}
		scp.CloseWarning();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Test Finished");
			Log.info("*************Test Completed***************");
		}
	
		
		
		
	}

}
