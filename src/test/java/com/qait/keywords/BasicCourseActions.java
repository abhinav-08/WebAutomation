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

public class BasicCourseActions extends GetPage
{

	 public BasicCourseActions(WebDriver driver) {
	        super(driver, "BasicCourse");
	    }

	public void launchApplicationUrl() 
        {
            driver.get(YamlReader.getData("app_url"));
	}
	
	public void navigateToBasicCourse() {
		element("link_basicCourse").click();
	}
	
	public String getGridHeader() {
		return element("label_grid").getText();
	}
        public void navigateToDungeon()
        {
            element("green_box").click();
        }
        
        public void dungeonRepaintBox()
        { 
            switchToDefaultContent();
            switchToFrame("main");
        
            String box1color=element("dungeon_boxColor").getAttribute("class");
            switchToFrame("child");
        
       
            String box2color=element("dungeon_boxColor").getAttribute("class");
            while(!(box1color.equals(box2color)))
            {
                switchToDefaultContent();
                switchToFrame("main");
                element("dungeon_repaintBox").click();
                switchToDefaultContent();
                switchToFrame("main");
                switchToFrame("child");
                box2color=element("dungeon_boxColor").getAttribute("class");
                
                
            }
            switchToDefaultContent();
            switchToFrame("main");
            element("proceed").click();
        }
        
        public void dragAndDrop()
        {
            WebElement dragbox=element("drag_box");
            WebElement dropbox=element("drop_box");
            Actions act=new Actions(driver);
            act.dragAndDrop(dropbox, dragbox).build().perform();
            element("proceed").click();
        }
        
        public void popupHandling()
        {
            String mainWindow=getWindowHandle();//storing current window's reference for future purpose
            element("Launch Popup").click();
            Set<String> s1=getWindowHandles();//getting all windows
            Iterator<String> i1=s1.iterator();
         
            while(i1.hasNext())
            {
                String secondaryWindow=i1.next();
                if(!mainWindow.equalsIgnoreCase(secondaryWindow)){
                 switchToWindow(secondaryWindow);
                 element("name").sendKeys("abhinav tyagi");
                 element("submit").click();
             }
         }
         
         switchToWindow(mainWindow);//coming back to original window
         element("proceed").click();
         
        }
        
        public void cookiehandle()
        {
            String mainwindow=driver.getWindowHandle();
            driver.findElement(By.linkText("Launch Popup Window")).click();
            Set<String> s=driver.getWindowHandles();
            Iterator<String> i=s.iterator();
            while(i.hasNext())
            {
                String secwindow=i.next();
                if(!(mainwindow.equalsIgnoreCase(secwindow)))
                {
                    driver.switchTo().window(secwindow);
                    driver.findElement(By.id("name")).sendKeys("Himanshu Singh");
                    driver.findElement(By.id("submit")).click();
                }
            }
            driver.switchTo().window(mainwindow);
            element("proceed").click();
            
            
        }
	
}
