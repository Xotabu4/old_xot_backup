package objects;

public class Train {
	
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public void speedUp (int i) {
		this.speed = i;
		
	}
	
	public void stop () {
		
		this.speed = 0;
		
		
	}
	

	public static void main (String args[]) {
		
		Train train = new Train();
		train.speedUp(200);
		
		System.out.println(train.getSpeed());
		
		
	}
	
	

}
