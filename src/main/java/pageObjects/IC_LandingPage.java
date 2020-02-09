package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IC_LandingPage {
public WebDriver driver;
	
	By Email=By.name("loginfmt");
	By NextBtn=By.xpath("//input[@type='submit']");
	public IC_LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	
	public WebElement nextBtn() {
		return driver.findElement(NextBtn);
	}
}
