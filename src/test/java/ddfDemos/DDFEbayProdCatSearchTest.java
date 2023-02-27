package ddfDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFEbayProdCatSearchTest {
  @Test(dataProvider = "ebaydata")
  public void ProdCatSearch(String cat,String prod) 
  {

	  WebDriverManager.chromedriver().browserVersion("109").setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com");


		WebElement dd=driver.findElement(By.id("gh-cat"));
		Select s=new Select(dd);
		s.selectByVisibleText(cat);

		
		driver.findElement(By.id("gh-ac")).sendKeys(prod);
		driver.findElement(By.id("gh-btn")).click();

		Reporter.log("'" + prod + "' product search is Successful...",true);  
  }
  
  

  @DataProvider
  public Object[][] ebaydata() throws IOException {
    
	  Object[][] myData=null;
	   XSSFWorkbook wb=new XSSFWorkbook("C:\\Users\\sathe\\eclipse-workspace\\selenium 9am batch\\satheesh\\MvnDemo\\src\\test\\resources\\DDFWorksheet.xlsx");
	   XSSFSheet ws=wb.getSheet("sheet1");
	   int rows=ws.getPhysicalNumberOfRows();
	   myData=new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			myData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
			myData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();

		}

		return myData;
	   
  }
}
