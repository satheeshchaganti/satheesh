package pomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayProdSearchTest {
  @Test
  public void f()
  {
	  WebDriverManager.chromedriver().browserVersion("109").setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:\\ebay.com");
		driver.findElement(By.id("gh-ac")).sendKeys("sony");
		driver.findElement(By.id("gh-btn")).click();
  }
}
