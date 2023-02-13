package automationpratice;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForAProduct {
	
	
	
	@Test
	public void test() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		
		driver.findElement(By.id("search")).clear();
		
		driver.findElement(By.id("search")).sendKeys("jacket",Keys.ENTER);
		Thread.sleep(2000l);
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size-143-item-166"))).click();
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Add to Cart']/span"))).click();
		Thread.sleep(4000l);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("qty"))).clear();
		String actualQtyNo="5";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("qty"))).sendKeys(actualQtyNo);
		Thread.sleep(3000l);
		
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-52")).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		
		Thread.sleep(3000l);
		
		wait.until
		(ExpectedConditions.presenceOfElementLocated
				(By.xpath
						("//span[@data-bind=\"css: { empty: !!getCartParam('summary_count') "
								+ "== false && !isLoading() }, blockLoader: isLoading\"]"))).click();
		
		Thread.sleep(2000l);
		String expectedQtyNo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='number'])[1]"))).getText();
		 System.out.println(expectedQtyNo);
//		assertEquals(actualQtyNo,expectedQtyNo,"Both are not equals in Proced to check");
		Thread.sleep(2000l);
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
		Thread.sleep(3000l);
		String expectedProcedToCheckoutQtyNo= driver.findElement(By.xpath("//span[@data-bind='text: $parent.qty']")).getText();
		assertEquals(actualQtyNo,expectedProcedToCheckoutQtyNo,"Both are not equals");
		driver.quit();
		
	}

}
