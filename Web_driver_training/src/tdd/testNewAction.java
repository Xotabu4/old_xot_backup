package tdd;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class testNewAction {

	 private WebDriver driver;

	 @Before
	 public void setup() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  
	 }
	 
	 @After
	 public void tearDown() {
	  driver.quit();

	 }
	 
	 
	 @Test
	 public void testCompleteSelectedItemInList() {
		 
		 HomePage hPage = PageFactory.initElements(driver, HomePage.class);
		 
		 hPage.open();
		 
		 hPage.completeActionByIndex(1);
		 
	 }
	 
	 
	//@Test
	public void testNewActionCreation() {
		
		HomePage hPage = PageFactory.initElements(driver, HomePage.class);
		
		hPage.open();
		
		String actionname = "actionName";
		hPage.createNewAction(actionname);
		
		assertTrue(actionname.matches(driver.findElement(By.cssSelector("#action_list_body_current * li:first-child * table")).getText()));
		
	}
	
	
	//@Test
	public void testNewOutDatedActionCreation() {
		
		HomePage hPage = new HomePage(driver);
		
		hPage.open();
		
		String actionname = "actionNameOutDated";
		hPage.createNewOutDatedAction(actionname);
		
		assertTrue(actionname.matches(driver.findElement(By.cssSelector("#action_list_body_current * li:first-child * table")).getText()));
		
		
		//TODO write assertion for outdated action.
		//assertTrue(actionname.matches(driver.findElement(By.cssSelector("")).getText()));
		
		
	}

}
