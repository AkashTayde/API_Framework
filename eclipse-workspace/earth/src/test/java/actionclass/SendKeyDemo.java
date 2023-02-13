package actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeyDemo {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement SerchBox=driver.findElement(By.name("q"));
		
		Actions action=new Actions(driver);
		action.sendKeys(SerchBox, "Facebox").build().perform();
		
		Thread.sleep(2000l);
		driver.quit();

	}

}
