package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUsingActions {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//click using Action Class
		WebElement OpenTab=driver.findElement(By.id("opentab"));
		
		Actions actions = new Actions(driver);
		actions.click(OpenTab).build().perform();
		
		Thread.sleep(3);
		driver.quit();
		
	}

}
