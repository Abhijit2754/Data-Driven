package TestCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Configuration.BaseClass;
import ObjectMethods.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HrmLogin extends BaseClass  {
	
	@BeforeMethod
	public void initilization()
	{
		init();
		getUrl();
	}
	
	@Test(dataProvider = "passdata")	
	public void Login(String getUsername, String getPassword) 
	{	
		LoginPage login = new LoginPage(driver);		
		login.userName(getUsername);
		login.password(getPassword);
		login.clickButton();
		
		
	}
	
	@DataProvider(name="passdata")
	public String[][] datapass()
	{
		String[][] data = new String[5][2];
		
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "password";
		
		data[2][0] = "Samamsa";
		data[2][1] = "daasd132";
		
		data[3][0] = "Fasdas";
		data[3][1] = "asdsad";
		
		data[4][0] = "SAFFdf";
		data[4][1] = "cdsdcsdcds";
		
		
		return data;
	}
}
