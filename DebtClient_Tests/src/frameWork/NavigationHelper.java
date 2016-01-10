package frameWork;

public class NavigationHelper extends HelperBase{
	
	public NavigationHelper (ApplicationManager manager) {
		super(manager);
	}

	public void loginAsAdmin() {
		
		manager.pageObj().loginPage().open();
		
	}
	
}
