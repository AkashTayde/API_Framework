package dec_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.navigate().to("https://sajithatharaka.github.io/svg-automation/");
		
		WebElement circle=driver.findElement(By.xpath("//*[name()='svg']//*[name()='circle']"));
        System.out.println("cx is " +circle.getAttribute("cx"));
        System.out.println("cy is "+circle.getAttribute("cy"));
        System.out.println("stroke color is " +circle.getAttribute("stroke"));
        System.out.println("stroke-width is "  +circle.getAttribute("stroke-width"));
        System.out.println("fill is " +circle.getAttribute("fill"));
        System.out.println("radius is "  +circle.getAttribute("r"));
        
        WebElement svgRectangle=driver.findElement(By.xpath("//*[local-name()='rect' and @id='rectangle']"));
    	System.out.println("Width  : "+svgRectangle.getAttribute("width"));
    	System.out.println("Height : "+svgRectangle.getAttribute("height"));
    	
    	WebElement svgText=driver.findElement(By.xpath("//*[local-name()='text']"));
    	System.out.println("Text getText()         : "+svgText.getText());
    	System.out.println("Text using textContent : "+svgText.getAttribute("textContent"));
    	System.out.println("Text using innerHTML   : "+svgText.getAttribute("innerHTML"));
    	
        
        driver.quit();
		
		
		
	}

}
