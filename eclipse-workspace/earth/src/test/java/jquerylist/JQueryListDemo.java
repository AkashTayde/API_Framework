package jquerylist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryListDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("(//button/span[@class=\"comboTreeArrowBtnImg\"])[1]")).click();
		
		List<WebElement> listOfWebElement =driver.findElements(By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//span[contains(@class,'comboTreeItemTitle')]"));
	
        System.out.println(listOfWebElement.size());
        
        for(int i=0; i<listOfWebElement.size() ; i++ )
        {
        	listOfWebElement.get(i).click();
        	System.out.println(listOfWebElement.get(i).getText());
        }
        
        driver.quit();
	
	}
	

}
