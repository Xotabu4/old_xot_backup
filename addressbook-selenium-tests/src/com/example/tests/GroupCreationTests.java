package com.example.tests;

import java.util.Set;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.example.fw.GroupDataGenerator;
import com.example.fw.GroupObject;

public class GroupCreationTests extends TestBase {
	
	private Logger log = Logger.getLogger("GroupCreationTests");

	@Test
	(dataProvider = "groupsFromFile", dataProviderClass = GroupDataGenerator.class)
	
	public void testValidGroupCanBeCreated(GroupObject validGroup) throws Exception {
		
		log.info("testValidGroupCanBeCreated start");
		
		Set<GroupObject> oldList = app.getGroupHelper().getGroups();
		log.info("oldList = " + oldList);
		
		//Action
		app.getGroupHelper().createGroup(validGroup);
		log.info("validGroup = " + validGroup);
		
		//Verification
		Set<GroupObject> newList = app.getHibernateHelper().getGroups();
		log.info("newList = " + newList);
		
		app.getVerifyHelper().verifyGroups(oldList, newList);
		log.info("testValidGroupCanBeCreated end");
	}


	@Test
	
	public void testGroupwithEmptyDataCanBeCreated() throws Exception {
		GroupObject emptyDataGroup = new GroupObject()
		.setGroupName("")
		.setGroupHeader("")
		.setGroupFooter("");
		Set<GroupObject> oldList = app.getGroupHelper().getGroups();
		//Action
		app.getGroupHelper().createGroup(emptyDataGroup);
		//Verification
		Set<GroupObject> newList = app.getHibernateHelper().getGroups();
		app.getVerifyHelper().verifyGroups(oldList, newList);
	}


	@Test

    public void testGroupwithIncorectDataCantBeCreated() throws Exception {
	GroupObject incorrectDataGroup = new GroupObject()
	.setGroupName("!@#$%^&*()_+-='")
	.setGroupHeader("!@#$%^&*()_+-='")
	.setGroupFooter("!@#$%^&*()_+-='");
	
	    
	    Set<GroupObject> oldList = app.getGroupHelper().getGroups();
		//Action
		app.getGroupHelper().createGroup(incorrectDataGroup);
		//Verification
		Set<GroupObject> newList = app.getHibernateHelper().getGroups();
		app.getVerifyHelper().verifyGroups(oldList, newList);
		//Method for verify that group is not created. Just for experiment.
    }

	
	
}