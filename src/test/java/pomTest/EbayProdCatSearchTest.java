package pomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayProdCatSearchTest {
  @Test
  public void f()
  {
	  WebDriverManager.chromedriver().browserVersion("109").setup();
	  WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:\\ebay.com");
		WebElement d=driver.findElement(By.xpath("//*[@id='gh-cat']"));
		Select s=new Select(d);
		s.selectByVisibleText("Cameras & Photo");
		driver.findElement(By.id("gh-ac")).sendKeys("sony");
		driver.findElement(By.id("gh-btn")).click();
  }
}
