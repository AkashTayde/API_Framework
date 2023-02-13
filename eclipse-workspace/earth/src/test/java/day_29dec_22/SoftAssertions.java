package day_29dec_22;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions 
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
			SoftAssert sa = new SoftAssert();
			int a=100,b=100;
			sa.assertTrue(a==b, "Both values are not same " +a +"&" +b);
	        System.out.println("assertTrue is pass");
	        
			int x=100,y=100;
			sa.assertFalse(x!=y, "Both value are same "  +" x is "+x  +" y is "+y);
			System.out.println("assertFalse is pass");
			
			int act=200,exp=100;
			sa.assertEquals(act, exp,"boths values are not same ");
			System.out.println("assertEquals  is pass");
			
			int act1 = 100, exp1= 200;
			sa.assertNotEquals(act1, exp1, "both values are same !!!");
			System.out.println("asseetNotEquals is pass");
		}


}


