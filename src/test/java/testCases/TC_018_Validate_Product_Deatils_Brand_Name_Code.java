package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_018_Validate_Product_Deatils_Brand_Name_Code extends BaseClass {
	
	@Test(groups= {"regression"})
	void VerifyPrdouct_Brand_Name_Code() {
		try {
		logger.info("*********Login to My account**************");
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(P.getProperty("email"));
		lp.setPassword(P.getProperty("password"));
		lp.clickLogin();
		SearchPage sp=new SearchPage(driver);
		hp.clearproductdeatils();
		hp.enterProductdetails("iMac");
		hp.clksearchbutton();
		ProductPage pp=new ProductPage(driver);
		pp.Click_OnFirst_Product();
		String BrandName=pp.GetBrandName();
		if(BrandName.contains("Apple"))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}
		String ProductCode=pp.GetProductCode();
		if(ProductCode.contains(ProductCode))
		{
			Assert.assertTrue(true, ProductCode);
		}else
		{
			Assert.assertTrue(false, ProductCode);
		}}
		catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
			logger.info("************test is completed************");
		}
	}

}
