package tests;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fw.AccountHelper;
import fw.JamesHelper;
import fw.User;

public class SignUpTests extends TestBase{
	
	public User user = new User().setLogin("testuser1").setEmail("testuser1@localhost.localdomain")
			.setPassword("123456");
	private JamesHelper james;
	private AccountHelper accHelp;
	
	@BeforeClass
	
	public void initShortcuts () {
		james = app.getJamesHelper();
		accHelp = app.getAccountHelper();
	}
	
	public void createMailUser () {
		if (! james.doesUserExist(user.login)) {
			james.createUser(user.login, user.password);
		}
		
	}

	@AfterClass
	
	public void deleteMailUser () {
		if (james.doesUserExist(user.login)) {
			james.deleteUser(user.login);
		}
	}
	
	@Test
	public void newUserShouldSignup() {
		
		accHelp.signup(user);
		accHelp.login(user);
		assertThat(accHelp.LoggedUser(user), equalTo(user.login));
		
	}

}
