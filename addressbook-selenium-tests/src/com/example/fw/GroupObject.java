package com.example.fw;

public class GroupObject {
	public String groupName;
	public String groupHeader;
	public String groupFooter;
	public String id;
	
	public String getGroupName() {
		return groupName;
	}
	public String getGroupHeader() {
		return groupHeader;
	}
	public String getGroupFooter() {
		return groupFooter;
	}
	public String getId() {
		return id;
	}
	
	public GroupObject setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	public GroupObject setGroupHeader(String groupHeader) {
		this.groupHeader = groupHeader;
		return this;
	}
	public GroupObject setGroupFooter(String groupFooter) {
		this.groupFooter = groupFooter;
		return this;
	}
	public GroupObject setId(String id) {
		this.id = id;
		return this;
	}
	
	@Override
	public String toString() {
		return "Group [" + id + ",: " + groupName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupObject other = (GroupObject) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (id == "NEW" && other.id != null) {
//I add NEW tag, and on verify, if one object has this tag, and another object has non null tag it equals
				return id.equals(other.id);
		}
		
		return true;
		
	}
	
	
}
