package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {
  @Test
  public void EbaySearch() 
  
  {
	  WebDriverManager.chromedriver().browserVersion("109").setup();
	  //System.setProperty("webdriver.chromedriver","C:\\Users\\sathe\\Downloads\\chromedriver_win32.exe" );
	  WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get("http:\\ebay.com");
	     WebElement d=driver.findElement(By.id("gh-cat"));
	    Select s=new Select(d);
	     s.selectByIndex(6);
	     driver.findElement(By.id("gh-ac")).sendKeys("best mobiles");
	     driver.findElement(By.id("gh-btn")).click();

  }
}
