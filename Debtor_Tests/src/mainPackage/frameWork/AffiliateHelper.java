package mainPackage.frameWork;

import org.openqa.selenium.By;

public class AffiliateHelper extends HelperWithWebDriverBase{

	protected AffiliateHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createAffiliate(AffiliateObject Affiliate) {

	// CSS selector for enterprise select on add affiliate page =    .inner_one>li>span[val='A good enterprise']  

	manager.getNavigationHelper().openAddAffiliatePage();
	fillAffiliateFields(Affiliate);
	submitCreation();
	}

	private void fillAffiliateFields(AffiliateObject affiliate) {
		
		type(By.id(MakeFullLink("tbFirstName")),affiliate.firstName);
		type(By.id(MakeFullLink("tbLastName")),affiliate.lastName);
		
		/*
		click(By.cssSelector("div.cuselText"));
		click(By.cssSelector(".inner_one>li>span[val='A Test Enterprise']"));
		*/
		
		type(By.id(MakeFullLink("tbAffiliateName")),affiliate.affiliateName);
		type(By.id(MakeFullLink("tbEmail")),affiliate.affiliateEmail);
		type(By.id(MakeFullLink("tbPhoneNumber")),affiliate.affiliatePhoneNumber);
		type(By.id(MakeFullLink("tbSupportPhoneNumber")),affiliate.affiliateSupportNumber);
		type(By.id(MakeFullLink("tbExtension")),affiliate.extension);
		type(By.id(MakeFullLink("tbNextGmailUrl")),affiliate.gmailURL);
		type(By.id(MakeFullLink("tbGroupId")),affiliate.groupID);
		type(By.id(MakeFullLink("tbWelcomeUrl")),affiliate.affiliateWelcomeMessage);
		
	}

}
