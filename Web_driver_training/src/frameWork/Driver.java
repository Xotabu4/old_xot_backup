package frameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
 private static WebDriver driver;
 public synchronized static WebDriver getDriver() {
  if(driver == null){
   driver = new FirefoxDriver();
  }
  return driver;
 }
}