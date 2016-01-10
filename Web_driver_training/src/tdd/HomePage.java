package tdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

		
	private WebDriver driver;
	
	//TODO Field decorator in PageFactory
	@FindBy (css = "a[title=\"New Action (n)\"]")
	WebElement buttonCreateNewAction;
	
	@FindBy (id = "next_action_name")
	WebElement fieldActionName;
	
	@FindBy (id = "move_to_top")
	WebElement checkboxMoveToTop;

	@FindBy (id = "create_next_action_btn")
	WebElement buttonCreateNewActionSubmit;
	
	@FindBy (id = "next_action_due")
	WebElement fieldNextDay;
	
	
	String URL = "http://localhost:5500";
		
		
	public HomePage(WebDriver driver) {
		  this.driver = driver;
		
	}

	public void createNewAction(String actionname) {
		
		
		buttonCreateNewAction.click();
		
		fieldActionName.sendKeys(actionname);
		//checking "move to top checkbox"
		checkboxMoveToTop.click();
		buttonCreateNewActionSubmit.click();
		
	
	}

	public void open() {
		driver.get(URL);
		
	}
	
	ActionsList currentList = PageFactory.initElements(driver, ActionsList.class);
	
	

	public void createNewOutDatedAction(String actionname) {
	
		

		
		buttonCreateNewAction.click();
		
		fieldActionName.sendKeys(actionname);
		//checking "move to top checkbox"
		
		fieldNextDay.sendKeys("yesterday");
		checkboxMoveToTop.click();
		buttonCreateNewActionSubmit.click();

	}

	public void completeActionByIndex(int i) {
		
		ActionsList currentList = PageFactory.initElements(driver, ActionsList.class);
		currentList.completeActionByIndex(i);
		
		
		
	}
	
}
