package com.seleniumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.seleniumautomation.base.BaseClass;
import com.seleniumautomation.pagelocators.CoronaVirusIndiaCasesPageLocators;


public class CoronaVirusIndiaCasesPage extends BaseClass {
	
	public CoronaVirusIndiaCasesPageLocators locator;

	public CoronaVirusIndiaCasesPage() {
		this.locator = new CoronaVirusIndiaCasesPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.locator);
	}

	public void clickOnNoThanksLinksInPopUp()
	{
		driver.switchTo().activeElement();
		locator.NoThankslink.click();
	}
	
	public void switchToFrame()
	{
		driver.switchTo().frame(locator.frame);
	}
	public int countTheTotalCases() {
		
		int totalcases=0;
		for(int i = 1; i <= locator.rowcount.size(); i++)
		{
			WebElement cases = driver.findElement(By.xpath("//table[@class='ind-mp_tbl sortable']/tbody/tr["+i+"]/td[2]/p"));
			if(cases.getText().contains("\n"))
			{
			int in = cases.getText().replace("\n","@").indexOf('@');
			String s = cases.getText().replace("\n","@").substring(0, in).replaceAll(",", "");
			//System.out.println(s);
			totalcases= totalcases+Integer.parseInt(s);

			}
			else
			{
				totalcases= totalcases+Integer.parseInt(cases.getText());

			}
			
		}
		System.out.println("total cases: "+totalcases);

		

		
		return totalcases;
		

	}


}
