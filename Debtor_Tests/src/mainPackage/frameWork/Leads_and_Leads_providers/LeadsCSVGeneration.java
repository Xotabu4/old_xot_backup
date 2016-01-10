package mainPackage.frameWork.Leads_and_Leads_providers;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperBase;

import org.testng.annotations.DataProvider;



public class LeadsCSVGeneration extends HelperBase{

private static String filename;


public LeadsCSVGeneration(ApplicationManager manager)
{
	super(manager);
}
	@DataProvider (name = "CorrectleadsFromFile")
	public static Iterator<Object[]> loadLeadsFromFile() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		BufferedReader reader = new BufferedReader (new FileReader("valid_leads_20.dat"));
		String line = reader.readLine();
			while (line != null) {
				String[] parts = line.split("\t");
		
				LeadsObject lead = new LeadsObject()
				
					.setLeadFirstName(parts[0])
					.setLeadLastName(parts[1])
					.setLeadEmail(parts[2])
					.setLeadPhoneNumber(parts[3])
					.setLeadDebtAmount(parts[4])
					.setLeadAge(parts[5]);

		list.add(new Object[]{lead});
		line = reader.readLine();
	}
	return list.iterator();
}
	
	/*@DataProvider (name = "BlankleadsFromFile")
	public static Iterator<Object[]> loadBlankLeadsFromFile() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		BufferedReader reader = new BufferedReader (new FileReader("incorrect.dat"));
		String line = reader.readLine();
			while (line != null) {
				String[] parts = line.split("\t");
		
				LeadsObject lead = new LeadsObject()
				
		
					.setLeadFirstName(parts[0])
					.setLeadLastName(parts[1])
					.setLeadEmail(parts[2])
					.setLeadPhoneNumber(parts[3])
					.setLeadDebtAmount(parts[4])
					.setLeadAge(parts[5]);

		list.add(new Object[]{lead});
		line = reader.readLine();
	}
	return list.iterator();
}*/
	

	public static void main(String[] args) {
		
		System.out.println(
"Enter type of file you want to generate, file name, and count. Avaiable types: LeadsCSV, ValidLeadsDat");
		//type
		args[0] = "ValidLeadsDat";
		//Name
		args[1] = "valid_leads_20.dat";
		//Count
		args[2] = "20";
		
		if (args.length < 3) {
			System.out.println("Specify parameters");
			return;
		}
		String type = args[0];
		filename = args[1];
		int count = Integer.parseInt(args[2]);
		
		
		if (type == "LeadsCSV") {
		
			try {
				
				new LeadsCSVGeneration(ApplicationManager.getInstance()).generateLeadsToCSVFile(filename, count);
				System.out.println("Success");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if (type == "ValidLeadsDat") {
			
			try {
				new LeadsCSVGeneration(ApplicationManager.getInstance()).generateLeadsToDatFile(filename, count);
				System.out.println("Success");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		/*
		try {
			new LeadsCSVGeneration(ApplicationManager.getInstance()).generateLeadsToDatFile("incorrect.dat", 20);
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
	private void generateLeadsToDatFile(String fileName, int count) throws IOException {
		List<LeadsObject> leads = generateRandomLeadsList(count);
		writeValues(fileName, leads);
	}

	private void generateLeadsToCSVFile(String fileName, int count) throws IOException {
		List<LeadsObject> leads = generateRandomLeadsList(count);
		File file = new File(fileName);
		if(file.exists()){
			System.out.println("File exists, stop generator");
			return;
		}
		FileWriter writer = new FileWriter(file);
		writer.write("FirstName,LastName,Email,PhoneNumber,DebtAmount,Age"+"\r\n");
		
		for (LeadsObject lead : leads) {
			String sep = "\",\"";
			writer.write(
			"\""+lead.leadFirstName+sep
			+lead.leadLastName+sep
			+lead.leadEmail+sep
			+lead.leadPhoneNumber+sep
			+lead.leadDebtAmount+sep
			+lead.leadAge +"\""
					+ "\r\n");
		}
		writer.close();
	}

	private List<LeadsObject> generateRandomLeadsList(int count) {
		List<LeadsObject> list = new ArrayList<LeadsObject>();
		for (int i = 0; i < count ; i++) {
			LeadsObject lead = new LeadsObject()
			.setLeadFirstName(String.format("www.LeadFN%s.com", generateRandomString(7)))
			.setLeadLastName(String.format("LeadLN%s", generateRandomString(7)))
			.setLeadEmail(String.format("lead_%s@mailinator.com", generateRandomString(7)))
			.setLeadPhoneNumber(generateRandomNumericString(10))
			.setLeadDebtAmount(generateRandomNumericString(2)+","+generateRandomNumericString(3)+".50")
			.setLeadAge(generateRandomNumberInRange(1, 20));
			
		    list.add(lead);
		}
		return list;
	}

	private void writeValues(String fileName, List<LeadsObject> leads)
			throws IOException {
		File file = new File(fileName);
		if(file.exists()){
			file.delete();
		}
		FileWriter writer = new FileWriter(file);
		
		for (LeadsObject lead : leads) {
			String sep = "\t";
			writer.write(
			lead.leadFirstName+sep
			+lead.leadLastName+sep
			+lead.leadEmail+sep
			+lead.leadPhoneNumber+sep
			+lead.leadDebtAmount+sep
			+lead.leadAge
					+ "\r\n");
		}
		writer.close();
	}
	
	
}
