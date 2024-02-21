package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public Properties prop;
	
	public WebDriver openBrowser(String browserName) {
		prop=new Properties();
		File filePath=new File("src//test//resources//Project.properties");
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));	
		  }
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	 driver.get(prop.getProperty("url"));
	return driver;
	 }
      }