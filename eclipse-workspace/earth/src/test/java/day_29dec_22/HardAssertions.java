package day_29dec_22;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions 
{
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");	
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}

	@Test 
	public void test101()
	{
		
		
		int a=100,b=100;
		Assert.assertTrue(a==b, "Both values are not same " +a +"&" +b);
        System.out.println("assertTrue is pass");
        
		int x=100,y=100;
		Assert.assertFalse(x==y, "Both value are same "  +" x is "+x  +" y is "+y);
		System.out.println("assertFalse is pass");
		
		int act=200,exp=100;
		Assert.assertEquals(act, exp,"boths values are not same ");
		System.out.println("assertEquals  is pass");
		
		int act1 = 100, exp1= 200;
		Assert.assertNotEquals(act1, exp1, "both values are same !!!");
		System.out.println("asseetNotEquals is pass");
	}


}
