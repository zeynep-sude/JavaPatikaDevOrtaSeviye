package java102.maceraOyunu;

import java.util.Random;

public class Snake extends Obstacle {
	 
	public Snake() {

		super("Yılan", 4,generateRandomDamage() , 12, 5);
		// TODO Auto-generated constructor stub

		
	}
	
	 private static int generateRandomDamage() {
	        Random random = new Random();
	        int minDamage = 3;
	        int maxDamage = 6;
	        return random.nextInt((maxDamage - minDamage) + 1) + minDamage;
	    }
			

}
