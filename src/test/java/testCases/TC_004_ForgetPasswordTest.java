package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_004_ForgetPasswordTest extends BaseClass {

	@Test(groups= {"sanity,master"})
	public void forgetpassword()
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.clickforgetpassword();
		
		MyAccount ma=new MyAccount(driver);
		ma.setConfirmEmail("123123admin@gmail.com");
		ma.clickContinue();
		boolean targetpage=ma.isresetpasswordsent();
		
		Assert.assertEquals(targetpage, true, "test passed");
		}catch(Exception e)
		{
			Assert.fail();
		}
		finally 
		{
			logger.info("******test completed*******");
		}
	}
	
}
