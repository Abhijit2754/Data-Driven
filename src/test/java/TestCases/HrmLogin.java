package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Configuration.BaseClass;
import ObjectMethods.LoginPage;
import junit.framework.Assert;
import DataProvider.*;

public class HrmLogin extends BaseClass  {
	
	@BeforeMethod
	public void initilization()
	{
		init();
		getUrl();
	}
	
	@Test(dataProvider = "passdata", dataProviderClass = GetDataFromExcel.class)	
	public void Login(String getUsername, String getPassword) 
	{	
		LoginPage login = new LoginPage(driver);		
		login.userName(getUsername);
		login.password(getPassword);
		login.clickButton();
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@Test
	public void checkLinks()
	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
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
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
