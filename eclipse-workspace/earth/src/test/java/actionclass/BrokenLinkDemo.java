package actionclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//check the present link on webpage is broken or not
		
		List<WebElement> AllLinks=driver.findElements(By.xpath("//div[@class='dev-links']//a"));
		
		
        for (int i=0; i<AllLinks.size(); i++)
        {
        	String Urlhref=AllLinks.get(i).getAttribute("href");
        	System.out.println("Expected Urlhref is "  +Urlhref);
        	System.out.println("----------------");
        	
        	driver.navigate().to(Urlhref);
        	 
        	String UrlCurrent= driver.getCurrentUrl();
        	System.out.println("Actual UrlCurrent is "  +UrlCurrent);
        	
        	
        	if(!UrlCurrent.equalsIgnoreCase(Urlhref))
        	{
        		System.out.println("Above Link are broken ");
        		
        	}
        	
        	else
        		{
        		System.out.println("Above Link are not broken");
        		}
        	System.out.println("************");
        	driver.navigate().back();
        	
        }
        Thread.sleep(2000l);        	
    	driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
