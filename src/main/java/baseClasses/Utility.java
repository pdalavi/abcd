package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import configurations.Config;

public class Utility 
{
	public static void screenshot(WebDriver driver,String tcID) throws IOException
	{
		Date d=new Date();
		String datee = d.toString();
		datee=datee.replace("","");
		datee=datee.replace(":","");
		String sPath=Config.imagePath+tcID+".jpeg";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(sPath);
		FileHandler.copy(src, dest);
	}
	
	public static String excel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream(Config.excelPath);
		Sheet excel1 = WorkbookFactory.create(file).getSheet(sheet);
		String data = excel1.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static String readPropertyFile(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream file=new FileInputStream(Config.propertydata);
		p.load(file);;
		String value=p.getProperty(key);
		return value;
	}
	
	public static WebDriver wait1(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		return driver;
	}
}
