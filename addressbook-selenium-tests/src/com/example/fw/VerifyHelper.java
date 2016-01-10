package com.example.fw;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.Set;


public class VerifyHelper {
	
	public VerifyHelper(ApplicationManager manager) {
			super();
		}

	public void verifyContacts(Set<ContactObject> oldList, Set<ContactObject> newList) {
		
		assertThat(oldList, equalTo(newList));
		
	}
	
	
	public void verifyGroups(Set<GroupObject> oldList, Set<GroupObject> newList) {
		assertThat(oldList, equalTo(newList));
	
	}

	
	//Seems like now we got the same assert for all contact tests. I change all verify methods to one verify method
	
/*	public void verifyContactRemoved(Set<ContactObject> oldList, Set<ContactObject> newList) {
		
		assertThat(newList, equalTo(oldList));
		
	}

	public void verifyContactModified(Set<ContactObject> oldList, Set<ContactObject> newList) {
		
	    assertThat(newList, equalTo (oldList));

	}

	public void verifyContactNotAdded(Set<ContactObject> oldList, Set<ContactObject> newList) {
		
		assertThat(newList, equalTo(oldList));

	}
*/
	public void verifyPrintPhonesTableEqualsContactList(Set<ContactObject> contacts, Set<ContactObject> printPhonesTable) {
		// TODO
		
	}

		
	}

	