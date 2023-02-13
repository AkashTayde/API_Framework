package day_22dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableDisableDemo {

	static String url="https://courses.letskodeit.com/practice";
	static String btnDisable ="disabled-button";
	static String btnEnable="enabled-button";
	static String txField="enabled-example-input";
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.id(txField)).sendKeys("Nepanagar");
		driver.findElement(By.id(btnDisable)).click();
		
		boolean txtState1=driver.findElement(By.id(txField)).isEnabled();
		Thread.sleep(2000l);
		
		boolean resultFlag=true;
		if(!txtState1)
			System.out.println("Test step#1 is passed");
		else
		{
			System.out.println("Test step#1 is Failed");
			resultFlag=false;
		}
		Thread.sleep(2000l);
		driver.findElement(By.id(btnEnable)).click();
		boolean txtState2=driver.findElement(By.id(txField)).isEnabled();
		
		
	    if(txtState2)
	    	System.out.println("Test step#2 is passed");
	    else
	    {
	    	System.out.println("Test step#2 is Failed");
	    	resultFlag=false;
	    }
	    
	    driver.findElement(By.id(txField)).clear();
	    driver.findElement(By.id(txField)).sendKeys("Burhanpur");
	    
	    if(resultFlag)
	    	System.out.println("Test case is passed ");
	    else
	    	System.out.println("Test case is failed ");
	    
		/*
		 * if(!txtState1 && txtState2) System.out.println("Test case is passed"); else
		 * System.out.println("Test case is failed");
		 */ 
	    
	    
		
	
		
		
		driver.quit();
		

	}

}
