
package seleneium_Pg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Pg 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationtesting.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ac = new Actions(driver);
		
		WebElement dC = driver.findElement(By.xpath("//a[text()='Demo Site']"));
		ac.doubleClick(dC).build().perform();
		System.out.println("Double click done");
		
		//FOR ADVERTISEMENT ON WINDOW
		driver.switchTo().frame("aswift_4");
		driver.switchTo().frame("ad_iframe");
		driver.findElement(By.id("dismiss-button")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement mTE = driver.findElement(By.xpath("//a[text()='Interactions ']"));
		ac.moveToElement(mTE).build().perform();
		System.out.println("move to element1 done");
		
		WebElement mTE1 = driver.findElement(By.xpath("//a[text()='Drag and Drop ']"));
		ac.moveToElement(mTE1).build().perform();
		System.out.println("move to element2 done");
		
		WebElement click = driver.findElement(By.xpath("//a[text()='Static ']"));
		ac.click(click).build().perform();
		System.out.println("click done");
		
	
		WebElement source = driver.findElement(By.xpath("//img[@id='angular']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droparea']"));
		ac.dragAndDrop(source, target).build().perform();
		System.out.println("drag and drop 1 done");
		
		WebElement source1 = driver.findElement(By.id("mongo"));
		ac.dragAndDrop(source1, target).build().perform();
		System.out.println("drag and drop 2 done");
		
		WebElement source2 = driver.findElement(By.id("node"));
		ac.clickAndHold(source2).moveToElement(target).release(target).build().perform();
		System.out.println("drag and drop 3 done");
		
		ac.contextClick(target).build().perform();
		System.out.println("Right-click done");
		
		driver.quit();
		
		
	}
}
