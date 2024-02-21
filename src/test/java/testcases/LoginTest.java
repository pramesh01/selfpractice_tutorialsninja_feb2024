package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageclasses.DashboardPage;
import pageclasses.HomePage;
import pageclasses.LaunchWebsitePage;
import pageclasses.LoginPage;

public class LoginTest {
	WebDriver driver;
	DashboardPage dp;;
	LoginPage lp;
	LaunchWebsitePage lwp;
	HomePage hp;
	
	@BeforeMethod
	public void init() {
		System.out.println("before every method");
		lwp=new LaunchWebsitePage(driver);
		//lwp.launchWebsiteInBrowser();
	 }
	@Test
	public void loginTest() throws InterruptedException {
		dp=lwp.launchWebsiteInBrowser();
		lp=dp.gotoLoginPage();
		hp=lp.gotoapplicationHomepage();
		hp.logOutfromApplication();
	 }
	
	@AfterMethod
	public void quitTest() {
		System.out.println("after every test - Closing browser..");
		hp.quitBrowser();
	}
	
}
