package automationpratice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AlterDemo {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException 
	{

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("basicelements")).click();
		
		WebElement btnAlter=driver.findElement(By.id("javascriptAlert"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",btnAlter);
		btnAlter.click();
		//capturescreenshot();
		Thread.sleep(3000l);
		
		Alert alter= driver.switchTo().alert();
		String msg=alter.getText();
		System.out.println(msg);
		alter.accept();
		Thread.sleep(3000l);
		
		if (msg.equals("You must be TechnoCredits student!!"))
		  System.out.println("Test is pass");
		else
			System.out.println("test is fail");
		
		Thread.sleep(3000l);
		
		WebElement Element= driver.findElement(By.id("javascriptAlert"));
		Actions action = new Actions(driver);
		action.click(Element);
		//driver.findElement(By.id("javascriptAlert")).click();
		driver.quit();
		

	}

	public static void capturescreenshot() throws IOException 
	{

		Screenshot screenShot = 
				new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenShot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg1\\error_nov.png"));

		
	}

}
