package seleneium_Pg;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Frame_Pg_With_LG 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@alt='Frame']")).click();
		
		WebElement FirstFrame = driver.findElement(By.xpath("(//iframe)[1]"));
		driver.switchTo().frame(FirstFrame);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		
		WebElement SecondFrame = driver.findElement(By.xpath("(//iframe)[2]"));
		driver.switchTo().frame(SecondFrame);
		
		WebElement InnerFrame = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(InnerFrame);
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		
		List<WebElement> TotalNumber = driver.findElements(By.tagName("iframe"));
		System.out.println(TotalNumber.size());
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File ("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\FrameLG.png");
		FileHandler.copy(source, destination);
		
		driver.quit();
	}
}
