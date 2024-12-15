package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.AccountinformationPage;
import pageObjects.Address;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_017_Validate_AddNew_Address extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void AddAddress()
	{
		try {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		MyAccount ma=new MyAccount(driver);
		LogoutPage lop=new LogoutPage(driver);
		AccountinformationPage ai=new AccountinformationPage(driver);
		Address ad=new Address(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(P.getProperty("email"));
		lp.setPassword(P.getProperty("password"));
		lp.clickLogin();
		ma.ClickOnModifyAddressLink();
		ad.ClickOnNewAddressBtn();
		ad.SetFirstName(randomeString().toUpperCase());
		ad.SetLastName(randomeString().toUpperCase());
		ad.Setcompany("BlackBuck privite limited");
		ad.SetAddress1(P.getProperty("Address1"));
		ad.SetAddress2(P.getProperty("Address2"));
		ad.SetCity("Bangalore");
		ad.SetPostCode("563212");
		ad.SelectCountry();
		ad.SelectState();
		ad.SetDeafultAddress_Yes();
		ad.ClickOnContinueBtn();
		ad.ClickOnElement();
		boolean target=ad.SuccessfyllMessage();
		if(target==true)
		{
			Assert.assertTrue(true);
			Log.info("************ Test Passed ************");
		}else
		{
			Assert.assertTrue(false);
			Log.error("************ Test Failed ************");
		}		
		}catch(Exception e)
		{
			System.out.println(e);
			Assert.fail();
			Log.error("************ Test Failed ************");
		}
		finally
		{
			Log.info("********** Test Completed *************");
		}
		

	}

}
