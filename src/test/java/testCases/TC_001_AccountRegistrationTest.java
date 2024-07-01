package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void test_accountRegistration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
			
		String password=randomAlphaNumeric();
			
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.contains("Your Account Has Been Created!"))
		{
			logger.info("********Test passed************");
			Assert.assertTrue(true);
		}else
		{
			logger.info("********Test failed************");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		
		} 
		catch (Exception e)
		{
				Assert.fail();
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
	}
	
	}

		
	

