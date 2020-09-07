package com.seleniumautomation.reports;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		try {
			if (extent == null) {
				extent = new ExtentReports(
						System.getProperty("user.dir") + "/target/surefire-reports/Extentreport/extentreport.html", true,
						DisplayOrder.OLDEST_FIRST);
				extent.loadConfig(new File(System.getProperty("user.dir") + "/reports/ReportConfig.xml"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extent;
	}


}
