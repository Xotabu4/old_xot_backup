package mainPackage.frameWork;

import org.openqa.selenium.By;
//import org.openqa.selenium.internal.seleniumemulation.WaitForPopup;



public class NavigationHelper extends HelperWithWebDriverBase {
	
	public NavigationHelper (ApplicationManager manager) {
		super(manager);
	}

	protected void openDebtorSoft() {
		openURL(manager.getProperty("DebtorSoftURL"));
	}
	
	protected void openDebtorLeads() {
		openURL(manager.getProperty("DebtorLeadsURL"));
	}
	
	
	
	public void openAddEnterprisePage() {
		
		
		openURL(manager.getProperty("DebtorSoftURL")+"Admin/Administrator/AddReseller.aspx");
	}
		
		
	
	public void logInAsEnterprise() {
	openDebtorSoft();
	type(By.name("txtUsername"),("awesome@mailinator.com"));
	type(By.name("txtPassword"),("v6qMjmAQ"));
	click(By.id("ImageButton1"));
	/*click(By.linkText("Debtor Counselor"));
	dropdownSelectByValue("MainBodyPlaceHolder_ContentPlaceHolder1_ddlWizard","0");
	click(By.cssSelector("option[value=\"0\"]"));
	click(By.id("MainBodyPlaceHolder_ContentPlaceHolder1_lbtnGoDCNetLive"));
*/
	}
	
	public void logInAsAdmin() {
		openDebtorSoft();
		type(By.name("txtUsername"),(manager.getProperty("adminLogin")));
		type(By.name("txtPassword"),(manager.getProperty("adminPassword")));
		click(By.id("ImageButton1"));
	}

	public void openBankrupcyCounselor() {
		openURL("http://qa.debtorcounselor.com/Bankruptcy/Enroll?ownerId=194f3bd6-9334-4a93-94ca-7d172443a39a&type=Live");
		
	}

	public void openAddAffiliatePage() {
		openURL(manager.getProperty("DebtorSoftURL") + "Admin/Reseller/AddAffiliate.aspx");
		
	}
	
	public void openAddLeadProviderPage() {
		openURL(manager.getProperty("DebtorSoftURL") + "Admin/LeadProviders/AddLeadProvider.aspx");
		
	}

	public void openAddSalesPage() {
		openURL(manager.getProperty("DebtorSoftURL")+"Admin/AddUsers.aspx");
	}

	public void loginAsLeadProvider() {
		openURL(manager.getProperty("DebtorLeadsURL"));

		type(By.name("Email"),(manager.getProperty("LeadProviderEmail")));
		type(By.name("Password"),(manager.getProperty("LeadProviderPassword")));
		
		click(By.cssSelector(".login-form-button"));
		
	}


	
}
