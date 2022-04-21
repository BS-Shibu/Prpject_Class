package seleneium_Pg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JvascriptExecutor_Pg 
{	
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
			
		WebElement pageEnd = driver.findElement(By.xpath("//a[text()='Help']"));
		js.executeScript("arguments[0].scrollIntoView()", pageEnd);
		
		WebElement esvc = driver.findElement(By.xpath("//span[text()='Extra savings with coupons']"));
		js.executeScript("arguments[0].scrollIntoView()", esvc);
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-2000)");
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3000)");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
