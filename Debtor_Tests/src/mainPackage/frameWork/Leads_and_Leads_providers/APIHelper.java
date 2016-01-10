package mainPackage.frameWork.Leads_and_Leads_providers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperWithWebDriverBase;

import org.openqa.selenium.By;

public class APIHelper extends HelperWithWebDriverBase{
	
	public APIHelper(ApplicationManager manager) {
		super(manager);
	}

	public void assertCorrectError(String error) {
		assertThat(manager.getNavigationHelper().findElement(By.xpath("//body")).getText(), equalTo(error));
	}

	public void sendAPIrequestWithAffiliateAssigment(LeadsObject LeadsObject) {
		manager.getNavigationHelper().openURL(ConfigureAPILink(LeadsObject, true));
	}
	
	public void sendAPIrequest(LeadsObject LeadsObject) {
		manager.getNavigationHelper().openURL(ConfigureAPILink(LeadsObject, false));
	}
	
	public String ConfigureAPILink
	(LeadsObject LeadsObject, Boolean SetAffiliateID) {
		System.out.println(manager.getProperty("DebtorLeadsURL") + String.format("Api/AddLead?lpid="+manager.getProperty("LeadProviderID")+"&f=%1$s&l=%2$s&d=%3$s&e=%4$s&p=%5$s&a=%6$s&ata="+manager.getProperty("AfiliateID"), 
							LeadsObject.leadFirstName, LeadsObject.leadLastName, LeadsObject.leadDebtAmount, LeadsObject.leadEmail, LeadsObject.leadPhoneNumber, LeadsObject.leadAge));

		if (SetAffiliateID == true){

			return 	manager.getProperty("DebtorLeadsURL") + 
			String.format("Api/AddLead?lpid="+manager.getProperty("LeadProviderID")+"&f=%1$s&l=%2$s&d=%3$s&e=%4$s&p=%5$s&a=%6$s&ata="+manager.getProperty("AfiliateID"), 
							LeadsObject.leadFirstName, LeadsObject.leadLastName, LeadsObject.leadDebtAmount, LeadsObject.leadEmail, LeadsObject.leadPhoneNumber, LeadsObject.leadAge);
			
		}

		return 	manager.getProperty("DebtorLeadsURL") + 
		String.format("Api/AddLead?lpid="+manager.getProperty("LeadProviderID")+"&f=%1$s&l=%2$s&d=%3$s&e=%4$s&p=%5$s&a=%6$s&ata=", 
						LeadsObject.leadFirstName, LeadsObject.leadLastName, LeadsObject.leadDebtAmount, LeadsObject.leadEmail, LeadsObject.leadPhoneNumber, LeadsObject.leadAge);
		
	}

	public void assertCorrectOKAnswer() {
		assertThat(manager.getNavigationHelper().findElement(By.xpath("//body")).getText(), containsString("\"OK\", "));
		//TODO 
	}
	
	
	
}
