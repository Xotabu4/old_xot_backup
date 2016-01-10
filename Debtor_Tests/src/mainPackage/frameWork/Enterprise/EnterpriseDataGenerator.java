package mainPackage.frameWork.Enterprise;

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


public class EnterpriseDataGenerator extends HelperBase {
	
	public EnterpriseDataGenerator(ApplicationManager manager) {
		super(manager);
	}

	@DataProvider (name = "randomEnterprise")
	public static Iterator<Object[]> generateRandomEnterprise() {
		List<EnterpriseUserObject> enterprises = new EnterpriseDataGenerator(ApplicationManager.getInstance()).generateRandomEnterpriseList(5);
		
		List<Object[]> list = new ArrayList<Object[]>();
		for (EnterpriseUserObject enterprise : enterprises) {

			list.add(new Object[]{enterprise});
		}
		return list.iterator();
	}
	
	@DataProvider (name = "enterpiseFromFile")
	public static Iterator<Object[]> loadEnterprisesFromFile() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		BufferedReader reader = new BufferedReader (new FileReader("EnterpriseUsers.dat"));
		String line = reader.readLine();
		while (line != null) {
			String[] parts = line.split("\t");
			
			EnterpriseUserObject enterprise = new EnterpriseUserObject()
			
			.setEnterpriseName(parts[0])
			.setEnterpriseUserEmail(parts[1])
			.setGmailURL(parts[2])
			
			.setExtension(parts[3])
			.setSupportPhoneNumber(parts[4])
			.setClickOnAllowFDCPA(parts[5])
			.setClickOnAllowDDS(parts[6])
			.setClickOnAllowDDSDiscount(parts[7])
			.setClickOnAllowFCRA(parts[8])
			.setDebtRestructureRate(parts[9])
			.setDebtConsolidationInterestRate(parts[10])
			.setServiceProviderRate(parts[11])
			.setMinimumMonthlyDebtConsolidateRate(parts[12])
			.setDDSCost(parts[13])
			.setAllowMinimumMonthlyPayment(parts[14])
			.setFDCPACost(parts[15])
			.setFDCPRACost(parts[16])
			.setMonthlySoftwareLicenseCost(parts[17])
			
			.setTaxRate(parts[18])
			.setBankruptcyRate(parts[19]);

			
			list.add(new Object[]{enterprise});
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
			new EnterpriseDataGenerator(ApplicationManager.getInstance()).generateEnterpisesToFile(file, count);
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void generateEnterpisesToFile(String fileName, int count) throws IOException {
		List<EnterpriseUserObject> enterprises = generateRandomEnterpriseList(count);
		File file = new File(fileName);
		if(file.exists()){
			System.out.println("File exists, stop generator");
			return;
		}
		FileWriter writer = new FileWriter(file);
		for (EnterpriseUserObject enterprise : enterprises) {
			writer.write(enterprise.enterpriseName+"\t"
			+enterprise.enterpriseUserEmail+"\t"
			
			+enterprise.gmailURL+"\t"
			
			+enterprise.Extension+"\t"
			+enterprise.SupportPhoneNumber+"\t"
			
			+enterprise.AllowFDCPA+"\t"  
			+enterprise.AllowDDS+"\t"
			+enterprise.DDSDiscount+"\t"
			+enterprise.AllowFCRA+"\t"
			
			+enterprise.debtRestructureRate+"\t"
			+enterprise.debtConsolidationInterestRate+"\t"
			+enterprise.ServiceProviderRate+"\t"
			+enterprise.MinimumMonthlyDebtConsolidateRate+"\t"
			+enterprise.DDSCost+"\t"
			+enterprise.AllowMinimumMonthlyPayment+"\t"
			+enterprise.FDCPACost+"\t"
			+enterprise.FDCPRACost+"\t"
			+enterprise.MonthlySoftwareLicenseCost +"\t"
			
			+enterprise.taxRate +"\t"
			+enterprise.bankruptcyRate +"\t"
					+ "\n");
		}
		writer.close();
	}

	private List<EnterpriseUserObject> generateRandomEnterpriseList(int count) {
		List<EnterpriseUserObject> list = new ArrayList<EnterpriseUserObject>();
		for (int i = 0; i < count ; i++) {

			EnterpriseUserObject enterprise = new EnterpriseUserObject()
			.setEnterpriseName(String.format("EnterpriseName_%s", generateRandomString(7)))
			.setEnterpriseUserEmail(String.format("EnterpriseName_%s@mailinator.com", generateRandomString(5)))
			.setGmailURL(String.format("gmail%s.com", generateRandomString(5)))
			.setSupportPhoneNumber(generateRandomNumericString(10))
			.setExtension(generateRandomNumericString(3))
			.setClickOnAllowFDCPA(""+generateRandomTrueOrFalse())
			.setClickOnAllowDDS(""+generateRandomTrueOrFalse())
			.setClickOnAllowDDSDiscount(""+generateRandomTrueOrFalse())
			.setClickOnAllowFCRA(""+generateRandomTrueOrFalse())
			.setDebtRestructureRate(Integer.toString(generateRandomNumberInRange(1,40)))	
			.setDebtConsolidationInterestRate(Integer.toString(generateRandomNumberInRange(1,40)))
			.setServiceProviderRate(Integer.toString(generateRandomNumberInRange(15,18)))
			.setMinimumMonthlyDebtConsolidateRate(Integer.toString(generateRandomNumberInRange(3,9)))
			.setDDSCost(Integer.toString(generateRandomNumberInRange(250,500)))
			.setAllowMinimumMonthlyPayment(Integer.toString(generateRandomNumberInRange(250,300)))
			.setFDCPACost(Integer.toString(generateRandomNumberInRange(250,300)))
			.setFDCPRACost(Integer.toString(generateRandomNumberInRange(250,300)))
			.setMonthlySoftwareLicenseCost(Integer.toString(generateRandomNumberInRange(40,70)))
			
			.setTaxRate(Integer.toString(generateRandomNumberInRange(1,90)))
			.setBankruptcyRate(Integer.toString(generateRandomNumberInRange(1,90)));
			
			
			
		    list.add(enterprise);
		    
		    
		}
		return list;
	}

}
