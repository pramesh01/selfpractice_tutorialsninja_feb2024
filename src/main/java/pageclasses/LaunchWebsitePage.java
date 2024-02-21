package pageclasses;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import baseclass.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchWebsitePage extends TestBase {
	Properties prop;
	public LaunchWebsitePage(WebDriver driver) {
		super(driver);
	}
	
	public DashboardPage launchWebsiteInBrowser() {
		String path=System.getProperty("user.dir")+"//src//main//resources//Project.properties";
		try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FileNot found exception.");
		 }
		System.out.println("URL from project prop file is - "+prop.getProperty("url"));
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		//driver.get("https://tutorialsninja.com/demo");
		driver.get(prop.getProperty("url"));
		return new DashboardPage(driver);
	}
}
