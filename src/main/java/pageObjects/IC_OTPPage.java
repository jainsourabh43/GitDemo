package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IC_OTPPage {

	public WebDriver driver;
	
	By AuthReqRadioBtn=By.xpath("//input[@type='radio' ][2]");
	By ContinueBtn=By.id("continueButton");
	
	public IC_OTPPage(WebDriver driver) {
		this.driver=driver;

	}

	public WebElement AuthReqRadioBtn(){
		return driver.findElement(AuthReqRadioBtn);
	}
	
	public WebElement continueButton(){
		return driver.findElement(ContinueBtn);
	}
}
