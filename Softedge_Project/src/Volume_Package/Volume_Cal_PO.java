package Volume_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Volume_Cal_PO 
{

	private static WebElement element = null;
	
		public static WebElement mathCalculator(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Volume_Locator.MathCal));
			return element;
		}
		
		public static WebElement volumeCalculator(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Volume_Locator.VolumeCal));
			return element;
		}
		
		public static WebElement radiusTestbox(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Volume_Locator.BallRadius));
			return element;
		}
		
		public static WebElement calculateRadius(WebDriver driver)
		{
			element=driver.findElement(By.name(Volume_Locator.CalculateBall));
			return element;
		}
		
		public static WebElement resultDisplay(WebDriver driver)
		{
			element=driver.findElement(By.xpath(Volume_Locator.BallResult));
			return element;
		}
		
		
}


