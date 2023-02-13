package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverExample {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	    // Mouse hover using Action class
		
		WebElement MouseHover=driver.findElement(By.id("mousehover"));
		
		//click on Reload
		Actions action = new Actions(driver);
		action.moveToElement(MouseHover).build().perform();
		
		WebElement Reload=driver.findElement(By.xpath("//a[text()='Reload']"));
		Thread.sleep(2000l);
		action.click(Reload).build().perform();
		
		//Click on top
		WebElement MouseHover1=driver.findElement(By.id("mousehover"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(MouseHover1).build().perform();
		//Click on top
		WebElement top=driver.findElement(By.xpath("//a[contains(@href,'#top')]"));
		Thread.sleep(2000l);
		action1.click(top).build().perform();
		
		
		Thread.sleep(2000l);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
