package pomTest;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsEbay;

public class PomEbayProdSearch {
  @Test
  public void f() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("chrome","http://ebay.com");
	  ClsEbay e=new ClsEbay(driver);
	  e.fnSearch("sony");
	  Reporter.log("product search on ebay is succesful...",true);
  }
}
