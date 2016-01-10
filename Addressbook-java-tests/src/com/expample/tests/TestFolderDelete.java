package com.expample.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.example.fw.Folders;

public class TestFolderDelete extends TestBase  {
	
	private Logger log = Logger.getLogger("FolderRemovalTests");
	
	@Test
	
	public void testFolderDelete() {
		Folders oldFolders = app.getFolderHelper().getFolders();
		log.info("Old Folders:" + oldFolders);
		app.getFolderHelper().deleteFolder();
		Folders newFolders = app.getFolderHelper().getFolders();
		log.info("New Folders:" + newFolders);
		assertThat(newFolders, not(oldFolders));
	
	}

}