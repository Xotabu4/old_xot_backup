package frameWork;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.opera.core.systems.OperaDriver;

public class WebDriverHelper {
	
	private static WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public WebDriverHelper(ApplicationManager manager) {
		String browser = manager.getProperty("browser", "Firefox");
		
		if ("Firefox".equals(browser)) {
			driver = new FirefoxDriver();
		}
		
		else if ("Chrome".equals(browser)) {
			driver = new ChromeDriver();
		}
		
		else if ("Opera".equals(browser)) {
			driver = new OperaDriver();
		}
		
		else if ("InternetExplorer".equals(browser)) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(manager.getProperty("implicityWait", "30")), TimeUnit.SECONDS);
		
//		driver.get(manager.getProperty("baseURL"));
	}
	
	public void stop() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
				}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
