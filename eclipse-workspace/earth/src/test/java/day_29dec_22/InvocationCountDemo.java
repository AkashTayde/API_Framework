package day_29dec_22;

import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocationCountDemo {
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test101");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After test101");
	}
	@Test(invocationCount=10)
	public void test101()
	{
		Random random=new Random();
		int x=0;
		x=random.nextInt(10);
	     System.out.println("Akash_"  +x);
	}

}
