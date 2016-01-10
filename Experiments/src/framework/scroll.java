package framework;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keyboard;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.MouseAction;

import org.testng.annotations.Test;



public class scroll {
	
	
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void run() throws Exception {
		
		driver.get("http://thedeepestsite.com/");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector(".btn.btnEnter")).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;;i++){
			
			driver.findElement(By.id("fb-login")).sendKeys(
					
					
					);
			
			
			
		}
		
	}
	
}
