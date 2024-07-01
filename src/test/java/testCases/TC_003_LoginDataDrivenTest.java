package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"sanity","regression","master","Datadriven"})
	public void verifytest(String user,String pswd,String expt_rst)
	{
		logger.info("*************Test is Begin****************");	
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(user);
		lp.setPassword(pswd);
		lp.clickLogin();
		
		MyAccount ma=new MyAccount(driver);
		boolean targetpage=ma.isMyAccountPageExists();
		
		if(expt_rst.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				ma.ClickLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		if(expt_rst.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				ma.ClickLogOut();
				Assert.assertTrue(false);
			}
			else
			{
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
