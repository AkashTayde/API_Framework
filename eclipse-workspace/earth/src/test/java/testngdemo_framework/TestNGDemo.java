package testngdemo_framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo 
{
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Will be executed prior to every method/testcase/testscript");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Will be executed after every method/testcase/testscript");
	}	
	
	@Test(priority=1)
	public void registration()
	{
		System.out.println("FB registration");
	}
	
	@Test(priority=2)
	public void login()
	{
		System.out.println("FB login");
	}
	
	@Test(priority=3)
	public void logout()
	{
		System.out.println("FB logout");
	}
		

}
