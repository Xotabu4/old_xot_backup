package com.expample.tests;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.example.fw.Folders;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestFolderCreation extends TestBase {
	
	private Logger log = Logger.getLogger("FolderCreationTests");
	
	
	@Test
	public void testFolderCreation() {
		String folder = "newfolder";
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		log.info("Old Folders:" + oldFolders);
		
		app.getFolderHelper().createFolder(folder);
		
		Folders newFolders = app.getFolderHelper().getFolders();
		log.info("New Folders:" + newFolders);
		
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	
	}
	
	@Test
	public void testVariousFolderCreation() {
		String folder1 = "newfolder1";
		String folder2 = "newfolder2";
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		log.info("Old Folders:" + oldFolders);
		
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		
		Folders newFolders = app.getFolderHelper().getFolders();
		log.info("New Folders:" + newFolders);
		
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
		
		Folders newFolders2 = app.getFolderHelper().getFolders();
		log.info("New Folders2:" + newFolders2);
		
		assertThat(newFolders2, equalTo(newFolders.withAdded(folder2)));
	
	}

	@Test
	public void testFolderWithSameNameCreation() {
		String folder1 = "newfolder3";
		String folder2 = "newfolder3";
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		log.info("Old Folders:" + oldFolders);
		
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		
		Folders newFolders = app.getFolderHelper().getFolders();
		log.info("New Folders:" + newFolders);
		
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), containsString("Duplicated folder name"));
		
		Folders newFolders2 = app.getFolderHelper().getFolders();
		log.info("New Folders2:" + newFolders2);
		
		assertThat(newFolders2, equalTo(newFolders));
	
	}
	

}
