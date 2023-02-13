package orangehrm.pages;

import org.openqa.selenium.By;


import orangehrm.tests.BaseTest;
import orangehrm.tests.Utilities;

public class Loginpage extends BaseTest
{
	By txtUsername=By.name("username");
	By txtPassword= By.name("password");
	By 	btnLogin=By.xpath("//button");
	
	By invalidCredErrorMsg = By.xpath("(//div//p)[1]");
	By requiredErrorMsg= By.xpath("//span");

	public Loginpage()
	{
		super();    // reads config.properties file
	}

	public void	enterUsername(String usename) {

		driver.findElement(txtUsername).clear();
		
		Utilities.enterTheText(txtUsername,usename,"Enter the username in txtfield");
//		driver.findElement(txtUsername).sendKeys(usename);
	}

	public void enterPassword(String password) {

		driver.findElement(txtPassword).clear();
		Utilities.enterTheText(txtPassword,password,"Enter the password in txtfield");
//		driver.findElement(txtPassword).sendKeys(password);
	}

	public void clickOnLoginBtn() {
		
		Utilities.clickOnElement(btnLogin, "click on the loginBtn");
//		driver.findElement(btnLogin).click();
	}

	public LandingPage loginToApp(String uname,String pwd) {
		
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage();    
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyInvalidLoginToApp(String uname,String pwd)
	{
		String returnMsg=null;
		
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginBtn();
		
		
		if (!uname.isEmpty() && !pwd.isEmpty())
			returnMsg = driver.findElement(invalidCredErrorMsg).getText();
		else if (uname.isEmpty() || pwd.isEmpty())
			returnMsg = driver.findElement(requiredErrorMsg).getText();
		
		return returnMsg;
		
		
	}

}
