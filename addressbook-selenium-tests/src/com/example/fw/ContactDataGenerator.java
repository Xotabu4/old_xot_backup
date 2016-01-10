package com.example.fw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;


public class ContactDataGenerator {

	static Random rnd = new Random();
	
	@DataProvider (name = "randomContacts")
	public static Iterator<Object[]> generateRandomContact() {
		List<ContactObject> contacts = new ContactDataGenerator().generateRandomContactList(5);
		
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactObject contact : contacts) {

			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@DataProvider (name = "contactsFromFile")
	public static Iterator<Object[]> loadContactsFromFile() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		BufferedReader reader = new BufferedReader (new FileReader("contacts.dat"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split("\t");
			
			ContactObject contact = new ContactObject()
			
			.setContactFirstName(parts[0])
			.setContactLastName(parts[1])
			.setContactAddressText(parts[2])
			.setContactHomePhone(parts[3])
			.setContactMobilePhone(parts[4])
			.setContactWork(parts[5])
			.setContactEmail(parts[6])
			.setContactEmail2(parts[7])
			.setContactByEar(parts[8])
			.setContactAddress2(parts[9])
			.setContactPhone2(parts[10])
			.setBdaySelect(Integer.parseInt (parts[11]))
			.setBmountSelect(Integer.parseInt (parts[12]))
			.setGroupSelect(Integer.parseInt (parts[13]));	
			
			list.add(new Object[]{contact});
			line = reader.readLine();
		}
		return list.iterator();
	}
	
	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("Specify two parameters: file and count");
			return;
		}
		String file = args[0];
		int count = Integer.parseInt(args[1]);
		try {
			new ContactDataGenerator().generateDataToFile(file, count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateDataToFile(String fileName, int count) throws IOException {
		List<ContactObject> contacts = generateRandomContactList(count);
		File file = new File(fileName);
		if(file.exists()){
			System.out.println("File exists, stop generator");
			return;
		}
		FileWriter writer = new FileWriter(file);
		for (ContactObject contact : contacts) {
			writer.write(contact.contactFirstName + "\t"
					+ contact.contactLastName +"\t"
					+ contact.contactAddressText +"\t"
					+ contact.contactHomePhone +"\t"
					+ contact.contactMobilePhone +"\t"
					+ contact.contactWork +"\t"
					+ contact.contactEmail +"\t"
					+ contact.contactEmail2 +"\t"
					+ contact.contactByEar +"\t"
					+ contact.contactAddress2 +"\t"
					+ contact.contactPhone2 +"\t"
					+ contact.bdaySelect +"\t"
					+ contact.bmountSelect +"\t"
					+ contact.groupSelect +"\t"
					+ "\n");
		}
		writer.close();
	}

	private List<ContactObject> generateRandomContactList(int count) {
		List<ContactObject> list = new ArrayList<ContactObject>();
		for (int i = 0; i < count ; i++) {
			ContactObject contact = new ContactObject()
			.setContactFirstName("ContactFirstNameText"+rnd.nextInt())
			.setContactLastName("ContactLastNameText"+rnd.nextInt())
			.setContactAddressText("ContactAddressText"+rnd.nextInt())
			.setContactHomePhone("1234567890"+rnd.nextInt())
			.setContactMobilePhone("1234567890"+rnd.nextInt())
			.setContactWork("ContactWork"+rnd.nextInt())
			.setContactEmail("Contact@email.com"+rnd.nextInt())
			.setContactEmail2("Contact2@email.com"+rnd.nextInt())
			.setContactByEar("1991"+rnd.nextInt())
			.setContactAddress2("ContactAddress"+rnd.nextInt())
			.setContactPhone2("1234567890"+rnd.nextInt())
			.setBdaySelect(rnd.nextInt(29)+1)
			.setBmountSelect(rnd.nextInt(10)+1)
			.setGroupSelect(3);	
		    list.add(contact);
		}
		return list;
	}

}
