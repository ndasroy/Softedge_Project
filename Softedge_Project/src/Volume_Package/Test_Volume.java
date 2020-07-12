package Volume_Package;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class Test_Volume 
{
	WebDriver driver=null;
	int i=0;
	
	void takeScreenShot(WebDriver driver,String FileName)	throws IOException	// Catching the filename
	{
			i++;
			FileName=FileName+i+".jpg";
			TakesScreenshot screenShot=(TakesScreenshot)driver;
			File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File(FileName));
		
	}
	
  @Test(dataProvider = "dataProvider")
  
  	public void excelDataRead(String RadiusValue) throws Exception
  
  {
	  
		Volume_Cal_PO.mathCalculator(driver).click();
		Volume_Cal_PO.volumeCalculator(driver).click();
		Volume_Cal_PO.radiusTestbox(driver).sendKeys(RadiusValue);
		Volume_Cal_PO.calculateRadius(driver).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Volume_Cal_PO.resultDisplay(driver).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String S=Volume_Cal_PO.resultDisplay(driver).getText();
		
		// Creating objects for taking screenshots
		Test_Volume sc=new Test_Volume();
		sc.takeScreenShot(driver, "c:\\Temp\\BallRadius_Result");	// Passing the filename of screenshot
		
		//Creating a file
		File file=new File("C:\\Result.txt");
		
		//Writing on file
		FileWriter writer=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(writer);
		bw.write(S);
		bw.close();
		writer.close();		
		
		System.out.println("Test Case Completed");
  }

  @DataProvider
  	public Object[][] dataProvider() throws Exception
  {
	  	  Object[][] O=null;
	  
		  Workbook wb=Workbook.getWorkbook(new File("C:\\Data1.xls"));	// file should saved in xls format,not xlsx format
		  
		  Sheet Sh=wb.getSheet(0);
		  
		  O=new Object[Sh.getRows()][Sh.getColumns()];
		  
		  for(int i=0;i<Sh.getRows();i++)
		  {
			  for(int j=0;j<Sh.getColumns();j++)
			  {
				  O[i][j]=Sh.getCell(j,	i).getContents();				// i=row;j=column
				  
				  //System.out.print(Sh.getCell(j,	i).getContents()+"	");
			  }
			  System.out.println();
		  }
		  
		  return O;
  }
  
  @BeforeTest
  	public void beforeTest() 
  {
	  	driver=new FirefoxDriver();
		driver.get("http://www.calculator.net");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println("Test Pre-Requisite Completed");
  }

@AfterTest
  	public void afterTest() throws IOException
  {
	  
      String FName = "C:\\New.xlsx";

      try 
      {
          FileInputStream FS = new FileInputStream(FName);
          File OutputSheetFile = new File(FName);
          if(OutputSheetFile.exists()) 
          {
              System.out.println("File existed");
//              try
//              {
//                  XSSFWorkbook ObjWorkBook = new XSSFWorkbook(FS);
//                  XSSFSheet DriverTableSheet = ObjWorkBook.getSheetAt(0);
//                  for(int i=1;i<3;i++)
//                  {
//	                  XSSFRow row1 = DriverTableSheet.getRow(i);
//	                  XSSFCell Cell1 = row1.getCell(0);
//	
//	                  System.out.println("Cell1"+ Cell1);
//	                  //System.out.println("Cell2"+ Cell2);
//	                   String str = "Abc";
//	                   Cell1.setCellValue(str);
//	
//	                   FileOutputStream out1 = new FileOutputStream (FName,false);
//	                   ObjWorkBook.write(out1);
//	                   FS.close();
//                  }
//
//              } 
//	          catch (IOException e) 
//	          {
//	              e.printStackTrace();
//	          }

          }
      } 
	      catch (FileNotFoundException e) 
	      {
	          e.printStackTrace();
	      }
      	  
	  
      		driver.quit();
      		System.out.println("Test Execution Completed");
  }



}





