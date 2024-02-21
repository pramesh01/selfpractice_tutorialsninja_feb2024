package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.ExtentManager;

public class MyListener implements ITestListener{
	ExtentReports extentReports=ExtentManager.getExtentReports();
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		extentTest=extentReports.createTest(result.getName());
	}	

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "@Test is passed - "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "@Test is failed - "+result.getName());
		extentTest.fail("This test case has been failed."+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "@Test is Skipped - "+result.getName());
		extentTest.skip("This test case has been skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
