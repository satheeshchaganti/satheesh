  package kwdFramework;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayTest {
 
  	public WebDriver driver;
  	
  	@Test
  	public void SamplTest() throws Exception
  	{
  		XSSFWorkbook wb=new XSSFWorkbook("C:\\Users\\sathe\\eclipse-workspace\\selenium 9am batch\\satheesh\\MvnDemo\\src\\test\\resources\\KWDF.xlsx");
  		XSSFSheet ws= wb.getSheet("Sheet1");
  		int rows=ws.getPhysicalNumberOfRows();
  		
  		for(int i=1;i<rows;i++)
  		{
  			String cTestCase=ws.getRow(i).getCell(0).getStringCellValue();
  			String cLocType=ws.getRow(i).getCell(1).getStringCellValue();
  			String cLocValue=ws.getRow(i).getCell(2).getStringCellValue();
  			String cTestData=ws.getRow(i).getCell(3).getStringCellValue();
  			
  			switch(cTestCase)
  			{
  				case "open browser":
  					if(cTestData.equalsIgnoreCase("Chrome"))
  					{
  						WebDriverManager.chromedriver().browserVersion("109").setup();
  						driver=new ChromeDriver();
  					}
  					else if(cTestData.equalsIgnoreCase("Firefox"))
  					{
  						WebDriverManager.firefoxdriver().browserVersion("65").setup();
  						driver=new FirefoxDriver();
  					}
  					driver.manage().window().maximize();
  					break;
  					
  				case "enter url":
  					driver.get(cTestData);
  					Thread.sleep(3000);
  					break;
  					
  				case "select dropdown":
  					WebElement dd=driver.findElement(locatorInfo(cLocType, cLocValue));
  					Select s=new Select(dd);
  					s.selectByVisibleText(cTestData);
  					break;
  					
  				case "enter text":
  					WebElement txt=driver.findElement(locatorInfo(cLocType, cLocValue));
  					txt.sendKeys(cTestData);
  					break;
  					
  				case "click button":
  					WebElement btn=driver.findElement(locatorInfo(cLocType, cLocValue));
  					btn.click();
  					break;
  			}
  			
  		}
  	}
   	
  	@Test
  	public By locatorInfo(String lType,String lValue)
  	{
  		By b=null;
  		
  		switch(lType)
  		{
  			case "id":
  				b=By.id(lValue);
  				break;
  			case "name":
  				b=By.name(lValue);
  				break;
  			case "class":
  				b=By.className(lValue);
  				break;
  			case "tag":
  				b=By.tagName(lValue);
  				break;
  			case "xpath":
  				b=By.xpath(lValue);
  				break;
  			case "css":
  				b=By.cssSelector(lValue);
  				break;
  			case "lt":
  				b=By.linkText(lValue);
  				break;
  			case "plt":
  				b=By.partialLinkText(lValue);
  				break;
  		}		
  		
  		return b;
}
}