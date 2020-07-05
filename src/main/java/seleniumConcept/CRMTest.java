package seleniumConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class CRMTest {
	
WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest1() throws InterruptedException {
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		// identify the user name field pass in username
		driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("xpath");
		driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		
		for(String i : driver.getWindowHandles()) {
			System.out.println(i);
			driver.switchTo().window(i);
			}
		
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("CSS")).click();
		
		
		
		driver.close();
		driver.quit();
}
}



