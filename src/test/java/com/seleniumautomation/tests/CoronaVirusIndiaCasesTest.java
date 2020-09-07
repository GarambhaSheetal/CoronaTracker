package com.seleniumautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.seleniumautomation.base.BaseClass;
import com.seleniumautomation.pages.CoronaVirusIndiaCasesPage;



public class CoronaVirusIndiaCasesTest extends BaseClass {
	
	 public CoronaVirusIndiaCasesPage obj;
	 
	 @BeforeClass
		public void setup() {
			BaseClass.init_configuration();
			obj = new CoronaVirusIndiaCasesPage();
			}
		
	
	@Test
	public void verfiyTotalCasesCount()
	{
	
		obj.clickOnNoThanksLinksInPopUp();
		obj.switchToFrame();
		int res=obj.countTheTotalCases();
		Assert.assertEquals(res, 668686);
	}

	@AfterClass
	public void tearDown() {
		if (BaseClass.driver != null) {
			BaseClass.tear_Down();
}
	}
}
