package enterkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterKey {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();   // 9850638471
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Facebook",Keys.ENTER);
        Thread.sleep(4000l);
        driver.close();
	}

}
