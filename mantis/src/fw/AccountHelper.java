package fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends HelperWithWebDriverBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup (User user) {
		
		openURL("/");
		click(By.xpath("html/body/div[4]/span[1]/a"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		pause(3000);
		
		String msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmaitonLink = getConfirmationLink(msg);
		
		openAbsoluteURL(confirmaitonLink);
		
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		
		click(By.cssSelector("input.button"));
	}

	public void login(User user) {
		openURL("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	}
	

	public String LoggedUser(User user) {
		
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		
		return element.getText();
	}
	
	public String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}


}
