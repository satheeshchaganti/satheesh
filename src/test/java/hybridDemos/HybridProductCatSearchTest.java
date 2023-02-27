package hybridDemos;

import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pomPages.BrowserFactory;
import pomPages.ClsEbay;
import pomPages.EbayTestData2;

public class HybridProductCatSearchTest {
	 @Test(dataProvider = "ebaydata")
	  public void ProdCatSearch(String cat,String prod) 
	  {

		  WebDriver driver=BrowserFactory.startBrowser("chrome","http://ebay.com");
		  ClsEbay e=new ClsEbay(driver);
		  e.fnCatSearch(cat,prod);
		  Reporter.log("product search with category in ebay is succesful...",true);

	  }
	  
	  

	  @DataProvider
	  public Object[][] ebaydata() throws Exception {
	    
		  Object[][]  myExcelData=EbayTestData2.getExcelData("C:\\Users\\sathe\\eclipse-workspace\\selenium 9am batch\\satheesh\\MvnDemo\\src\\test\\resources\\DDFWorksheet.xlsx");

			return myExcelData;
		   
	  }
	}

