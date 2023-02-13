package configpackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertiesfileRoot {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=null;
		Properties pro=null;
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")
					                   + "/src/test/java/configpackage/config.properties");
		
			pro = new Properties();
			pro.load(fr);
		
		} catch (FileNotFoundException e) {
			System.out.println("path of file is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("file is not load properly");
			e.printStackTrace();
		}
		
		//use properties data
		
		String URL=pro.getProperty("url");
		System.out.println("URL is "  +URL);
		
		String br=pro.getProperty("browser");
		System.out.println("browser is "  +br);
//		Integer brName=Integer.parseInt("br");
//		System.out.println(brName);
		
		String TimeOut= pro.getProperty("timeout");
		Integer to=Integer.parseInt(TimeOut);
		System.out.println("TimeOut is "  +(to+200));
		
        String clr=pro.getProperty("colors");	
        System.out.println("colors is "   +clr);
        
        String[] c=clr.split(",");
        System.out.println(c[0]);
        System.out.println(c[1]);
        System.out.println(c[2]);
        System.out.println(c[3]);
        
        if (br.equalsIgnoreCase("chrome"))
        {
       	 WebDriverManager.chromedriver().setup();
       	 driver = new ChromeDriver();
        }
        else if (br.equalsIgnoreCase("edge"))
        {
       	 WebDriverManager.edgedriver().setup();
       	 driver=new EdgeDriver();
        }
        else if (br.equalsIgnoreCase("firefox"))
        {
       	 WebDriverManager.firefoxdriver().setup();
       	 driver=new FirefoxDriver();
        }
        else
        {
       	 System.out.println("Invalid browser in confi.properties, browser is " +br );
       	 Thread.sleep(2000l);
       	 throw new RuntimeException ("Invalid browser please check the browser");
        }
        
        driver.get(URL);
        String getTitle =driver.getTitle();
        System.out.println("Title is "+getTitle);
        
        Thread.sleep(2000l);
        driver.quit();
            
    	   
        }
	
		
		



}

