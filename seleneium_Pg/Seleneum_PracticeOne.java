package seleneium_Pg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleneum_PracticeOne 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
				email.sendKeys("abc@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
				pass.sendKeys("1234567");
				pass.clear();
				Thread.sleep(2000);
				pass.sendKeys("7654321");
				
				boolean displayed = email.isDisplayed();
				System.out.println("Is displayed or not :" +displayed);
				
				boolean enabled = email.isEnabled();
				System.out.println("Is enabled or disabled :" +enabled);
				
				boolean selected = email.isSelected();
				System.out.println("Is selected or not :"+selected);
				
				
		WebElement login = driver.findElement(By.name("login"));
				login.click();	
	}
}
