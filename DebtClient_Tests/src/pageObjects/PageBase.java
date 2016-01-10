package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import frameWork.ApplicationManager;
import frameWork.HelperBase;

public class PageBase extends HelperBase{
	
	protected WebDriver driver = manager.getWebDriverHelper().getDriver();
	
	protected PageBase(ApplicationManager manager) {
		super(manager);
	}
		
	protected void type(WebElement userNameField, String data) {
		userNameField.clear();
		userNameField.sendKeys(data);
		
	}
		
	protected void dropdownSelect(String locator, int data) {
		Select dropdown = new Select(driver.findElement(By.name(locator)));
		dropdown.selectByIndex(data);
	}
	
	protected WebElement findElement(By linkText) {
		return driver.findElement(linkText);
	}
	
	protected List<WebElement> findElements(By linkText) {
		return driver.findElements(linkText);
	}
	
	protected void openURL(String string) {
		driver.get(string);
	}
	
	protected void click(By linkText) {
		findElement(linkText).click();
	}
	
	protected boolean isElementPresent(By by){
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		
		}
	}
	
}
