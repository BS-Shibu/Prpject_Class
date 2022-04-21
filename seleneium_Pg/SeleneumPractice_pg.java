package seleneium_Pg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleneumPractice_pg
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
				driver.get("http://www.google.com");
				driver.manage().window().maximize();
				String title = driver.getTitle();
				System.out.println(title);
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
				//String pageSource = driver.getPageSource();
				driver.navigate().to("http://www.facebook.com");
				driver.navigate().back();
				Thread.sleep(2000);
				driver.navigate().forward();
				Thread.sleep(1000);
				driver.quit();
	}
}
