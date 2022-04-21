package seleneium_Pg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Insta_Pgm
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.instagram.com");
		System.out.println("insta login page displayed");
		
		driver.manage().window().maximize();
		System.out.println("windows maximized");
		
		Thread.sleep(3000);
		
		WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
		email.sendKeys("abc@gmail.com");
		System.out.println("mail id entered");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		System.out.println("passwored entered");
		
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
		System.out.println("login button clicked");
	}
}
