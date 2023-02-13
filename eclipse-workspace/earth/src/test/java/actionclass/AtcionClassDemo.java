package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AtcionClassDemo {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		
		
		//click on droppable button
		//xpath by contains and text()
		//==>//a[contains(@href,'http://jqueryui.com/droppable/')] by contain
		//==>//a[text()='Droppable'] by text()
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		
		driver.switchTo().frame(0);
		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination =driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
		
		Thread.sleep(2000l);
		driver.quit();

	}

}
