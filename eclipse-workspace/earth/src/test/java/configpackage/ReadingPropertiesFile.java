package configpackage;

//import java.io.BufferedOutputStream;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver =null;
		Properties pro=null;
		FileInputStream fis=null;
		//hardcode path 
		try {
			 fis =new FileInputStream("C:/Users/Aaku/eclipse-workspace/earth/src/test/java/configpackage/config.properties");
			pro=new Properties();
			pro.load(fis);
			
//			FileOutputStream fos = new FileOutputStream("C:/Users/Aaku/eclipse-workspace/ReadProperties.txt");
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			
//			int infoconfigProperties;
//			while((infoconfigProperties=fis.read())!=-1)
//			{
//				System.out.println("config properties details is" + (char)infoconfigProperties);
//				fos.write((char) infoconfigProperties);
//			}
//			bos.flush();
//			fos.flush();
//			fis.close();
//			bos.close();
//		fos.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("C:/Users/Aaku/eclipse-workspace/earth/src/test/java/configpackage/config.properties"+"this path not found" );
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("C:/Users/Aaku/eclipse-workspace/earth/src/test/java/configpackage/config.properties"+"file is not load");
			e.printStackTrace();
		}
//		System.exit(0);
		String URL=pro.getProperty("url");
		System.out.println("URL is " +URL);
		
		String br=pro.getProperty("browser");
		System.out.println("browser is " +br);
		
		String timeOut=pro.getProperty("timeout");
		int timeOut1=Integer.parseInt(timeOut);
		System.out.println("Timeout time is " +(timeOut1+100));
		
		String clrs=pro.getProperty("colors");
		System.out.println("colors is "  +clrs);
		//wants separate colors we use split()
		String [] color = clrs.split(",");
		System.out.println(color[0]);
		System.out.println(color[1]);
		System.out.println(color[2]);
		System.out.println(color[3]);
		
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
