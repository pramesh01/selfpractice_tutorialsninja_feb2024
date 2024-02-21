package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseclass.TestBase;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	WebElement myAccountbreadcrumb;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	WebElement logOutLink;
	
	@FindBy(xpath="//*[@id='content']/h1")
	WebElement logOutconfirmationmessage;
	
	public void logOutfromApplication() {
		myAccountbreadcrumb.click();
		logOutLink.click();
		String actualText=logOutconfirmationmessage.getText();
		String expectedText="Account Logout";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Logged Out successfully from website");
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
