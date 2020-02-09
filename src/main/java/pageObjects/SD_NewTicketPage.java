package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SD_NewTicketPage {
public WebDriver driver;
	
	By CurrentLocation=By.id("WorkOrder_Fields_UDF_CHAR3");
	By WorkStationNo=By.id("WorkOrder_Fields_UDF_CHAR2");
	By PHIUser=By.id("WorkOrder_Fields_UDF_CHAR12");
	By Dept=By.id("WorkOrder_Fields_UDF_CHAR1");
	By ProjectName=By.id("WorkOrder_Fields_UDF_CHAR13");
	By Category=By.id("CATEGORYID");
	By Urgency=By.id("URGENCYID");
	By SubCategory=By.id("SUBCATEGORYID");
	By Impact=By.id("IMPACTID");
	By Item=By.id("ITEMID");
	By Subject=By.id("subject");
	By DescritptionFrame=By.xpath("//iframe[1]");
	//By Description=By.xpath("//body[@class='ze_body']");
	By Description=By.id("HTMLDesc");
	By AddReqBtn=By.xpath("//input[@id='addWOButton']");
	
	
	public SD_NewTicketPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement CurrentLocation() {
		return driver.findElement(CurrentLocation);
	}
	
	public WebElement WorkStationNo() {
		return driver.findElement(WorkStationNo);
	}
	
	public WebElement PHIUser() {
		return driver.findElement(PHIUser);
	}
	
	public WebElement Dept() {
		return driver.findElement(Dept);
	}
	
	public WebElement ProjectName() {
		return driver.findElement(ProjectName);
	}
	
	public WebElement Category() {
		return driver.findElement(Category);
	}
	
	public WebElement Urgency() {
		return driver.findElement(Urgency);
	}
	
	public WebElement SubCategory() {
		return driver.findElement(SubCategory);
	}
	
	public WebElement Impact() {
		return driver.findElement(Impact);
	}
	
	public WebElement Item() {
		return driver.findElement(Item);
	}
	
	public WebElement Subject() {
		return driver.findElement(Subject);
	}
	
	public WebElement DescriptionFrame() {
		return driver.findElement(DescritptionFrame);
	}
	public WebElement Description() {
		return driver.findElement(Description);
	}
	
	public WebElement AddReqBtn() {
		return driver.findElement(AddReqBtn);
	}


}
