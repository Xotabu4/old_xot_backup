package mainPackage.frameWork.Leads_and_Leads_providers;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperWithWebDriverBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class DebtorLeadsHelper extends HelperWithWebDriverBase{

	public DebtorLeadsHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void openUnassignedLeadsPage() {
		
		
		if (userIsLogged() == false){
			
			manager.getNavigationHelper().loginAsLeadProvider();
			
			}
		
		click(By.linkText("Unassigned leads"));
		
	}
	
	public void openAssignedLeadsPage() {
		
		if (userIsLogged() == false){
			
		manager.getNavigationHelper().loginAsLeadProvider();
		
		}
		
		click(By.linkText("Assigned leads"));
	}
	
	public Boolean userIsLogged() {
		if (isElementPresent(By.id("logindisplay")) == true) {
			return true;
		}
		else {
			return false;
		}
		
	}

	
	public void selectItemInDropdown(String value) throws Exception {

		/*if (value == "Valid"){*/
			dropdownSelectByValue(By.id("ddlStatusFilter"),value);
		/*}
		if (value == "NotValid") {
			dropdownSelectByValue(By.id("ddlStatusFilter"),"NotValid");
		}*/
		
		waitForElement(By.cssSelector("div.loadmask-msg > div"), false);
		
		
	}

	public void assertLeadsStatusesInTable(String statusToMatch) throws Exception {
		
		String tableStatusXpath = null;
		System.out.println(manager.getProperty("DebtorLeadsURL")+"Leads/Unassigned");
		System.out.println(getCurrentURL());

		if (assertAssignedPage() == false){
			
			tableStatusXpath = ".//*[@id='tableLeads']/tbody/tr/td[9]";
		}
		
		if (assertAssignedPage() == true){
			
			tableStatusXpath = ".//*[@id='tableLeads']/tbody/tr/td[10]";
		}
		List<WebElement> columns = findElements(By.xpath(tableStatusXpath));
			
		  		for (WebElement column: columns) {
		  			String status = column.getText();
		  			
		  			System.out.println(status);
		   
		   			assertThat(status, equalTo(statusToMatch));
		  		}
	
	}
	
	public boolean assertAssignedPage() throws Exception {
		
	if (getCurrentURL().contentEquals(manager.getProperty("DebtorLeadsURL")+"Leads/Assigned")){
		return true;
	}
	if (getCurrentURL().contentEquals(manager.getProperty("DebtorLeadsURL")+"Leads/Unassigned")){
		return false;
	}
	else{
		openURL(manager.getProperty("DebtorLeadsURL"));
		return false;
	}
	
	
	}

	public void selectAndAssertStatus(String value) throws Exception {
		
		//Method gets a value for filter and asserting in parameters.
		
		selectItemInDropdown(value);
		
		assertLeadsStatusesInTable(value);
		
	}

}