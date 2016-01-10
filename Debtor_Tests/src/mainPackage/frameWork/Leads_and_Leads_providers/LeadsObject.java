package mainPackage.frameWork.Leads_and_Leads_providers;

public class LeadsObject {
	
		public String leadFirstName;
		public String leadLastName;
		public String leadEmail;
		public String leadPhoneNumber;
		public String leadDebtAmount;
		public int leadAge;
		
		public String getLeadFirstName() {
			return leadFirstName;
		}
		public String getLeadLastName() {
			return leadLastName;
		}
		public String getLeadEmail() {
			return leadEmail;
		}
		public String getLeadPhoneNumber() {
			return leadPhoneNumber;
		}
		public String getLeadDebtAmount() {
			return leadDebtAmount;
		}
		public int getLeadAge() {
			return leadAge;
		}
		
		public LeadsObject setLeadFirstName(String leadFirstName) {
			this.leadFirstName = leadFirstName;
			return this;
		}
		public LeadsObject setLeadLastName(String leadLastName) {
			this.leadLastName = leadLastName;
			return this;
		}
		public LeadsObject setLeadEmail(String leadEmail) {
			this.leadEmail = leadEmail;
			return this;
		}
		public LeadsObject setLeadPhoneNumber(String leadPhoneNumber) {
			this.leadPhoneNumber = leadPhoneNumber;
			return this;
		}
		public LeadsObject setLeadDebtAmount(String leadDebtAmount) {
			this.leadDebtAmount = leadDebtAmount;
			return this;
		}
		
		public LeadsObject setLeadAge (String leadAge){
			int intLeadAge = Integer.parseInt(leadAge);
			this.leadAge = intLeadAge;
			return this;
		}
		
		public LeadsObject setLeadAge(int leadAge) {
			
			this.leadAge = leadAge;
			return this;
		}
		

}
