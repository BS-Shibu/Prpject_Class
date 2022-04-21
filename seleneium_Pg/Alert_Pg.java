package seleneium_Pg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert_Pg 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@alt='Alert']")).click();
		
		//Alert Box
		driver.findElement(By.xpath("(//button)[1]")).click();
		driver.switchTo().alert().accept();
		
		//Conform Box
		driver.findElement(By.xpath("(//button)[2]")).click();
		driver.switchTo().alert().dismiss();
		
		//Prompt Box
		driver.findElement(By.xpath("(//button)[3]")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Prompt Alert");
		alert.accept();
		
		//Get result wordings from Prompt Box
		WebElement text = driver.findElement(By.id("result1"));
		System.out.println(text.getText());
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(text));
		
		//LineBreak Box
		driver.findElement(By.xpath("//button[@onclick='lineBreaks()']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		
		//Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\Alert.png");
		FileHandler.copy(source,destination);
		
		driver.quit();
	}
}
