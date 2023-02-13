package day_22dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnabledDisabledDemo1 {

	static String url   = "https://courses.letskodeit.com/practice";
	static String btnHide="hide-textbox";
	static String btnShow="show-textbox";
	static String txtField="displayed-text";
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		Thread.sleep(2000l);
		driver.findElement(By.id(txtField)).sendKeys("Pune");
		driver.findElement(By.id(btnHide)).click();
		boolean isDisplayed=driver.findElement(By.id(txtField)).isDisplayed();
		
		
		boolean flag=true;
		if (!isDisplayed)
			System.out.println("Test step#1 is passed");
		else
		{
			System.out.println("Test step#1 is failed");
			flag=false;
		}
		
		Thread.sleep(2000l);
		
		driver.findElement(By.id(btnShow)).click();
		isDisplayed= driver.findElement(By.id(txtField)).isDisplayed();
		
		if (isDisplayed)
			System.out.println("Test step#2 is passed");
		else
		{
			System.out.println("Test step#2 is failed");
			flag=false;
		}
		driver.findElement(By.id(txtField)).clear();
		driver.findElement(By.id(txtField)).sendKeys("Nepanagar");
		
		if(flag)
			System.out.println("Test case is passed ");
		else
			System.out.println("Test case is failed ");
		
		driver.quit();
		

	}

}
