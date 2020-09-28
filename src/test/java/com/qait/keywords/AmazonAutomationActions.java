package com.qait.keywords;

import org.openqa.selenium.WebDriver;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonAutomationActions extends GetPage
{

	public AmazonAutomationActions(WebDriver driver) 
	{
	    super(driver, "AmazonFile");
	}

	public void LaunchAmazon()
	{
		driver.get(YamlReader.getData("amazonLink"));
	}

	public void searchSomething() throws InterruptedException
	{
		element("searchBox").sendKeys(YamlReader.getData("amazonSearchItem"));
		element("searchButton").click();
		Thread.sleep(10000);
	}
}