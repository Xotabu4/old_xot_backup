package mainPackage.frameWork.Enterprise;

import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperWithWebDriverBase;

import org.openqa.selenium.By;
import org.yaml.snakeyaml.introspector.BeanAccess;

public class EnterpriseHelper extends HelperWithWebDriverBase {

	public EnterpriseHelper(ApplicationManager manager) {
		super(manager);
	}
	
	
	
	public void createEnterprise(EnterpriseUserObject Enterprise) {
		/*
		WebElement EnterpriseMenu = findElement(By.linkText("Enterprises"));
		WebElement EnterpriseAddLink = findElement(By.xpath("//*[@id='TopHeader_mTopHeaderMenu:submenu:26']/li[2]/a"));
		MovingMouseOverAndClick(EnterpriseMenu, EnterpriseAddLink);
		*/
		
		manager.getNavigationHelper().openAddEnterprisePage();
		fillEnterpriseFields(Enterprise);
		submitCreation();
		
	}

	private void fillEnterpriseFields(EnterpriseUserObject Enterprise) {
		
		fillInfoPart(Enterprise);
		fillCpParameters(Enterprise);
		fillEnterpriseUserFields(Enterprise);
		
	}

	private void fillInfoPart(EnterpriseUserObject EnterpriseObject) {
		
		type(By.id(MakeFullLink("tbResellerName")), EnterpriseObject.enterpriseName);
		
		if(EnterpriseObject.enterpriseName != null){
			
			type(By.id(MakeFullLink("tbGroupId")), manager.getProperty("GroupId"));
			
		}

		type(By.id(MakeFullLink("tbNextGmailUrl")), EnterpriseObject.gmailURL);
		type(By.id(MakeFullLink("tbSupportPhoneNumber")), EnterpriseObject.SupportPhoneNumber);
		type(By.id(MakeFullLink("tbExtension")), EnterpriseObject.Extension);
		
		if(EnterpriseObject.enterpriseName != null) {
			type(By.id(MakeFullLink("tbWelcomeUrl")), "Welcome message for"+EnterpriseObject.enterpriseName);
		}
		
	}

	private void fillCpParameters(EnterpriseUserObject EnterpriseObject) {
		
		fillTraditionalPlanFields(EnterpriseObject);
		fillSingleBidOptionFields(EnterpriseObject);
		fillMultipleBidOptionFields(EnterpriseObject);
	}



