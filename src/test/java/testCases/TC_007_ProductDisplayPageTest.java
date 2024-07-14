package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_007_ProductDisplayPageTest extends BaseClass {

	@Test(groups={"sanity","smoke","regression"})
	public void ProductDisplayPage()
	{
		HomePage hp=new HomePage(driver);
		hp.enterProductdetails("iMac");
		hp.clksearchbutton();
		
		SearchPage sp=new SearchPage(driver);
		sp.ClickselectedProduct();
		
		ProductPage pp=new ProductPage(driver);
		pp.clicktabReview();
		pp.setyourname(pp.randomeStringName().toUpperCase());
		pp.setyourReview(pp.randomeStringReview().toUpperCase());
		pp.setRatingofProduct();
		pp.clickbtncontinue();
		pp.getConfirmationMsg();
		
	}
}
