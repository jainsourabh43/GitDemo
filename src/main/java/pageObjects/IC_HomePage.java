package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IC_HomePage {
	public WebDriver driver;

	By UserName = By.xpath("//a[@class='ms-core-menu-root']");
	By LogTicketLink = By.xpath("(//a[@ng-click='open(link)'])[1]");
	By UserDisplayName = By.id("zz4_Menu");
	By HeaderTabs = By.xpath("(//ul[@id='myNavbar']/li/a)");

	public IC_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement UserName() {
		return driver.findElement(UserName);
	}

	public WebElement LogTicketLink() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LogTicketLink));
		return driver.findElement(LogTicketLink);
	}

	public WebElement UserDisplayName() {
		return driver.findElement(UserDisplayName);
	}

	public List<WebElement> HeaderTabs() {
		return driver.findElements(HeaderTabs);
	}

}
