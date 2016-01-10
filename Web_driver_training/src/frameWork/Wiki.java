package frameWork;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Wiki {
 @FindBy(id = "firstHeading")
 WebElement heading;
 
 private WebDriver driver;
 public Wiki(WebDriver driver) {
  this.driver = driver;
 }
 public String getTitle() {
  return heading.getText();
 }

}