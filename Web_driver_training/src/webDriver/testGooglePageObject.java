package webDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testGooglePageObject {
 
 private FirefoxDriver driver;

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
 public void testGoogleSearch() {
  SearchPage page = new SearchPage(driver);
  page.open();
  ResultsPage results = page.search("test automation");
  assertEquals(
    "Test automation - Wikipedia, the free encyclopedia", 
    results.getNameOfLinkByIndex(1));
 }
}