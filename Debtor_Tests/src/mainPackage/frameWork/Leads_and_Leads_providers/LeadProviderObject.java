package mainPackage.frameWork.Leads_and_Leads_providers;

public class LeadProviderObject {

	public String LeadProviderAccountName;
	public String userFirstName;
	public String userLastName;
	public String userEmail;
	public String gmailURL;
	
	public String getLeadprovideraccountname() {
		return LeadProviderAccountName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getGmailURL() {
		return gmailURL;
	}
	public LeadProviderObject setLeadProviderAccountName(String leadprovideraccountname) {
		this.LeadProviderAccountName = leadprovideraccountname;
		return this;
	}
	public LeadProviderObject setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
		return this;
	}
	public LeadProviderObject setUserLastName(String userLastName) {
		this.userLastName = userLastName;
		return this;
	}
	public LeadProviderObject setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	public LeadProviderObject setGmailURL(String gmailURL) {
		this.gmailURL = gmailURL;
		return this;
	}

}
