package seleneium_Pg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath_Pg 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Customer Service']//following::a[1]")).click();
		System.out.println("Completed Following Axes");
		
		driver.findElement(By.xpath("//a[text()='Customer Service']//preceding::a[1]")).click();
		System.out.println("Completed Preceding Axes");
		
		driver.findElement(By.xpath("//a[text()='Customer Service']//following-sibling::a[3]")).click();
		System.out.println("Completed Following-sibling Axes");
		
		driver.findElement(By.xpath("//a[text()='Customer Service']//preceding-sibling::a[2]")).click();
		System.out.println("Completed Preceding-sibling Axes");
		
		driver.findElement(By.xpath("//*[@id=\'nav-logo-sprites\']")).click();
		
		driver.findElement(By.xpath("//a[text()='Fashion']//ancestor::div[1]//a[1]")).click();
		System.out.println("Completed Ancestor Axes");
		
		driver.findElement(By.xpath("//*[@id=\'nav-logo-sprites\']")).click();
		
		driver.findElement(By.xpath("((//div[@class='nav-fill'])[3]//descendant::*[6])[2]")).click();
		System.out.println("Completed Descendant Axes");
		
		driver.findElement(By.xpath("//*[@id=\'nav-logo-sprites\']")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Fresh']/parent::*/parent::*/parent::*/parent::*/parent::*//div[1])[4]/img")).click();
		System.out.println("Completed Parent Axes");
		
		driver.findElement(By.xpath("//*[@id=\'nav-logo-sprites\']")).click();
		
		driver.findElement(By.xpath("(//div[@id='gw-layout']/child::*[1]//div[2]//div[2]//img[1])[3]")).click();
		System.out.println("Completed Chiled Axes");		
	}
}
