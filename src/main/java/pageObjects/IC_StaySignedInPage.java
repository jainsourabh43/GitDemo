package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IC_StaySignedInPage {
	public WebDriver driver;
	
	public IC_StaySignedInPage(WebDriver driver) {
		this.driver=driver;
	}
	By YesBtn=By.xpath("//input[@type='submit']");
	
	

	public WebElement yesBtn(){
		return driver.findElement(YesBtn);
	}

}
