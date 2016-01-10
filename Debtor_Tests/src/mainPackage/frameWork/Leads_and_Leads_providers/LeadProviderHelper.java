package mainPackage.frameWork.Leads_and_Leads_providers;

import org.openqa.selenium.By;

import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperWithWebDriverBase;

public class LeadProviderHelper extends HelperWithWebDriverBase{
	
	public LeadProviderHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createLeadProvider(LeadProviderObject LeadProvider) {
		
		manager.getNavigationHelper().openAddLeadProviderPage();
		fillLeadProvidersFields(LeadProvider);
		submitCreation();
		
	}

	private void fillLeadProvidersFields(LeadProviderObject LeadProvider) {
		
		fillInfoPart(LeadProvider);
		fillUserFields(LeadProvider);
		
	}


	private void fillInfoPart(LeadProviderObject leadProvider) {
		
		type(By.id(MakeFullLink("tbLeadProviderName")), leadProvider.LeadProviderAccountName);
		type(By.id(MakeFullLink("tbNextGmailUrl")), leadProvider.gmailURL);
		type(By.id(MakeFullLink("tbGroupId")), manager.getProperty("GroupId"));
		
	}
	private void fillUserFields(LeadProviderObject leadProvider) {
		
		type(By.id(MakeFullLink("tbFirstName")), leadProvider.userFirstName);
		type(By.id(MakeFullLink("tbLastName")), leadProvider.userLastName);
		type(By.id(MakeFullLink("tbEmail")), leadProvider.userEmail);
		
	}


}
