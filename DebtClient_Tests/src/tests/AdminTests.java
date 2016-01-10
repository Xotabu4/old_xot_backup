package tests;

import org.testng.annotations.Test;





public class AdminTests extends TestBase{
	
	@Test
	public void adminCanLogin(){
		
		app.getAdminActions().loginAsAdmin();
		
	}

}
