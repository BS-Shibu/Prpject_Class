package seleneium_Pg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class MiniProject 
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Sign-in
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.id("email")).sendKeys("project@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("a1b2c3");
		driver.findElement(By.id("SubmitLogin")).click();
		
		Actions ac = new Actions(driver);
		
		//Dresses & Evening Dresses
		WebElement dresses = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		ac.moveToElement(dresses).build().perform();
		driver.findElement(By.xpath("(//a[text()='Evening Dresses'])[2]")).click();
		
		WebElement img = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
		ac.moveToElement(img).build().perform();
		
		//Quick view page
		WebElement quickView = driver.findElement(By.linkText("Quick view"));
		ac.click(quickView).build().perform();

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
		driver.switchTo().frame(frame);
		
		//Select Options
		WebElement size = driver.findElement(By.name("group_1"));
		Select s = new Select(size);
		s.selectByVisibleText("L");
		
		driver.findElement(By.name("Pink")).click();
		
		driver.findElement(By.id("add_to_cart")).click();
		driver.switchTo().defaultContent();
		
		//Proceed to checkout
		driver.findElement(By.linkText("Proceed to checkout")).click();
		
		driver.findElement(By.linkText("Proceed to checkout")).click();
		
		driver.findElement(By.name("processAddress")).click();
		
		driver.findElement(By.id("cgv")).click();
		
		driver.findElement(By.name("processCarrier")).click();
		
		//Payment
		driver.findElement(By.className("cheque")).click();
		
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		//Scroll down to result
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement myStore = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		js.executeScript("arguments[0].scrollIntoView()", myStore);
		
		//Screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\eclipse-workspace\\Selenium_Training\\Screenshot\\Miniproject.png");
		FileHandler.copy(source, destination);
		
		Thread.sleep(5000);
		driver.quit();
	}
}
