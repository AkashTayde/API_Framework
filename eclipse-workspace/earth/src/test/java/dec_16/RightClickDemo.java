package dec_16;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement img=driver.findElement(By.xpath("(//p/img)[2]"));
		Actions action=new Actions(driver);
		action.contextClick(img).build().perform();
		Thread.sleep(2000l);
		
		driver.findElement(By.id("dm2m1i1tdT")).click();
		Thread.sleep(2000l);
		
		driver.findElement(By.id("dm2m2i2tdT")).click();
		Thread.sleep(1000l);
		
		Set<String> windoHandles=driver.getWindowHandles();
		Iterator<String> winID=windoHandles.iterator();
		//String pWin=winID.next();
		String cWin=winID.next();
		
		driver.switchTo().window(cWin);
		String actualTitle=driver.getTitle();
	    System.out.println("actualTitle is "   +actualTitle );
	    
	    if(actualTitle.equals("Menu Javascript Parameters - Product Info"))
	    	System.out.println("Test is passed");
	    else
	        System.out.println("Test is Failed");
		
	    
	    driver.quit();
		
		
		}

}
