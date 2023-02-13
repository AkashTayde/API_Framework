package orangehrm.pages;

import org.openqa.selenium.By;

import orangehrm.tests.BaseTest;

public class LandingPage extends BaseTest {

	By linkAdmin=By.xpath("(//ul//li//a)[1]");
	
	public LandingPage()
	{
		super();
	}
	
	public void clickOnAdminLink()
	{
		driver.findElement(linkAdmin).click();
		
	}
}
