package seleneium_Pg;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WebTable_Pg 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@alt='Table']")).click();
		
		driver.findElement(By.xpath("(//input[@name='vital'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='vital'])[2]")).click();
		driver.findElement(By.xpath("(//input[@name='vital'])[3]")).click();
		driver.findElement(By.xpath("(//input[@name='vital'])[4]")).click();
		driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
		
		List<WebElement> allData = driver.findElements(By.xpath("//table/tbody/tr/td"));
			for (WebElement table : allData) {
				System.out.println(table.getText());
			}
		List<WebElement> rowData = driver.findElements(By.xpath("//table/tbody/tr[4]/td"));
			for (WebElement row : rowData) {
				System.out.println(row.getText());
			}
		List<WebElement> columnData = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
			for (WebElement column : columnData) {
				System.out.println(column.getText());
			}
		WebElement particularData = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]"));
			System.out.println(particularData.getText());
			
		List<WebElement> header = driver.findElements(By.tagName("th"));
			for (WebElement headerTitle : header) {
				System.out.println(headerTitle.getText());
			}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File ("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\Webtable.png");
		FileHandler.copy(source, destination);
	}
}
