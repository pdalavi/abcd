package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	@FindBy(id="email") private WebElement userId;
	@FindBy(xpath="//input[@type='password']") private WebElement pass;
	@FindBy(id="loginbutton") private WebElement login;
	
	@FindBy(xpath="//i[@class='_9ai6 img sp_-Ww9-2lZPiS sx_3813d1']") private WebElement cut;
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterUserId(String userid)
	{
		userId.sendKeys(userid);
	}
	
	public void enterPassword(String password)
	{
		pass.sendKeys(password);
	}
	
	public void submit()
	{
		login.click();
	}
	
	public void toCut()
	{
		cut.click();
	}
}
