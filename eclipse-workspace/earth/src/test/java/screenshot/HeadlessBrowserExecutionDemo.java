package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import screenshot.ScreenshotDemo1;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HeadlessBrowserExecutionDemo {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();	
		option.setHeadless(true);
		 driver= new ChromeDriver(option);
		
		driver.navigate().to("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Title is "  +driver.getTitle());
		driver.findElement(By.id("opentab")).click();
		
		//switch to window
		
		Set<String> winId=driver.getWindowHandles();
		Iterator<String> iter= winId.iterator();
		String parentWindId=iter.next();
		String childWindId=iter.next();
		System.out.println("parentWindId is "   +parentWindId);
		System.out.println("childWindId is "     +childWindId);
		
		driver.switchTo().window(childWindId);
		Thread.sleep(2000l);
		capturescreenshot();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.titleContains("All"));
		
		System.out.println("childWind Title is "   +driver.getTitle());
		
		
		
		driver.switchTo().window(parentWindId);
		System.out.println("parentWind Title is "  +driver.getTitle());
		Thread.sleep(2000l);
		capturescreenshot();
		
		driver.quit();
		
	}

	public static void capturescreenshot() throws IOException 
	{
		Screenshot screenShot = 
				new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenShot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg1\\error_nov_13.png"));

		
	} 

}
