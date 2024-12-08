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

public class TC_016_Validate_EstimateShippingandTaxes_functionality extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void EstimateShippingAndTaxes()
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
		Thread.sleep(3000);
		Log.info("********Click on Shipping and Taxes option**********");
        scp.ShippingTaxesOption();
        scp.SelectCountry();
        scp.SelectState();
        scp.Setpostcode("561202");
        scp.GetQuotesButton();
        Thread.sleep(3000);
        boolean target=scp.IsModalContentExists();
        if(target==true)
        {
        	Assert.assertTrue(true);
        	Log.info("********Test Passed*********");
        }else
        {
        	Assert.assertTrue(false);
        	Log.error("********Test Failed*********");
        }
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			Log.info("********Test Finised*********");
		}
	}

}
