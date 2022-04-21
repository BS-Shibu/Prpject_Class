package seleneium_Pg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Pg 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
			driver.get("http://www.facebook.com");
			driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("//input[@type='text']"));
			email.sendKeys("abc@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'word')]"));
			password.sendKeys("123456789");
		WebElement login = driver.findElement(By.xpath("//button[@name='login' and @type='submit']"));
			login.click();
	}
}
