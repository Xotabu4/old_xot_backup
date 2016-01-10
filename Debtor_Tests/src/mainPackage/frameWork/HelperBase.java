package mainPackage.frameWork;

import java.util.Random;

public class HelperBase {
	
	protected final ApplicationManager manager;

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
	}
	
	
static Random rnd = new Random();
	
	public String generateRandomTrueOrFalse() {
		int rand = rnd.nextInt();
		if(rand % 2 == 0)
			return "true";
		
		return "false";
	}	
	
	public String generateRandomString(int len) {
		 
		String AZaz = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AZaz.charAt( rnd.nextInt(AZaz.length()) ) );

	return sb.toString();
}
	
	public String generateRandomNumericString(int len) {
		 
		String numbers = "12345678901234567890";
		Random rnd = new Random();
		
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( numbers.charAt( rnd.nextInt(numbers.length()) ) );

	return sb.toString();
}

	
	public int generateRandomNumberInRange(int minimum, int maximum) {

		int range = 0;
			
	range = maximum - minimum + 1;
	int randomNum =  rnd.nextInt(range) + minimum;
	
	return randomNum;
}

}
