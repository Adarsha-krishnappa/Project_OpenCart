package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_SearchProductTestDDT extends BaseClass {
	
	@Test(dataProvider="Searchproduct", dataProviderClass=DataProviders.class, groups= {"sanity","regression","master","Datadriven"})
	public void searchproduct(String product,String expcted_rst)
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProductdetails(product);
		hp.clksearchbutton();
		
		SearchPage sp=new SearchPage(driver);
		boolean targetpage=sp.isExistingproductavailabe();
		
		if(expcted_rst.equalsIgnoreCase("valid"))
		{
			if(targetpage==false)
			{
				hp.clearproductdeatils();
				Assert.assertTrue(true);
			}else
			{
				hp.clearproductdeatils();
				Assert.fail();
			}
		}
		if(expcted_rst.equalsIgnoreCase("invalid"))
		{
			if(targetpage==false)
			{
				hp.clearproductdeatils();
				Assert.fail();
			}
			else
			{
				hp.clearproductdeatils();
				Assert.assertTrue(true);
			}
		}
		
	   }catch(Exception e)
		{
			Assert.fail();
		}
		finally
			{
				logger.info("*************Test is completed****************");

			}
	}
}
