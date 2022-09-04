package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.Base;
import baseClasses.Utility;
import configurations.Config;
import pomClasses.Login;

public class Test1 extends Base
{
	WebDriver driver;
	Test1 base;
	Login log;
	String tcId;
	
	@BeforeMethod
	public void refresh()
	{
		driver.navigate().refresh();
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		base=new Test1();
		driver=base.launchChrome();
		driver.get(Config.urlLogin);
		driver=Utility.wait1(driver,10);
		log=new Login(driver);
	}
	
	@AfterMethod
	public void result(ITestResult res) throws IOException
	{
		Reporter.log(tcId, res.getStatus(),true);
		if(ITestResult.FAILURE==res.getStatus())
		{
			Utility.screenshot(driver, tcId);
		}
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
	@Test
	public void tc01()
	{
		tcId="TC01";
		log.enterUserId("aaaa");
		log.submit();
		log.toCut();
	}
	
	@Test
	public void tc02()
	{
		tcId="TC02";
		log.enterPassword("aaaa");
		log.submit();
	}
	
	@Test
	public void tc03()
	{
		tcId="TC03";
		log.enterUserId("aaaa");
		log.enterPassword("aaaa");
		log.submit();
	}
}
