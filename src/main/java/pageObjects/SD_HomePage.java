package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SD_HomePage {
public WebDriver driver;
	
	By SD_NewIssueBtn=By.xpath("//button[@class='btn btn-link btn-xs'][contains(text(),'New Issue')]");
	
	
	public SD_HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement SD_NewIssueBtn() {
		return driver.findElement(SD_NewIssueBtn);
	}
	
}
