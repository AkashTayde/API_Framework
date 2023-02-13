package day_22dec22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NewWindowTabDemo {

	static String url   = "https://courses.letskodeit.com/practice";
	static String radioBtnBenz="benzradio";
	static String radioBtnHonda="hondaradio";
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.id(radioBtnBenz)).click();
		String pWinId=driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("http:www.google.com");
		driver.findElement(By.name("q")).sendKeys("FaceBook",Keys.ENTER);
		System.out.println("Title of new window is "+driver.getTitle());
		
		driver.switchTo().window(pWinId);
		driver.findElement(By.id(radioBtnHonda)).click();
		System.out.println("Original window title is "+driver.getTitle());
		
		driver.quit();
	}

}
