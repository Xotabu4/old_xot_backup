package frameWork;


public class AdminActions extends HelperBase{

	public AdminActions(ApplicationManager manager) {
		super(manager);
	}

	public void loginAsAdmin() {
		manager.pageObj().loginPage().open();
		manager.pageObj().loginPage().login("test", "test");
		
	}

}
