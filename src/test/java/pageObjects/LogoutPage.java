package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	WebDriver driver;
    public LogoutPage(WebDriver driver)
    {
    	super(driver);
    }
    
    @FindBy(xpath="//div[@class='list-group']//a[1]")
    WebElement LoginBtn;
    
    public void clickLoginBtn()
    {
    	LoginBtn.click();
    }
}
