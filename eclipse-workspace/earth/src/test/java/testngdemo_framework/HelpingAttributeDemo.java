package testngdemo_framework;

//import org.testng.Assert;

import org.testng.annotations.Test;

public class HelpingAttributeDemo {
	
	
	@Test(dependsOnMethods = {"login"},priority=2,enabled = true,alwaysRun = true)
	public void reg() 
	{
		
		System.out.println("Registration successfull");
		
	}

	@Test( priority=1, description = "This is Login feature")
	public void login()
	{
		//Assert.fail("This is fail");
		System.out.println("Login successfull");
	}
	
	@Test(priority=3,timeOut = 3000)
	public void Logout() throws InterruptedException
	{
		System.out.println("LogOut successfull");
		Thread.sleep(4000l);
	}
	

}
