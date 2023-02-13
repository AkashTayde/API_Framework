package dec_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeDemo
{
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000l);
		
		JavascriptExecutor js=( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(300,300)","");
		
		WebElement element=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(element);
		
		WebElement resizeElement=driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		
		Actions action=new Actions(driver);
		action.clickAndHold(resizeElement).moveByOffset(50, 100).release().build().perform();
		
		Thread.sleep(2000l);
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000l);
		driver.quit();
	}

}
