package seleneium_Pg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Robot_Pg 
{
	public static void main(String[] args) throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions ac = new Actions(driver);
		Robot r = new Robot();
		
		WebElement BestSeller = driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]"));
		ac.contextClick(BestSeller).perform();
		
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement Mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		ac.contextClick(Mobiles).perform();
	
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
	
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		WebElement CustomerService = driver.findElement(By.xpath("(//a[text()='Customer Service'])[1]"));
		ac.contextClick(CustomerService).perform();
		
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		String ParentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID: "+ParentWindow);
		
		Set<String> ChildWindows = driver.getWindowHandles();
		for (String ID : ChildWindows) {
			String title = driver.switchTo().window(ID).getTitle();
			System.out.println("id : "+title);
		}
	}
}
