package com.example.tests;

import java.util.Set;

import org.testng.annotations.Test;

import com.example.fw.GroupObject;

public class GroupModificationTests extends TestBase {
    @Test
	
	public void testFirstGroupCanBeModified() throws Exception {
    	
		Set<GroupObject> oldList = app.getGroupHelper().getGroups();
		
		GroupObject oldGroup = app.getGroupHelper().getSomeGroup();
		
		GroupObject newGroup = new GroupObject()
			.setGroupName("ModifiedGroupName")
			.setGroupHeader("ModifiedGroupHeader")
			.setGroupFooter("ModifiedGroupFooter");
		//Action
		app.getGroupHelper().modifyGroup(oldGroup, newGroup);
		//Verification
		Set<GroupObject> newList = app.getHibernateHelper().getGroups();
		app.getVerifyHelper().verifyGroups(oldList, newList);
	}

}