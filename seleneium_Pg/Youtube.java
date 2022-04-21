package seleneium_Pg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
				driver.get("http://www.youtube.com");
				driver.manage().window().maximize();
				
			WebElement Search = driver.findElement(By.name("search_query"));
				Search.sendKeys("manasil midhuna mazha");
				Thread.sleep(2000);
			WebElement searchicon= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/button/yt-icon"));
				searchicon.click();
				Thread.sleep(3000);
			WebElement play = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"));
				play.click();
				
			
	}
}
