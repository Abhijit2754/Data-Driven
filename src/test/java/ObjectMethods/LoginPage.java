package ObjectMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName = By.id("txtUsername");
	By password = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	
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
}
