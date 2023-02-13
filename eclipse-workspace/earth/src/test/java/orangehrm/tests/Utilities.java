package orangehrm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends BaseTest{

	public static void enterTheText(By by,String text,String message)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds( Integer.parseInt(prop.getProperty("timeout"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
			System.out.println(message);
		}catch(Exception e)
		{
			System.out.println("Failed to enter the text"  +e.getMessage());
		}

	}

	public static void clickOnElement(By by,String message)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
			System.out.println(message);
		}catch(Exception e)
		{
			System.out.println("Failed to click on element "  +e.getMessage());
		}	
	}

}
