package vtigerPractice;

import java.util.Random;

public class RandomClassPractice {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		System.out.println(random);
	}

}
