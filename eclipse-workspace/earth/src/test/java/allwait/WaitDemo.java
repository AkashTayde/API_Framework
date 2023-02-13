package allwait;

import java.time.Duration;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
//		1 approch Implicity wait (we never ever used in industry(not working properly))
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
/*		//2 approch Explicitwait--> WebDirverWait (we used only this in industry)
		driver.findElement(By.name("q")).sendKeys("Facebook");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div/span[text()='facebook'])")));
		
		//Xpath short:-   (//div/span[text()='facebook']) or (//div[@class='pcTkSc']/child::div/span)[1]
		String firstOption=driver.findElement(By.xpath("(//div/span[text()='facebook'])")).getText();
		System.out.println("firstOption :"    +firstOption);
*/	

        //3 approch Explicit --> Fulent wait(only for interveiw purpose(not used in industry))

		driver.findElement(By.name("q")).sendKeys("Facebook");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(25));
		wait.pollingEvery(Duration.ofMillis(500));  //Introgation time ->500millisec bydefult by selenium
	    wait.ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[text()='facebook']")));
	   
	    String firstOption=driver.findElement(By.xpath("(//div/span[text()='facebook'])")).getText();
		System.out.println("firstOption :"    +firstOption);
		
		
		driver.quit();
	}

}
