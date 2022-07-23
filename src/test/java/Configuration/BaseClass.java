package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	public void init() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public void getUrl()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
}
