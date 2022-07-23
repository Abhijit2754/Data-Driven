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
	
	LoginPage login;
	
	@BeforeMethod
	public void initilization()
	{
		init();
		getUrl();
	}
	
	@Test(dataProvider = "passdata", dataProviderClass = GetDataFromExcel.class)	
	public void Login(String getUsername, String getPassword) 
	{	
		login = new LoginPage(driver);		
		login.userName(getUsername);
		login.password(getPassword);
		login.clickButton();
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@Test
	public void checkLinks()
	{
		login = new LoginPage(driver);
		login.checkLink();
	}
	
	@Test
	public void check_forget_click_working_or_nt()
	{
		login.checkLinktest();
	}	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
