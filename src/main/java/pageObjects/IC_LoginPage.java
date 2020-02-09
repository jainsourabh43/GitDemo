package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IC_LoginPage {
	public WebDriver driver;
	
	By Username=By.cssSelector("input#userNameInput");
	By Password=By.cssSelector("input#passwordInput");
	By SignInBtn=By.xpath("//span[@id='submitButton']");
	
	public IC_LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUserName() {
		return driver.findElement(Username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(Password);
	}
	
	public WebElement getSignIn() {
		return driver.findElement(SignInBtn);
	}
	
	

}
