package seleneium_Pg;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowsHandling_Pg 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions ac = new Actions(driver);
		
		WebElement Jobs = driver.findElement(By.xpath("//div[text()='Jobs']"));
		ac.moveToElement(Jobs).perform();
		driver.findElement(By.xpath("//a[text()='IT jobs']")).click();
		
		driver.findElement(By.xpath("//div[text()='Companies']")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String ID : allWindows) {
			String title = driver.switchTo().window(ID).getTitle();
			System.out.println(title);
			}
			
		String Actual_Window ="It Jobs, 26079 It Job Vacancies In April 2022 - Naukri.com";
		for (String ID1 : allWindows) {
			if(driver.switchTo().window(ID1).getTitle().equals(Actual_Window)) {
				continue;
			}
		}
		System.out.println(driver.getCurrentUrl());
		WebElement recruiters = driver.findElement(By.xpath("//div[text()='Recruiters']"));
		ac.moveToElement(recruiters).perform();
		driver.findElement(By.xpath("//a[text()='Browse All Recruiters']")).click();
	}
}
