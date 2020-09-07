package com.seleniumautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumautomation.base.BaseClass;

public class Utilities extends BaseClass{

	public static String sreenshotpath;
	public static String sreenshotName;

	public static void captureScreenshots(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		sreenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\ExtentReport\\" + sreenshotName));
		System.out.println("this is the Capture Screenshots");

	}

}
