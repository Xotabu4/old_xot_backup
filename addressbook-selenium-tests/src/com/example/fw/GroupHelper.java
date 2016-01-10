package com.example.fw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GroupHelper extends HelperWithWebDriverBase {

	private Set<GroupObject> groupModel;
	private int lastGroupId;
	
	
	public GroupHelper (ApplicationManager manager) {
		super(manager);
		lastGroupId = Integer.parseInt (
				manager.getHibernateHelper().getLastGroupId());
		
	}

	public Set<GroupObject> getGroups() {
		
		if (groupModel == null) {
			groupModel = manager.getHibernateHelper().getGroups();
		}
		return groupModel;
	} 
	
	public Set<GroupObject> getUiGroups() {
		
		HashSet<GroupObject> set = new HashSet<GroupObject>();
		
		manager.getNavigationHelper().goToGroupList();
		WebElement form = findElements(By.tagName("form")).get(1);
		List<WebElement> checkboxes = form.findElements(By.name("selected[]"));
		
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			
			Pattern p = Pattern.compile(".*\\((.*)\\)");
			Matcher m = p.matcher(title);
			if (m.matches()) {
				title = m.group(1);
			}
			
			GroupObject group = new GroupObject()
			.setGroupName(title)
			.setId(checkbox.getAttribute("value"));
			set.add(group);
		    }
			return new HashSet<GroupObject>(set);
		}
	

	public void createGroup(GroupObject groupObject) {
				
		manager.getNavigationHelper().goToGroupList();
		initGroupCreation();
		fillGroupFields(groupObject);
		submitCreation();
		returnToGroupListPage();
		
		if (groupObject.groupName != "!@#$%^&*()_+-='"){
			groupObject.setId("" + lastGroupId);
			groupModel.add(groupObject);
			lastGroupId = Integer.parseInt ( manager.getHibernateHelper().getLastGroupId());
			
		}	
	}

	public void deleteGroup(GroupObject groupObject) {

		manager.getNavigationHelper().goToGroupList();
		checkGroup(groupObject);
		click(By.name("delete"));
		returnToGroupListPage();
		groupModel.remove(groupObject);
	}

	public void modifyGroup(GroupObject oldGroupObject, GroupObject newGroupObject) {
		manager.getNavigationHelper().goToGroupList();
		initGroupModification(oldGroupObject);
		fillGroupFields(newGroupObject);
		submitGroupModification();
		returnToGroupListPage();
		groupModel.remove(oldGroupObject);
		groupModel.add(newGroupObject);
	}

	private void initGroupCreation() {
		click(By.name("new"));
	}

	private void initGroupModification(GroupObject oldGroupObject) {
		checkGroup(oldGroupObject);
		click(By.name("edit"));
	}

	private void checkGroup(GroupObject groupObject) {
		click(By.xpath("//input[@value='"+ groupObject.id +"']"));
	}

	private void fillGroupFields(GroupObject GroupObject) {
		type("group_name", GroupObject.groupName);
		type("group_header", GroupObject.groupHeader);
		type("group_footer", GroupObject.groupFooter);
	}

	protected void submitCreation() {
		click(By.name("submit"));
	}

	private void submitGroupModification() {
		click(By.name("update"));
	}

	private void returnToGroupListPage() {
		click(By.linkText("groups"));
	}

	public GroupObject getSomeGroup() {
		
		return groupModel.iterator().next();
	}


}

