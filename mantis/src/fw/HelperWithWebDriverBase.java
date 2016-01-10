package fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperWithWebDriverBase extends HelperBase {
	
	
	private WebDriver driver;

	protected HelperWithWebDriverBase (ApplicationManager manager) {
		super(manager);
		driver = manager.getWebDriverHelper().getDriver();
	}
	
	protected void type(By locator, String data) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(data);
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
		driver.get(manager.getProperty("baseURL") + string);
	}
	
	protected void openAbsoluteURL(String string) {
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
