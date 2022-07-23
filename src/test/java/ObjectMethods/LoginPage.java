package ObjectMethods;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName = By.id("txtUsername");
	By password = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	By linkCheckall = By.tagName("a");
	
	By forgotLink = By.xpath("//a[normalize-space()='Forgot your password?']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void userName(String getUsername)
	{
		WebElement userNameEle = driver.findElement(userName);
		userNameEle.sendKeys(getUsername);
	}
	
	public void password(String getPassword)
	{
		WebElement passwordEle = driver.findElement(password);
		passwordEle.sendKeys(getPassword);
	}
	
	public void clickButton()
	{
		driver.findElement(btnLogin).click();
	}
	
	public void checkLink()
	{
		List<WebElement> list = driver.findElements(linkCheckall);
		
		System.out.println("List of link on page is :"+list.size());
		
		for(WebElement i :list)
		{
			String getValue = i.getAttribute("href");
			if(getValue.isEmpty())
			{
				Assert.assertTrue(false);
			}
		}
	}
	
	public void checkLinktest()
	{	
		driver.findElement(forgotLink).click();
		
		if(driver.getTitle().contains("https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
