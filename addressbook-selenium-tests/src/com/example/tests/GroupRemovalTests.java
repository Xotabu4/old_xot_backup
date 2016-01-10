package com.example.tests;

import java.util.Set;

import org.testng.annotations.Test;

import com.example.fw.GroupObject;

public class GroupRemovalTests extends TestBase {

	@Test
	
	public void testFirstGroupCanBeRemoved() throws Exception {
		
		Set<GroupObject> oldList = app.getGroupHelper().getGroups();
		
		//Action
		GroupObject someGroup = app.getGroupHelper().getSomeGroup();
		app.getGroupHelper().deleteGroup(someGroup);
		
		Set<GroupObject> newList = app.getHibernateHelper().getGroups();
		
		//Verification
		app.getVerifyHelper().verifyGroups(oldList, newList);
	}

}