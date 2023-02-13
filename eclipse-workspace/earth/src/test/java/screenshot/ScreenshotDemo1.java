package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class ScreenshotDemo1 {

	static WebDriver driver;
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		driver.navigate().to("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		capturescreenshot();
		driver.quit();
			
	}

	public static void capturescreenshot() throws IOException 
	{
		
		Screenshot screenShot = 
				new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenShot.getImage(), "jpg", new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg\\error.png"));

		
	}

}
