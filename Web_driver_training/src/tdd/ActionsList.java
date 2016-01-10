package tdd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ActionsList {
	
	
	@FindBy (css = "#action_list_current")
	private WebElement currentList;
	
	
	private WebDriver driver;
	
	
	public ActionsList (WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void completeActionByIndex(int i) {

		System.out.println(currentList.findElement(By.xpath(".//*[@id='action_list_sortable_current'] // li [" + i + "]")).getText()+ "  NUMBER - " + i + "is completed");
		
		driver.findElement(By.xpath("(.//*[@id='action_list_current']//img[@title='Complete'])[" + i + "]")).click();
		
	}
	
	public void deleteActionByIndex(int i) {

		System.out.println(currentList.findElement(By.xpath(".//*[@id='action_list_sortable_current'] // li [" + i + "]")).getText()+ "  NUMBER - " + i + "is deleted");
		
		driver.findElement(By.xpath("(.//*[@id='action_list_current']//img[@title='Delete'])[" + i + "]")).click();
		
	}
	
	
	private int getActionId (int i) {
		
		//Gets Action ID by li id name number. Uses INDEX to find it.
		
		String htmlID = currentList.findElement(By.xpath(".//*[@id='action_list_sortable_current'] // li [" + i + "]")).getAttribute("id");
		
		int id = Integer.parseInt(htmlID.replace("current_action_", ""));
		
		return id;
	}

}
