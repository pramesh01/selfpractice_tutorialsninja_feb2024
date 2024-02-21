package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import baseclass.TestBase;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	WebElement myAccountbreadcrumb;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	WebElement logOutLink;
	
	@FindBy(xpath="//*[@id='content']/h1")
	WebElement logOutconfirmationmessage;
	
	public void logOutfromApplication() throws InterruptedException {
		myAccountbreadcrumb.click();
		Thread.sleep(3000);
		logOutLink.click();
		Thread.sleep(3000);
		String actualText=logOutconfirmationmessage.getText();
		String expectedText="Account Logout";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Logged Out successfully from website");
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
