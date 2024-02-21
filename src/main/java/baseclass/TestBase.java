package baseclass;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	String path="nsgbs";
	
	public TestBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}