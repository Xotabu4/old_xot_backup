package com.example.fw;

public class ContactObject{
	public String contactFirstName;
	public String contactLastName;
	public String contactAddressText;
	public String contactHomePhone;
	public String contactMobilePhone;
	public String contactWork;
	public String contactEmail;
	public String contactEmail2;
	public String contactByEar;
	public String contactAddress2;
	public String contactPhone2;
	//I convert items that select in dropdown to integer.
	public int bdaySelect;
	public int bmountSelect;
	public int groupSelect;
	public String id;
	
		
	public String getContactFirstName() {
		return contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public String getContactAddressText() {
		return contactAddressText;
	}

	public String getContactHomePhone() {
		return contactHomePhone;
	}

	public String getContactMobilePhone() {
		return contactMobilePhone;
	}

	public String getContactWork() {
		return contactWork;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getContactEmail2() {
		return contactEmail2;
	}

	public String getContactByEar() {
		return contactByEar;
	}

	public String getContactAddress2() {
		return contactAddress2;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public int getBdaySelect() {
		return bdaySelect;
	}

	public int getBmountSelect() {
		return bmountSelect;
	}

	public int getGroupSelect() {
		return groupSelect;
	}

	public String getId() {
		return id;
	}

		public ContactObject setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
		return this;
	}
			
		public ContactObject setContactLastName(String contactLastName) {
			this.contactLastName = contactLastName;
			return this;
		}
		
		public ContactObject setContactFirstNameWithLastName(String contactFirstName) {
			this.contactFirstName = contactFirstName + " " + contactLastName;
			return this;
		}
			
		public ContactObject setContactAddressText(String contactAddressText) {
			this.contactAddressText = contactAddressText;
			return this;
		}
			
		public ContactObject setContactHomePhone(String contactHomePhone) {
			this.contactHomePhone = contactHomePhone;
			return this;
		}
			
		public ContactObject setContactMobilePhone(String contactMobilePhone) {
			this.contactMobilePhone = contactMobilePhone;
			return this;
		}
		
		public ContactObject setContactWork(String contactWork) {
			this.contactWork = contactWork;
			return this;
		}
		
		public ContactObject setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
			return this;
		}
		
		public ContactObject setContactEmail2(String contactEmail2) {
			this.contactEmail2 = contactEmail2;
			return this;
		}
		
		public ContactObject setContactByEar(String contactByEar) {
			this.contactByEar = contactByEar;
			return this;
		}
		
		public ContactObject setContactAddress2(String contactAddress2) {
			this.contactAddress2 = contactAddress2;
			return this;
		}
		
		public ContactObject setContactPhone2(String contactPhone2) {
			this.contactPhone2 = contactPhone2;
			return this;
		}
		//I convert items that select in dropdown to integer.
		public ContactObject setBdaySelect(int bdaySelect) {
			this.bdaySelect = bdaySelect;
			return this;
		}
		
		public ContactObject setBmountSelect(int bmountSelect) {
			this.bmountSelect = bmountSelect;
			return this;
		}
		
		public ContactObject setGroupSelect(int groupSelect) {
			this.groupSelect = groupSelect;
			return this;
		}
		
		public ContactObject setId(String id) {
			this.id = id;
			return this;
		}

		@Override
		public String toString() {
			return "Contact [" + id 
			        + ", "
					+ contactFirstName
					+ ", "
					+ contactLastName
					+ ", "
					+ contactHomePhone
					+ ", "
					+ contactEmail + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((contactEmail == null) ? 0 : contactEmail.hashCode());
			result = prime
					* result
					+ ((contactFirstName == null) ? 0 : contactFirstName
							.hashCode());
			result = prime
					* result
					+ ((contactHomePhone == null) ? 0 : contactHomePhone
							.hashCode());
			result = prime
					* result
					+ ((contactLastName == null) ? 0 : contactLastName
							.hashCode());
			/*result = prime * result + ((id == null) ? 0 : id.hashCode());*/
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ContactObject other = (ContactObject) obj;
			if (contactEmail == null) {
				if (other.contactEmail != null) {
					return false;
				}
			} else if (!contactEmail.equals(other.contactEmail)) {
				return false;
			}
			if (contactFirstName == null) {
				if (other.contactFirstName != null) {
					return false;
				}
			} else if (!contactFirstName.equals(other.contactFirstName)) {
				return false;
			}
			if (contactHomePhone == null) {
				if (other.contactHomePhone != null) {
					return false;
				}
			} else if (!contactHomePhone.equals(other.contactHomePhone)) {
				return false;
			}
			if (contactLastName == null) {
				if (other.contactLastName != null) {
					return false;
				}
			} else if (!contactLastName.equals(other.contactLastName)) {
				return false;
			}
			if (id != null && other.id != null) {
				   return id.equals(other.id);
			  }
            return true;
	}	
		
}		
		
		/*@Override
		 public String toString() {
		  return "Contact [" + id + ":" + contactFirstName
		    + "," + contactLastName + "]";
		 }
		 @Override
		 public int hashCode() {
		  final int prime = 31;
		  int result = 1;
		  result = prime * result
		    + ((contactFirstName == null) ? 0 : contactFirstName.hashCode());
		  result = prime * result
		    + ((contactLastName == null) ? 0 : contactLastName.hashCode());
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
		  ContactObject other = (ContactObject) obj;
		  if (contactLastName == null) {
		   if (other.contactLastName != null)
		    return false;
		  } else if (!contactLastName.equals(other.contactLastName))
		   return false;
		  if (contactFirstName == null) {
		   if (other.contactFirstName != null)
		    return false;
		  } else if (!contactFirstName.equals(other.contactFirstName))
		   return false; 
		  if (id != null && other.id != null) {
			   return id.equals(other.id);
		  }
		  return true;
		 }*/
			
		
