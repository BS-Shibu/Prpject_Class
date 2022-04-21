package seleneium_Pg;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Screenshot_Pg 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//img[@alt='ListBox']")).click();
		
		WebElement dp1 = driver.findElement(By.id("dropdown1"));
		Select s = new Select(dp1);
		s.selectByIndex(1);
		System.out.println("dropdown1 completed");
		
		WebElement dp2 = driver.findElement(By.name("dropdown2"));
		Select s1 =new Select(dp2);
		s1.selectByValue("2");
		System.out.println("dropdown2 completed");
		
		WebElement dp3 = driver.findElement(By.id("dropdown3"));
		Select s2 =new Select(dp3);
		s2.selectByVisibleText("UFT/QTP");
		System.out.println("dropdown3 completed");
		
		System.out.println("dropdown4 completed");
		WebElement dp4 = driver.findElement(By.className("dropdown"));
		Select s3 = new Select(dp4);	
		List<WebElement> options = s3.getOptions();
		int size = options.size();
		System.out.println("Number of Options: "+size);
		System.out.println("Options: ");
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
			
		}
		
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/select")).sendKeys("selenium");
		System.out.println("dropdown5 completed");
		
		WebElement dp6 = driver.findElement(By.xpath("(//select)[6]"));
		Select s4 =new Select(dp6);
		boolean multiple = s4.isMultiple();
		System.out.println("Multiple or Not: "+multiple);
		s4.selectByIndex(1);
		s4.selectByValue("3");
		s4.selectByVisibleText("Loadrunner");
		System.out.println("dropdown6 completed");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\dropdown.png");
		FileHandler.copy(source,destination);
		System.out.println("Screenshot captured");
		driver.quit();
	}
}
