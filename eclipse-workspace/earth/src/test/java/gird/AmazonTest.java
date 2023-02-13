package gird;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AmazonTest {

	@Test
	public void AMTest() throws MalformedURLException
	{	
	 DesiredCapabilities dc = new DesiredCapabilities();
	 dc.setBrowserName("chrome");
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.38.244:5555"),dc);   //create the instance of RemoteWebDriver Class & also create instance of URL. 
 
	 driver.get("https://www.amazon.com");
	 System.out.println("Amazon title : "+ driver.getTitle());
	 driver.quit();
 }
}
