package webDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAction {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:5500";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
	public void testCreateNewAction(){
		
		driver.get(baseUrl);
		
		
		
		driver.findElement(By.cssSelector("a[title=\"New Action (n)\"]")).click();
		
		new Select(driver.findElement(By.id("next_action_status"))).selectByIndex(0);
		
		String action = "testActionDRAGGABLE!";
		
		driver.findElement(By.id("next_action_name")).sendKeys(action);
		//checking "move to top checkbox"
		driver.findElement(By.id("move_to_top")).click();
		driver.findElement(By.id("create_next_action_btn")).click();
		
		
		//String action = driver.findElement(By.cssSelector("#action_list_body_current * li:first-child * table")).getText();
		
		try {
			assertTrue(action.matches(driver.findElement(By.cssSelector("#action_list_body_current * li:first-child * table")).getText()));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			  WebElement firstItem = driver.findElement(
			    By.cssSelector("#action_list_body_current * li:first-child"));
			  Actions builder = new Actions(driver);
			  builder.dragAndDrop(firstItem, driver.findElement(By.cssSelector("#action_list_body_current * li:last-child")))
			  .build().perform();
		
		
		
	}
	
	//@Test
	
	public void testCheckBoxClicking () {
		
		driver.get(baseUrl);
		
		driver.findElement(By.linkText("Preferences")).click();
		
		List<WebElement> checkboxlist = driver.findElements(By.cssSelector("#content>form * input[type='checkbox']"));
		
		for (WebElement checkbox:checkboxlist) {
			
			if(checkbox.isDisplayed() && !checkbox.isSelected()) {
				
				checkbox.click();
				System.out.println(checkbox.getTagName() + " is clicked!");
				
			}else {System.out.println(checkbox.getTagName() + " is NOT clicked!");}
			
			
			
		}
		
	}
	
	
	@Test
	
	public void testCompleteTask () {
		
		driver.get(baseUrl);
		
		WebElement firstActionInList = driver.findElement(By.cssSelector("#action_list_body_current * li:first-child"));
		
		String textFromActions = firstActionInList.getText();
		
		System.out.println(firstActionInList.getText()); 
		
		WebElement completeAction = firstActionInList.findElement(By.cssSelector("img[title='Complete']"));
		
		completeAction.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#action_list_hdr_completed")).click();
		
		//System.out.println(testFromActions + " " + driver.findElement(By.cssSelector("#action_list_body_completed * li:first-child")).getText());
		
		assertTrue(textFromActions.matches(driver.findElement(By.cssSelector("#action_list_body_completed * li:first-child")).getText()));
		
		
		
	}
	
	

	public void dragAndDrop () {
	
	new WebDriverWait(driver, 5).until(
		    ExpectedConditions.visibilityOfElementLocated(
		      By.id("window_dialog_action_quick_search")));
		  
		  WebElement search = driver.findElement(
		    By.id("window_dialog_action_quick_search_top"));
		  Actions builder = new Actions(driver);
		  builder.dragAndDropBy(search, 200, 200).build().perform();
	
	}
	
	
	

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

}
