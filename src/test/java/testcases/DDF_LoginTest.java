package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import util.DataUtil;
import util.MyXLSReader;

public class DDF_LoginTest extends BaseTest{
	WebDriver driver;
	MyXLSReader xls_reader;
	
	@Test(dataProvider="getData")
	public void qafoxDDFLoginTest(HashMap<String,String> hmap) {
		
		if(!DataUtil.isRunnable(xls_reader,"DDF_LoginTest","TestCases") || hmap.get("RunMode").equals("N")) {
			throw new SkipException("RunMode is 'NO' in xls file , so Skipping the Test.");
		}
		try {
		 driver= openBrowser(hmap.get("Browser"));
		 DashboardPage dp=new DashboardPage(driver);
		 LoginPage lp=dp.gotoLoginPage();
		 HomePage hp=lp.gotoapplicationHomepage(hmap.get("UserEmailID"),hmap.get("Password"));
		 
		 hp.logOutfromApplication();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		 //driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
		 //driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
		 //driver.findElement(By.id("input-email")).sendKeys(hmap.get("UserEmailID"));
		// driver.findElement(By.id("input-password")).sendKeys(hmap.get("Password"));
		 //driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).click();
		 
		 /*String expectedResult=hmap.get("ExpectedResult");
		 boolean expectedConvertedResult=false;
		 if(expectedResult.equalsIgnoreCase("Pass")) {
			 expectedConvertedResult=true;
		 }else if (expectedResult.equalsIgnoreCase("Fail")) {
			 expectedConvertedResult=false;
		 }
		 boolean actualResult=false;
		 try {
			 actualResult=driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		 }catch(Throwable e) {
			 actualResult=false;
		 }
		 Assert.assertEquals(actualResult, expectedConvertedResult);*/
	}
	
	@AfterMethod
	public void QuitSession() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=null;
		try {
		xls_reader=new MyXLSReader("src//test//resources//TestData.xlsx");
		data=DataUtil.getTestData(xls_reader, "DDF_LoginTest", "Data");
		}catch(Throwable e) {
			System.out.println("Getting Exception inside @DataProvider for DDF testdata");
			e.printStackTrace();
		}
		return data;
	}
}
