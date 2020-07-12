package Calculator_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Percent_Cal_PO 
{

	private static WebElement element = null;
	
		public static WebElement mathCalculator(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.MathCal));
			return element;
		}
		
		public static WebElement percentCalculator(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.PercentCal));
			return element;
		}
		
		public static WebElement percentInnerPage1(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.Percentage));
			return element;
		}
		
		public static WebElement percentInnerPage2(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.Principal));
			return element;
		}
		
		public static WebElement percentInnerPage3(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.Interest));
			return element;
		}
		
		public static WebElement percentInnerPage4(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.Calculate));
			return element;
		}
		
		public static WebElement percentInnerPage5(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Percent_Locator.ResultValue));
			return element;
		}
}


