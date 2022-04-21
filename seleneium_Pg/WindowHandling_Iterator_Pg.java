package seleneium_Pg;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandling_Iterator_Pg
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle();
		
		Actions ac = new Actions(driver);
		
		WebElement Jobs = driver.findElement(By.xpath("//div[text()='Jobs']"));
		ac.moveToElement(Jobs).perform();
		driver.findElement(By.xpath("//a[text()='IT jobs']")).click();
		
		driver.findElement(By.xpath("//div[text()='Companies']")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Set<String> allWindows = driver.getWindowHandles();
		
		
		Iterator<String> i1 = allWindows.iterator();
		while(i1.hasNext()){
			String ChildWindow = i1.next();
			if(!parentWindow.equals(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
			}
		}
		System.out.println(driver.getCurrentUrl());
	}
}
