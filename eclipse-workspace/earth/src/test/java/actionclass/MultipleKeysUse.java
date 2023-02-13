package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeysUse {

	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	    //click on Control + A (Select all) using Action Class 
		
		driver.findElement(By.name("q")).sendKeys("Don is Comming back now watch");
		//Control + A(select all)  
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		
		//Contol + C (copy)
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).
		build().perform();
		
		Thread.sleep(2000l);
		
		//Control + X
		actions.keyDown(Keys.CONTROL).sendKeys("X").keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(2000l);
		//Paste the copy value(Control+V)
		
		actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
		
		
		
		
		

		Thread.sleep(2000l);
		driver.quit();
	}

	
}
