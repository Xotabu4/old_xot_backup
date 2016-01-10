import java.util.Random;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;


public class test {
	
	//WebDriver driver = new FirefoxDriver();
	
	
	//@Test
	public static void main(String args[]) {
		
		System.out.println("--== ROCK, PAPER, CISSORS ==--");
		System.out.println("--== FUNNY GAME FOR ALL FAMILY! ==--");
		System.out.println("For For start game, select your item - 1 - rock, 2 - paper, 3 - cissors");
		
		int playerSelection = Integer.parseInt(args[0]);
		
		Object userObject = computerSelection();
		
		int computerSelection = generateRandomNumberInRange(1,3);
		
		//computerSelection = 1;
		
		Object computerObject = computerSelection();
		//Same selection = no one win
		if(playerSelection == computerSelection) {
			System.out.println("--== No one win - same selection! Please reroll! ==--");
		}
		
		//Throw error on empty objects
		if (userObject == null || computerObject == null){
			System.out.println("Error! Please restart application!");
		}
		
		//Checking user victory
		
		System.out.println("Computer was select - "+computerObject.getClass().getName()+". " + "User was select - " + userObject.getClass().getName());
		
		if (compareUserVictory2(userObject, computerObject) == true) {
			
			System.out.println("YOU win! Congratulation! Try again!");
			
		} else {

			System.out.println("Computer WIN. Try again!");
		
		}
		
	}
	

	protected final static void compareUserVictory(Object userObject,
			Object computerObject) {
		
		String victory = "Computer was select - "+computerObject.getClass().getName()+". "
				 + "User was select - " + userObject.getClass().getName() +
			 		" YOU win! Congratulation! Try again!";
		
		String fail = "Computer was select - "+computerObject.getClass().getName()+". "
				 + "User was select - " + userObject.getClass().getName() + ". " +
			 		" Computer WIN. Try again!";
		
		if(computerObject.getClass() == userObject.getClass()) {
			ButtonFrame.setTextFieldText("--== No one win - same selection! ==--");
			return;
		}
			 
		
		 if(userObject instanceof Rock && computerObject instanceof Scissors){
			 ButtonFrame.setTextFieldText(victory);
		 System.out.println(userObject.toString());
			 return;
		 }
		 if(userObject instanceof Paper && computerObject instanceof Rock) {
			 ButtonFrame.setTextFieldText(victory);
			 return;
		 }
		 
		 if(userObject instanceof Scissors && computerObject instanceof Paper) {
			 ButtonFrame.setTextFieldText(victory);
			 return;
		 }
		 else {
			 ButtonFrame.setTextFieldText(fail);
		 }
	
	}

	public static Object computerSelection() {
		int computerSelection = generateRandomNumberInRange(1,3);
		
		Object computerObject = null;
		
		if (computerSelection == 1){
			computerObject = new Rock();
		}
		
		if (computerSelection == 2){
			computerObject = new Paper();
		}
		
		if (computerSelection == 3){
			computerObject = new Scissors();
		}
		return computerObject;
	}
	
	private final static boolean compareUserVictory2(Object userObject,
			Object computerObject) {
			 
		 if(userObject.getClass().getName().contains("Rock")
				 && computerObject.getClass().getName().contains("Cissors"))
			 return true;
		 
		 if(userObject.getClass().getName().contains("Paper") && computerObject.getClass().getName().contains("Rock")) {
			 return true;
		 }
		 
		 if(userObject.getClass().getName().contains("Cissors") && computerObject.getClass().getName().contains("Paper")) {
			 return true;
		 }
		 else {
			 return false;
		 }
	
	}
	
	public static int generateRandomNumberInRange(int minimum, int maximum) {

		int range = 0;
			
	range = maximum - minimum + 1;
	Random rnd = new Random();
	int randomNum =  rnd.nextInt(range) + minimum;
	
	return randomNum;
	}
}