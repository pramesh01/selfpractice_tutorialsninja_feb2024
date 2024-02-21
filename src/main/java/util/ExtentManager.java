package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
public static ExtentReports getExtentReports() {
		
String extenreportstoringpath=System.getProperty("user.dir")+"//Reports//seleniumReports.html";
ExtentSparkReporter esr=new ExtentSparkReporter(extenreportstoringpath);
esr.config().setDocumentTitle("Automtic generated docs title");
esr.config().setReportName("Automtic Generated Extent Reports");
ExtentReports extentReports=new ExtentReports();
extentReports.attachReporter(esr);
extentReports.setSystemInfo("Selenium Version","4.19.11");
extentReports.setSystemInfo("executed by","Pramesh KUmar");

return extentReports;

}
}
