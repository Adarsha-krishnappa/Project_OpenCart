package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.AccountinformationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_012_Validate_Updating_UserDeatils extends BaseClass{
	
	@Test(groups= {"master","regression"})
	void Updating_UserDeatils()
	{
		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		MyAccount ma=new MyAccount(driver);
		LogoutPage lop=new LogoutPage(driver);
		AccountinformationPage ai=new AccountinformationPage(driver);
		
		logger.info("***Login with Existing User Account***");
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail("adarsha.krishnappa@gmail.com");
		lp.setPassword("Password");
		Thread.sleep(4000);
		lp.clickLogin();
		ma.clickMyAccountBtn();
		ma.clickOnMyAccountOption();
		ma.clickonEditinfoLink();
		
		
		logger.info("***Updating Existing Account Deatils ***");
		ai.UpdateFirstname("Adarsha");
		ai.UpdateLastname("Krishnappa");
		ai.UpdateEmail("krishnappa.adarsha@gmail.com");
		ai.UpdateTelephone("9090909090");
		ai.clickOnContinueBtn();
		boolean status1=ma.isSuccessMsgDisplayed();
		if(status1==true)
		{
			logger.info("***Account deatils are updated successfully***");
			Assert.assertTrue(true);
		}else
		{
			logger.info("***Account deatils are NOT updated successfully***");
			Assert.assertTrue(false);
		}
		ma.ClickLogOut();
		
		
		logger.info("***Login with Updated Email and Old Password***");
		lop.clickLoginBtn();
		lp.setEmail("krishnappa.adarsha@gmail.com");
		lp.setPassword("Password");
		Thread.sleep(4000);
		lp.clickLogin();
		boolean target1=ma.isMyAccountPageExists();
		if(target1==true)
		{
			Assert.assertTrue(true, "Test Passed for 1st condition");
		}else
		{
			Assert.assertTrue(false, "Test Failed for 1st condition");
		}
		
		
		logger.info("***Updating Updated email id to orginal email id***");
		ma.clickonEditinfoLink();
		ai.UpdateFirstname("A");
		ai.UpdateLastname("K");
		ai.UpdateEmail("adarsha.krishnappa@gmail.com");
		ai.UpdateTelephone("1234567890");
		ai.clickOnContinueBtn();
		boolean status2=ma.isSuccessMsgDisplayed();
		if(status2==true)
		{
			logger.info("***Account deatils are updated successfully***");
			Assert.assertTrue(true);
		}else
		{
			logger.info("***Account deatils are NOT updated successfully***");
			Assert.assertTrue(false);
		}
		ma.ClickLogOut();
		
		
		logger.info("***Login with Old Email and Old Password***");//mean recently updated one 2nd email id to 1st email id
		lop.clickLoginBtn();
		lp.setEmail("adarsha.krishnappa@gmail.com");
		lp.setPassword("Password");
		Thread.sleep(4000);
		lp.clickLogin();
		boolean target2=ma.isMyAccountPageExists();
		if(target2==true)
		{
			Assert.assertTrue(true, "Test Passed for 2nd condition");
		}else
		{
			Assert.assertTrue(false, "Test Failed for 2ns condition");
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			logger.info("Test is Finished");
		}
	}
	

}
