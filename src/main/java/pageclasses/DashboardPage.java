package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseclass.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	WebElement MyAccountMenu;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[2]/a")
	WebElement LoginLink;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	 public LoginPage gotoLoginPage() {
	 driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
	 //MyAccountMenu.click();
	 driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
     //LoginLink.click();
	 return new LoginPage(driver);
	 }
    }