package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase{

	private Process process;

	protected ProcessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	
	public void startApplicationUnderTest() throws IOException{
		String command = manager.getProperty("app.path");
		process = Runtime.getRuntime().exec(command);
		
		//Without thread.sleep my tests is runs incorrect. I wait until application is loads.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stopApplicationUnderTest(){
		process.destroy();
	}
	
}
