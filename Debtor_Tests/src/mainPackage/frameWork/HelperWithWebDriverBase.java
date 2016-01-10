package mainPackage.frameWork;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelperWithWebDriverBase extends HelperBase {
	
	
	protected WebDriver driver;

	public HelperWithWebDriverBase (ApplicationManager manager) {
		super(manager);
		driver = manager.getWebDriverHelper().getDriver();
	}

	public void type(By locator, String data) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(data);
	}
	
	protected String getWindowTile () {
		return driver.getTitle();
	}
	
	protected void dropdownSelectByIndex(String locator, int data) {
		Select dropdown = new Select(driver.findElement(By.name(locator)));
		dropdown.selectByIndex(data);
	}
	
	protected void dropdownSelectByValue(By locator, String data) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByValue(data);
	}
	
	protected Set<String> getTextFromDropdown(By locator){
		
		Select dropdown = new Select(driver.findElement(locator));
		List<WebElement> options = dropdown.getOptions();
		
		Set<String> textOptions = new HashSet<String>();
		
		for (WebElement option: options) {
			
			String attribute = option.getAttribute("value");
			
			System.out.println(attribute);
			
			String textOfOption =  option.getText();
			
			System.out.println(textOfOption);
			
			
			
			textOptions.add(textOfOption);
			
		}
		
		return textOptions;
		
		
	}
	
	
	
	public WebElement findElement(By linkText) {
		return driver.findElement(linkText);
	}
	
	protected List<WebElement> findElements(By linkText) {
		return driver.findElements(linkText);
	}
	
	public void openURL(String string) {
		driver.get(string);
		
	}
	
	
	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	protected boolean isElementPresent(By locator){
		
		//method for checking element present on page - if element present - returns true, if element not present - false.
		
		//i change value of implicilyWait to one second, and back to default value - without this checks runs very slow.
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		
		}
		finally {driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(manager.getProperty("implicityWait", "15")), TimeUnit.SECONDS);}
	}
	
	protected Actions startActionsBuilder(){
	 return new Actions(driver);
	}
	

	public void waitForElement(By element, boolean presentNotPresent) throws Exception, InterruptedException {
		
		//i change value of implicilyWait to one second, and back to default value - without this checks runs very slow.
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		Exception except = new Exception();
		
		 for (int second = 0;; second++) {
			 if (second >= 30) throw (except);

			if (isElementPresent(element) == presentNotPresent ) 
				break;  
			else {
				Thread.sleep(1000); 
				}
			
		 }
		 
		 driver.manage().timeouts().implicitlyWait(
				 Integer.parseInt(manager.getProperty("implicityWait", "15")), TimeUnit.SECONDS);
	}	 
	
	public void submitCreation() {
		click(By.id(MakeFullLink("Button1")));
	}
	
	public String MakeFullLink(String Id) {

		return 	String.format("MainBodyPlaceHolder_ContentPlaceHolder1_%s", Id);
		
	}
	
	
	
	
	/*public void waitForPopUp(final String windowName, int timeoutMs)
	{
	   new WaitForPopUp()
	   {
	      @Override
	      public boolean until()
	      {
	         try
	         {
	            driver.switchTo().window(windowName);
	            return true;
	         }
	         catch (SeleniumException ignored) { }
	         return false;
	      }
	   }.wait(30000);
	}
	*/
}
