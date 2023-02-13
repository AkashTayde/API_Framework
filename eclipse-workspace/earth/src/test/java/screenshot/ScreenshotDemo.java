package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://courses.letskodeit.com/practice");
		
   	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		String destFile=System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenshotPkg1\\error201";
		System.out.println(destFile);
		
		TakesScreenshot ScreenShot=(TakesScreenshot) driver;
		File sourceFile = ScreenShot.getScreenshotAs(OutputType.FILE);
		captureScreenshot(sourceFile, destFile);
		
		
		driver.get("https://www.facebook.com/");
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,500)", "");
		TakesScreenshot ScreenShot1=(TakesScreenshot) driver;
		Thread.sleep(5000l);
		 sourceFile = ScreenShot1.getScreenshotAs(OutputType.FILE);
		captureScreenshot(sourceFile, destFile);
		
		driver.quit();

	}

	 static void captureScreenshot(File sourceFile, String destFile) throws IOException 
	{
		Date dt=new Date();
		destFile=destFile + "_" + dt.toString().replaceAll(" ", "_").replace(":", "_") + ".png";
		FileUtils.copyFile(sourceFile, new  File(destFile));
	}

}
