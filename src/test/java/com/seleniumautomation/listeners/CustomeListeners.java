package com.seleniumautomation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.seleniumautomation.base.BaseClass;
import com.seleniumautomation.utilities.Utilities;



public class CustomeListeners extends BaseClass implements ITestListener {
	
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getName()+ " Test case started");
		test = report.startTest(result.getName().toUpperCase());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getName()+ " Test case passed");
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		report.endTest(test);
		report.flush();
	}

	public void onFinish(ITestContext context)
	{
		System.out.println(context.getName()+ " Test case finished");
	}

	public void onTestFailure(ITestResult result)
	{
		
		try {
			Utilities.captureScreenshots(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("The name of failed test case: "+result.getName());
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.sreenshotName));

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\"href=" + Utilities.sreenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + Utilities.sreenshotName + "><img src="
				+ Utilities.sreenshotName + " height=200 width=200></img></a>");
		report.endTest(test);
		report.flush();

	}
}
