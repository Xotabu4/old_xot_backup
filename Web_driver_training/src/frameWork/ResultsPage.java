package frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ResultsPage {
 private WebDriver driver;
 public ResultsPage(WebDriver driver) {
  this.driver = driver;
 }

 public String getNameOfLinkByIndex(int i) {
  return driver
    .findElement(By.xpath("(//ol[@id='rso']/li["+i+"]//a)[1]"))
    .getText();
 }

}