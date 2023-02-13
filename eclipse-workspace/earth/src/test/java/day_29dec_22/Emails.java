package day_29dec_22;

import java.util.Random;

public class Emails {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++)
		{
		Random random=new Random();
		int x=0;
		x=random.nextInt(1000000000);
	     System.out.println("Akashtayde_"  +x+"@gmail.com");
		}
	}
}
