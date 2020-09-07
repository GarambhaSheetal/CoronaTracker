package com.seleniumautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniumautomation.reports.ExtentManager;


public class BaseClass {

	public static WebDriver driver;
	public static String path = System.getProperty("user.dir");
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void config_Load()

	{
		try {
			if (driver == null) {
				fis = new FileInputStream(path + "/properties/config.properties");
				config.load(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void init_configuration() {
		String browser = config.getProperty("browser");
		System.out.println(browser);
		String url = config.getProperty("URL");
		System.out.println(url);
		try {
			if (browser.equals("ChromeBrowser")) {
				
				System.setProperty("webdriver.chrome.driver", path + "/Drivers/ChromeDriver/chromedriver 2");
				driver = new ChromeDriver();
			}

			else if (browser.equals("FirefoxBrowser")) {

				System.setProperty("webdriver.gecko.driver", path + "/Drivers/FirefoxDriver/geckodriver");
				driver = new FirefoxDriver();
			}

			else if (browser.equals("IEBrowser")) {

				System.setProperty("webdriver.ie.driver", path + "/Drivers/IEDriver/IEDriverServer");
				driver = new InternetExplorerDriver();

			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@AfterSuite
	public static void tear_Down() {

		try {
			
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
