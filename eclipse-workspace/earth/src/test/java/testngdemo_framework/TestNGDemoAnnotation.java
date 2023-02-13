package testngdemo_framework;

//import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGDemoAnnotation {
	
	
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("End Test Suite");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Start Test Suite");
	}
	@BeforeMethod
	public void login()
	{
		System.out.println("Login is successfully");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout successfully");
	}
	
	@Test
	public void registration()
	{
		System.out.println("Registration successfully");
	}
	
	@Test 
	public void payment()
	{
		System.out.println("Payment feature implements");
	}
	
	@Test
	public void transition()
	{
		System.out.println("Transitions feature implements");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Test script Start");
	}
	
	@AfterClass()
	public void afterClass()
	{
		System.out.println("Test Script End");
	}
	

}
