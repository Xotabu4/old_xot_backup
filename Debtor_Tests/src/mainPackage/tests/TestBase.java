package mainPackage.tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import mainPackage.frameWork.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected ApplicationManager app;
	
	protected Logger log = Logger.getLogger("TEST");
	
	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = "application.properties";
		}
		
		Properties props = new Properties();
		props.load(new FileReader(configFile));

		log.info("setUp start");
		app = ApplicationManager.getInstance();
		app.setProperties(props);
		log.info("setUp end");
	
}

	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance().stop();
		log.info("Instance stop");
	}
	
	
}
