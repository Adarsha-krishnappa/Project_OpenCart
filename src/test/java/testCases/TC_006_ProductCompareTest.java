package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_006_ProductCompareTest extends BaseClass{
	
	@Test(dataProvider="compareProducts", dataProviderClass=DataProviders.class, groups= {"sanity","regression","master","Datadriven"})
	public void CompareProduct(String prduct,String exp_rest)
	{ 
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProductdetails(prduct);
		hp.clksearchbutton();
		
		SearchPage sp=new SearchPage(driver);
		sp.bottonProductCompare();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", sp.clickPrdtcomparLink);
		
		//sp.linkproductcomparition();
		ProductComparisonPage pcp=new ProductComparisonPage(driver);
	
		boolean targetpage=pcp.msgproductcomparisonexist();
		if(exp_rest.equalsIgnoreCase("valid"))
		if(targetpage==true)
		{
			hp.clearproductdeatils();
			Assert.assertTrue(true);
		}
		else
		{
			hp.clearproductdeatils();
			Assert.fail();
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
			logger.info("************************Test Completed**************************");
		}
		
		
		
		
	}

}
