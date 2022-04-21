package seleneium_Pg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowsHandling_byList 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("facebook");
		driver.findElement(By.name("btnK")).click();
		
		Actions ac = new Actions(driver);
		
		WebElement faceBook = driver.findElement(By.xpath("//h3[text()='Facebook - log in or sign up']"));
		ac.contextClick(faceBook).perform();
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
	
		Set<String> allWindow = driver.getWindowHandles();
		for (String allID : allWindow) {
			System.out.println(driver.switchTo().window(allID).getTitle());
		}
		int size = allWindow.size();
		System.out.println(size);
		ArrayList<String> a = new ArrayList<>(allWindow);
		
		driver.switchTo().window(a.get(1));
		
		driver.findElement(By.id("email")).sendKeys("shibu.bs7@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Shivasai@0803");
		driver.findElement(By.name("login")).click();
		
		driver.switchTo().window(a.get(0));
		
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("instagram");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement insta = driver.findElement(By.xpath("//h3[text()='Instagram']"));
		ac.contextClick(insta).build().perform();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Set<String> allWindow1 = driver.getWindowHandles();
		for (String id : allWindow1) {
			System.out.println(driver.switchTo().window(id).getTitle());
		}
		int size2 = allWindow1.size();
		System.out.println(size2);
		List<String> b = new ArrayList<>(allWindow1);
		
		driver.switchTo().window(b.get(2));
		
		driver.findElement(By.name("username")).sendKeys("shibu.bs7@gmail.com");
		driver.findElement(By.name("password")).sendKeys("ghdhgdy3663");
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		driver.close();
		
		driver.switchTo().window(b.get(0));
		
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("twitter");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.quit();
		
	}
}
