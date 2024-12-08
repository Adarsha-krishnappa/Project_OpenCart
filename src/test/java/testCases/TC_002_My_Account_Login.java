package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter registered username in username textbox
5) Enter password in password textbox
6) Click on login button
7) User must successfully login to the web page
*/
public class TC_002_My_Account_Login extends BaseClass {
	
	@Test(groups= {"sanity","master","regression"})
	public void my_accountlogin()
	{
		logger.info("*******test started********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(P.getProperty("email"));
		lp.setPassword(P.getProperty("password"));
		//lp.setpassword(P.getProperty("password"));
		lp.clickLogin();
		
		MyAccount Myacc=new MyAccount(driver);
		boolean Targetpage=Myacc.isMyAccountPageExists();
		
		Assert.assertEquals(Targetpage, true, "test passed");
		}
		catch(Exception e) {
		Assert.fail();
		}
		finally {
		logger.info("******test completed*******");
		}
	}

}
