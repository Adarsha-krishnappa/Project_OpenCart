package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_010_AddtoWishListTestDDT extends BaseClass{
	
	
	@Test(dataProvider="WishList",dataProviderClass=DataProviders.class , groups= {"sanity","smoke","master","Datadriven"})
	public void addtoWishListTest(String product, String Exp_res)
	{
		try {
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.enterProductdetails(product);
		hp.clksearchbutton();
		
		SearchPage sp=new SearchPage(driver);
		sp.clickonAddtoWishList();
        boolean targetpage=sp.IsWishListlinkExists();
        
        if(Exp_res.equalsIgnoreCase("valid"))
        {
        if(targetpage==true)
        {
        	hp.clearproductdeatils();
        	Assert.assertTrue(true);
        }else
        {
        	
        	Assert.fail();
        }
        }
        
        if(Exp_res.equalsIgnoreCase("invalid"))
        {
        	if(targetpage==false)
        	{
        		hp.clearproductdeatils();
        		Assert.assertTrue(true);
        	}
        	else
        	{
        		
        		Assert.fail();
        	}
        }
       
	}catch(Exception e)
	{
		Assert.fail();
	}
	finally
	{
		logger.info("*******************Test Completed************************");
	}
		
	}

}
