package com.qait.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;



public class AmazonAutomationTest extends TestSessionInitiator
{

	@Test(priority=1)
	public void launchApplication() throws Throwable {
        amazon.LaunchAmazon();
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)//searching some product on amazon
	public void navigateToBasicCourse() throws Throwable {
		amazon.searchSomething();
		Assert.assertTrue(true);
	}
}