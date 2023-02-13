package dec_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Finding SVG text   {finding xpath with different syntax in all program}
		driver.navigate().to("https://www.w3schools.com/graphics/tryit.asp?filename=trysvg_text");
		driver.switchTo().frame("iframeResult");
		
		WebElement  element=driver.findElement(By.xpath("//*[name()='svg']//*[name()='text']"));
	    System.out.println(element.getText());
	    
	    //finding color of this circle and attributes
	    driver.navigate().to("https://www.w3schools.com/graphics/tryit.asp?filename=trysvg_circle");
	    driver.switchTo().frame("iframeResult");
	    WebElement circleElement=driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='circle']"));
	    System.out.println(circleElement.getAttribute("fill"));
	    System.out.println(circleElement.getAttribute("stroke"));
	    Thread.sleep(2000l);
	    
	    // with single slash after name()
	    String text2 = driver.findElement(
	    		By.xpath("//*[name()='svg']/*[local-name()='circle']")).getAttribute("fill");
	    System.out.println("Text3 - Color : " + text2);	
	    Thread.sleep(2000l);
	    
	    //Find rotated text 
	 	
	    driver.navigate().to("https://www.w3schools.com/graphics/tryit.asp?filename=trysvg_text2");
	    driver.switchTo().frame("iframeResult");
	    WebElement element1= driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='text']"));
	    System.out.println(element1.getText());
	    Thread.sleep(2000l);
	    
	    

	 // find different text for different lined from svg elemeent
	    
	    driver.navigate().to("https://www.w3schools.com/graphics/tryit.asp?filename=trysvg_text4");
	    driver.switchTo().frame("iframeResult");
	    String allLine=driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='text']")).getText();
	   System.out.println(allLine);
	   
	   WebElement firstLine=driver.findElement(By.xpath("//*[name()='svg']//*[1]//*[1]"));
       System.out.println("first line is "+firstLine.getText());
       
       WebElement secondLine=driver.findElement(By.xpath("//*[name()='svg']//*[1]//*[2]"));
	   System.out.println("Second line is "+secondLine.getText());
	   
	   System.out.println("Heading is "+allLine.split(":")[0]);
	   
       driver.quit();
	    
	
	}

}
