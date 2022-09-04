package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configurations.Config;

public class Base 
{
	public WebDriver launchChrome()
	{
		System.setProperty("webdriver.chrome.driver",Config.chromePath);
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public WebDriver launchFirefox()
	{
		System.setProperty("webdriver.chrome.driver",Config.firefoxPath);
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	
	public void closeWindow(WebDriver driver)
	{
		driver.close();
	}
	
	public void closeAllWindow(WebDriver driver)
	{
		driver.quit();
	}
}
