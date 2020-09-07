package com.seleniumautomation.pagelocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CoronaVirusIndiaCasesPageLocators {
	
		@FindBy(linkText="No Thanks")
		public WebElement NoThankslink;
		
		@FindBy(id="t5")
		public WebElement frame;

		@FindBy(xpath="(//table[@class='ind-mp_tbl sortable']/thead/tr/th)[1]")
		public WebElement states;
	
		@FindBy(xpath="(//table[@class='ind-mp_tbl sortable']/thead/tr/th)[2]")
		public WebElement cases;
		
		@FindBy(xpath="(//table[@class='ind-mp_tbl sortable']/thead/tr/th)[3]")
		public WebElement active;
		
		@FindBy(xpath="(//table[@class='ind-mp_tbl sortable']/thead/tr/th)[4]")
		public WebElement recovered;
		
		@FindBy(xpath="(//table[@class='ind-mp_tbl sortable']/thead/tr/th)[5]")
		public WebElement deaths;
		
		@FindAll({@FindBy(xpath="//table[contains(@class,'ind-mp_tbl sortable')]//tbody//tr")})
		public List<WebElement> rowcount;
}
