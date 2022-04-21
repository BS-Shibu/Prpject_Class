package seleneium_Pg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Frame_Pg 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//Single Frame
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Single Frame");
		driver.switchTo().defaultContent();
		//Multiple Frame
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		WebElement OuterFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(OuterFrame);
		
		WebElement InnerFrame = driver.findElement(By.xpath("(//iframe[@src='SingleFrame.html'])[1]"));
		driver.switchTo().frame(InnerFrame);
		
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Multiple Frame");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		//Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\Frame.png");
		FileHandler.copy(source, destination);
		
		driver.quit();
	}
}
