package dec_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.navigate().to("https://www.dista.ai/");


		Actions action=new Actions(driver);
		WebElement productbutton=driver.findElement(By.xpath("(//ul//a)[1]"));
		action.moveToElement(productbutton).build().perform();

		WebElement distaFoodBtn=driver.findElement(By.xpath("(//div/h3[@class='elementor-icon-box-title']/a)[5]"));
		distaFoodBtn.click();

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		WebElement resultBtn=driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[1]"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div//span[text()='1500']")));
		System.out.println(resultBtn.getText());

		resultBtn=driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[2]"));
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div//span[text()='50']")));
		System.out.println(resultBtn.getText());

		resultBtn=driver.findElement(By.xpath("(//div//span[@class='elementor-counter-number'])[3]"));
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div//span[text()='99.9']")));
		System.out.println(resultBtn.getText());


		Thread.sleep(5000l);
		driver.quit();
	}

}
