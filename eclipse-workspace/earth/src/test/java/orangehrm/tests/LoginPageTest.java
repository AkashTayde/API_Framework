package orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import orangehrm.pages.LandingPage;
import orangehrm.pages.Loginpage;

public class LoginPageTest  extends BaseTest{

	
	Loginpage loginpage=null;
	LandingPage landingpage=null;
	
	@BeforeMethod
	public void setUp()
	{
		loginpage= new Loginpage();
		init();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void LoginTest()
	{
		String un=prop.getProperty("username");
		String pw=prop.getProperty("password");
		landingpage = loginpage.loginToApp(un,pw);   //return LandingPage
	}
	
	@Test(priority = 2)
	public void  verifyLoginPageTitle()
	{
		Assert.assertEquals(loginpage.getLoginPageTitle(), "OrangeHRM", "LogInPage Title is NOT matching !!!");
	}
	
//	@Test(dataProvider = "data",dataProviderClass = LoginPageTest.class)
	@Test( priority = 3, dataProvider = "data")
	public void verifyInvalidLoginCredentials(String uname,String pwd)
	{
          String errorMsg = loginpage.verifyInvalidLoginToApp(uname, pwd);
          
          if (!uname.isEmpty() && !pwd.isEmpty())
  			Assert.assertEquals(errorMsg, "Invalid credentials");
  		else if (uname.isEmpty() || pwd.isEmpty())
  			Assert.assertEquals(errorMsg, "Required");
          
	}


	@DataProvider(name = "data")
	public Object[][] getData()
	{
		Object [][] data=new Object [4][2];

		data[0][0]="abc";
		data[0][1]="abc";

		data[1][0]="";
		data[1][1]="abc";

		data[2][0]="abc";
		data[2][1]="";
		
		data[3][0]="";
		data[3][1]="";
		
		
		return data;
	}

}
