package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SD_LoginPage {
	
public WebDriver driver;
	
	By SD_UserName=By.id("username");
	By SD_Password=By.id("password");
	By SD_LoginBtn=By.cssSelector("button#loginSDPage");
	
	public SD_LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement SD_UserName() {
		return driver.findElement(SD_UserName);
	}
	
	public WebElement SD_Password() {
		return driver.findElement(SD_Password);
	}
	
	public WebElement SD_LoginBtn() {
		return driver.findElement(SD_LoginBtn);
	}
	
	

}