	private void fillMultipleBidOptionFields(
			EnterpriseUserObject EnterpriseObject) {
		
		click(By.id(MakeFullLink("cpMultipleBidOption_chxIsActive")));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtMinBid")),EnterpriseObject.multipleBidMinBid);
		type(By.id(MakeFullLink("cpMultipleBidOption_txtIncrement")),EnterpriseObject.multipleBidIncrement);
		type(By.id(MakeFullLink("cpMultipleBidOption_txtMaxBid")),EnterpriseObject.multipleBidMaxBid);
		
		click(By.id(MakeFullLink("cpMultipleBidOption_chxDDSCost")));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtDDSCost"),EnterpriseObject.multipleBidDDSCost));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtDDSMonthlyCost"),EnterpriseObject.multipleBidDDSMonthlyCost));

		click(By.id(MakeFullLink("cpMultipleBidOption_chxFDCPACost")));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtFDCPACost"),EnterpriseObject.multipleBidFDCPACost));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtFDCPAMonthlyCost"), EnterpriseObject.multipleBidFDCPAMonthlyCost));
		
		click(By.id(MakeFullLink("cpMultipleBidOption_chxFCRACost")));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtFCRACost"),EnterpriseObject.multipleBidFCRACost));
		type(By.id(MakeFullLink("cpMultipleBidOption_txtFCRAMonthlyCost"), EnterpriseObject.multipleBidFCRAMonthlyCost));
		
		
	}



	private void fillSingleBidOptionFields(EnterpriseUserObject EnterpriseObject) {
		
		click(By.id(MakeFullLink("cpOneBidOption_chxIsActive")));
		type(By.id(MakeFullLink("cpOneBidOption_txtDebtRate")),EnterpriseObject.singleBidDebtRestructureRate);
		
		click(By.id(MakeFullLink("cpOneBidOption_chxDDSCost")));
		type(By.id(MakeFullLink("cpOneBidOption_txtDDSCost"),EnterpriseObject.singleBidDDSCost));
		type(By.id(MakeFullLink("cpOneBidOption_txtDDSMonthlyCost"),EnterpriseObject.singleBidDDSMonthlyCost));

		click(By.id(MakeFullLink("cpOneBidOption_chxFDCPACost")));
		type(By.id(MakeFullLink("cpOneBidOption_txtFDCPACost"),EnterpriseObject.singleBidFDCPACost));
		type(By.id(MakeFullLink("cpOneBidOption_txtFDCPAMonthlyCost"), EnterpriseObject.singleBidFDCPAMonthlyCost));
		
		click(By.id(MakeFullLink("cpOneBidOption_chxFCRACost")));
		type(By.id(MakeFullLink("cpOneBidOption_txtFCRACost"),EnterpriseObject.singleBidFCRACost));
		type(By.id(MakeFullLink("cpOneBidOption_txtFCRAMonthlyCost"), EnterpriseObject.singleBidFCRAMonthlyCost));
	}



	private void fillTraditionalPlanFields(EnterpriseUserObject EnterpriseObject) {
		type(By.id(MakeFullLink("cpParameter_tbxDebtRestructureRate")),EnterpriseObject.debtRestructureRate);
		type(By.id(MakeFullLink("cpParameter_tbxDebtConsolidationInterestRate")),EnterpriseObject.debtConsolidationInterestRate);
		type(By.id(MakeFullLink("cpParameter_tbxServiceProviderRate")),EnterpriseObject.ServiceProviderRate);
		type(By.id(MakeFullLink("cpParameter_tbxMinimumMonthlyDebtConsolidateRate")),EnterpriseObject.MinimumMonthlyDebtConsolidateRate);
		type(By.id(MakeFullLink("cpParameter_tbxDDSCost")),EnterpriseObject.DDSCost);
		type(By.id(MakeFullLink("cpParameter_tbxAllowMinimumMonthlyPayment")),EnterpriseObject.AllowMinimumMonthlyPayment);
		type(By.id(MakeFullLink("cpParameter_tbxFDCPACost")),EnterpriseObject.FDCPACost);
		type(By.id(MakeFullLink("cpParameter_tbxFDCPRACost")),EnterpriseObject.FDCPRACost);
		type(By.id(MakeFullLink("cpParameter_tbxMonthlySoftwareLicenseCost")),EnterpriseObject.MonthlySoftwareLicenseCost);
		
		//type(By.id(MakeFullLink("cpParameter_tbxTaxCost")), EnterpriseObject.taxRate);
		//type(By.id(MakeFullLink("cpParameter_tbxBankruptcyCost")), EnterpriseObject.bankruptcyRate);
		
		if(EnterpriseObject.AllowFDCPA.contentEquals("true")){
			click(By.id(MakeFullLink("cpParameter_chbAllowFDCPA")));
		}
		
		if(EnterpriseObject.AllowDDS.contentEquals("true")){
		click(By.id(MakeFullLink("cpParameter_chbAllowDDS")));
		}
		
		if(EnterpriseObject.DDSDiscount.contentEquals("true")){
		click(By.id(MakeFullLink("cpParameter_chbAllowDDSDiscount")));
		}

		if(EnterpriseObject.AllowFCRA.contentEquals("true")){
		click(By.id(MakeFullLink("cpParameter_chbAllowFDCPRA")));
		}
	}	
	
	private void fillEnterpriseUserFields(EnterpriseUserObject EnterpriseObject) {
		if(EnterpriseObject.enterpriseName != null){

			type(By.id(MakeFullLink("tbFirstName")),"Ent_user_"+EnterpriseObject.enterpriseName);
			type(By.id(MakeFullLink("tbLastName")),"Ent_user_last_name_"+EnterpriseObject.enterpriseName);
			
		}
		type(By.id(MakeFullLink("tbEmail")),EnterpriseObject.enterpriseUserEmail);
	}

	
	

	
	/*private void MovingMouseOverAndClick (WebElement MenuText, WebElement linktext) {
	
	Actions builder = startActionsBuilder();
	builder.moveToElement(MenuText).click(linktext).build().perform();

	}*/
	
	
}
