import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class gui_test {
	
	public static void main (String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				

				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				
			}
		});
	}

}

class ButtonFrame extends JFrame
{
	private static TextField text = new TextField();

	public ButtonFrame() {
		
		setLayout(new GridLayout(4,4));
		setTitle("Rock, Paper, and scissors");
		setSize(600, 200);
		
		JPanel buttonPanel = new JPanel();
		
		JButton rock = new JButton("Rock");
		JButton paper = new JButton("Paper");
		JButton scissors = new JButton("Scissors");
		
		buttonPanel.add(rock);
		buttonPanel.add(paper);
		buttonPanel.add(scissors);

		add(buttonPanel);
		

		text.setText("Hello! This is funny game for all family! Please select the item to begin!");
		text.setVisible(true); 
		text.setEditable(false);

		add(text);
		
		RockAction rockAction = new RockAction();
		PaperAction paperAction = new PaperAction();
		ScissorsAction scissorsAction = new ScissorsAction();
		
		rock.addActionListener(rockAction);
		paper.addActionListener(paperAction);
		scissors.addActionListener(scissorsAction);
		
		
	}
	
	public static void setTextFieldText(String body){
		text.setText(body);
	}
	
	
	
}



class RockAction implements ActionListener {
	
	private Object userObject;


	public void actionPerformed(ActionEvent event) {
//		System.out.println("RockCLICLED!");
		setUserObject(new Rock());
		test.compareUserVictory(userObject, test.computerSelection());
		
	}


	public void setUserObject(Object userObject) {
		this.userObject = userObject;
		
	}
	
}

class PaperAction implements ActionListener {
	
	private Object userObject;


	public void actionPerformed(ActionEvent event) {
//		System.out.println("PaperCLICLED!");
		setUserObject(new Paper());
		test.compareUserVictory(userObject, test.computerSelection());
		
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}
	
}

class ScissorsAction implements ActionListener {
	
	private Object userObject;


	public void actionPerformed(ActionEvent event) {
//		System.out.println("ScissorsCLICLED!");
		setUserObject(new Scissors());
		test.compareUserVictory(userObject, test.computerSelection());
		
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}
	
}
