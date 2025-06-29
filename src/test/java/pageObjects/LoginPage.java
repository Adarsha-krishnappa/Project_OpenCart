package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath = "//input[@id='input-email']")
private WebElement txtEmailAddress;

@FindBy(xpath = "//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath = "//input[@value='Login']")
WebElement btnLogin;

@FindBy(xpath="//a[text()='Forgotten Password']")
WebElement link_FrgtPswd;

public void setEmail(String email) {
	txtEmailAddress.sendKeys(email);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void clickLogin() {
	btnLogin.click();
}
public void clickforgetpassword()
{
	link_FrgtPswd.click();
}

}
