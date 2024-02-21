package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import baseclass.TestBase;

public class LoginPage{
	
	WebDriver driver;
	@FindBy(id="input-email")
	WebElement UserEmailbox;
	
	@FindBy(id="input-password")
	WebElement UserPasswordbox;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div/form/input")
	WebElement LoginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public HomePage gotoapplicationHomepage(String emailid,String password) {
		UserEmailbox.sendKeys(emailid);
		//UserEmailbox.sendKeys(prop.getProperty("username"));
		//UserPasswordbox.sendKeys(prop.getProperty("password"));
		UserPasswordbox.sendKeys(password);
		LoginButton.click();
		String expectedText="Edit your account information";
		String actualText=driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[1]/a")).getText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Login Text verified and User is Logged In to console");
		return new HomePage(driver);
	 }
       }