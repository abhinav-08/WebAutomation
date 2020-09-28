package com.qait.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;



public class BasicCourseTest extends TestSessionInitiator
{

	@Test(priority=1)
	public void launchApplication() throws Throwable {
		basicCourse.launchApplicationUrl();
		Assert.assertEquals(basicCourse.getPageTitle(), "Welcome - T.A.T.O.C");
	}
	
	@Test(priority=2)
	public void navigateToBasicCourse() throws Throwable {
		basicCourse.navigateToBasicCourse();
		Assert.assertEquals(basicCourse.getGridHeader(), "Grid Gate");
	}
        
        @Test(priority=3)
	public void handlingTheGridGatePage() throws Throwable{
		basicCourse.navigateToDungeon();
		Assert.assertEquals(basicCourse.getGridHeader(), "Frame Dungeon");
	}
        
        @Test(priority=4)
	public void frameHandling() throws Throwable{
		basicCourse.dungeonRepaintBox();
		Assert.assertEquals(basicCourse.getGridHeader(), "Drag Around");
	}
        
        @Test(priority=5)
	public void dragAndDrop() throws Throwable{
		basicCourse.dragAndDrop();
		Assert.assertEquals(basicCourse.getGridHeader(), "Popup Windows");
	}
        
        @Test(priority=6)
	public void popUpHandling() throws Throwable{
		basicCourse.popupHandling();
		Assert.assertEquals(basicCourse.getGridHeader(), "Cookie Handling");
	}
        
        
}
