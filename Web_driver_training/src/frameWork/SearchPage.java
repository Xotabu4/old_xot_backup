package frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class SearchPage {
 private WebDriver driver;
 public SearchPage(WebDriver driver) {
  this.driver = driver;
 }

 public ResultsPage search(String request) {
  driver.findElement(By.id("gbqfq")).sendKeys(request+Keys.ENTER);
  return new ResultsPage(driver);
 }

 public void open() {
  driver.get("http://google.com");
  
 }
 
}
