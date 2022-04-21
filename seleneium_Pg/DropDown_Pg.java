package seleneium_Pg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown_Pg 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		System.out.println("main page");
		
		driver.manage().window().maximize();
		System.out.println("maximized");
		
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		System.out.println("create new account");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("firstname")).sendKeys("xxxxxxx");
		System.out.println("firstname filled");
		
		driver.findElement(By.name("lastname")).sendKeys("yyyyyyyy");
		System.out.println("lastname filled");
		
		driver.findElement(By.xpath("(//input[@type='text' and @ data-type='text'])[3]")).sendKeys("98965675456465");
		System.out.println("mobile number entered");
		
		driver.findElement(By.xpath("//input[@type='password' and @ data-type='password']")).sendKeys("1234567890");
		System.out.println("password entered");
		
		Thread.sleep(1000);
		
		WebElement Date = driver.findElement(By.id("day"));
		Select s = new Select(Date);
		s.selectByIndex(2);
		System.out.println(Date.isDisplayed());
		
		WebElement Month = driver.findElement(By.id("month"));
		Select s1 = new Select(Month);
		s1.selectByValue("6");
		System.out.println(Month.isDisplayed());
		
		WebElement Year = driver.findElement(By.id("year"));
		Select s2 = new Select(Year);
		s2.selectByVisibleText("1991");
		System.out.println(Year.isDisplayed());
		
		WebElement Gender = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
		Gender.click();
		System.out.println(Gender.isSelected());
	}
}
