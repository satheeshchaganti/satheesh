package pomTest;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsEbay;

public class PomEbayCatProdSearch {
  @Test
  public void f() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("chrome","http://ebay.com");
	  ClsEbay e=new ClsEbay(driver);
	  e.fnCatSearch("Cameras & Photo","sony");
	  Reporter.log("product search with category in ebay is succesful...",true);

  }
}
