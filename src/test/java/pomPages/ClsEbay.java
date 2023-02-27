package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClsEbay 
{
	public WebDriver wd;
	public ClsEbay(WebDriver driver)
	{
		wd=driver;
	}
   By txt=By.id("gh-ac");
   By btn=By.id("gh-btn");
   By ddcat=By.id("gh-cat");
   public void fnSearch(String prodName)
   {
	   wd.findElement(txt).sendKeys("sony");
	   wd.findElement(btn).click();
	}
   public void fnCatSearch(String cat,String pName)
   {
	   WebElement d=wd.findElement(ddcat);
	   Select s=new Select(d);
	   s.selectByVisibleText(cat);
	   fnSearch(pName);
	}
}
