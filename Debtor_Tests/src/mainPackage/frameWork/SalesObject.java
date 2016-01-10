package mainPackage.frameWork;

public class SalesObject {
	
	public String firstName;
	public String lastName;
	public String phone;
	public String Email;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return Email;
	}
	public SalesObject setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public SalesObject setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public SalesObject setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public SalesObject setEmail(String email) {
		this.Email = email;
		return this;
	}

}
