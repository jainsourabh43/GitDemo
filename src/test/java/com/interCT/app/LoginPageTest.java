package com.interCT.app;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.IC_HomePage;
import pageObjects.IC_LandingPage;
import pageObjects.IC_LoginPage;
import pageObjects.IC_OTPPage;
import pageObjects.SD_HomePage;
import pageObjects.SD_LoginPage;
import pageObjects.SD_NewTicketPage;
import pageObjects.IC_StaySignedInPage;
import resources.Base;

public class LoginPageTest extends Base {

	@Test(priority=0)
	public void OpenURL() throws IOException {
		driver = initializeDriver();
		// hitting URL
		driver.get(prop.getProperty("url"));
	}

	// login Page
	@Test(priority = 1)
	public void basePageNavigation() throws IOException, InterruptedException {
	
		// In Landing Page- Entering user Email ID and Clicking on Next button using submit method
		IC_LandingPage lp = new IC_LandingPage(driver);
		lp.getEmail().sendKeys(prop.getProperty("ICT_UserName"));
		lp.nextBtn().click();

		// In Login Page- Entering Password and clicking on SignIn button
		IC_LoginPage l = new IC_LoginPage(driver);
		l.getPassword().sendKeys(prop.getProperty("ICT_Password"));
		l.getSignIn().click();

		
		// OTP Page-Clicking on Continue button
		IC_OTPPage OTP = new IC_OTPPage(driver);
		OTP.AuthReqRadioBtn().click();
		OTP.continueButton().click();
		
		
		// In StaySignedIn Page- Click on Yes button
		IC_StaySignedInPage SSINP = new IC_StaySignedInPage(driver);
		SSINP.yesBtn().click();
		Thread.sleep(5000);

		
		// InterCT Home Page: Verify all the header links of InterCT Home Page
		String ExpectedTabs[]= {"Home", "Work", "Accelerators","CT Teams","CTzen Matters", "My Activities"};
		IC_HomePage HP = new IC_HomePage(driver);
		
		for(int i=0;i<HP.HeaderTabs().size();i++){
			try 
			{
			Assert.assertEquals(ExpectedTabs[i], HP.HeaderTabs().get(i).getText());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Header tabs in InterCT Home page are not as expected");
			}
		
		}
		
		//Verifying user display name
		try 
		{
			Assert.assertTrue(HP.UserDisplayName().getText().equalsIgnoreCase("Sourabh Jain"));
		}
		catch(Throwable e)
		{
			System.out.println("User display name in InterCT Home page is not as an expected");
		}
		// Click on Log a Ticket link in InterCT Home Page
		HP.LogTicketLink().click();

	}

	@Test(priority = 2)
	public void serviceDeskFlow() {
		// To switch to Service Desk Login window
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		it.next();
		String SDWindow = it.next();
		driver.switchTo().window(SDWindow);

		// In Service Desk Login Page-Entering Username and Password and clicking on Log in button
		SD_LoginPage SDL = new SD_LoginPage(driver);
		SDL.SD_UserName().sendKeys(prop.getProperty("SD_UserName"));
		SDL.SD_Password().sendKeys(prop.getProperty("SD_Password"));
		SDL.SD_LoginBtn().click();

		//In Service Desk Home Page Clicking on New Issue button to create new ticket
		SD_HomePage SDH=new SD_HomePage(driver);
		SDH.SD_NewIssueBtn().click();
		
		
		//In Service Desk New Ticket Page--Adding all the details in the fields
		SD_NewTicketPage SDNT=new SD_NewTicketPage(driver);
		
		Select CurrentLocation=new Select(SDNT.CurrentLocation());
		CurrentLocation.selectByVisibleText("MS1, Building No.14, 6th floor");
		
		SDNT.WorkStationNo().sendKeys("G8-A");
		
		Select PHIUser=new Select(SDNT.PHIUser());
		PHIUser.selectByIndex(1);
		
		Select Dept=new Select(SDNT.Dept());
		Dept.selectByVisibleText("IT - Infra");
		
		SDNT.ProjectName().sendKeys("Automation Testing Practice");
		
		Select Category=new Select(SDNT.Category());
		Category.selectByIndex(7);
		
		Select Urgency=new Select(SDNT.Urgency());
		Urgency.selectByIndex(4);
		
		Select SubCategory=new Select(SDNT.SubCategory());
		SubCategory.selectByValue("1501");
		
		Select Impact=new Select(SDNT.Impact());
		Impact.selectByValue("301");
		
		/*Select Item=new Select(SDNT.Item());
		Item.selectByVisibleText("Installation");*/
		
		SDNT.Subject().sendKeys("Raising Ticket",Keys.TAB,"Desc");
		
		SDNT.AddReqBtn().click();
		
		//Grabbing the mandatory validation message from Alert Pop up and verifying if it is correct
		String ValidationMessage=driver.switchTo().alert().getText();
		try
		{
		Assert.assertTrue(ValidationMessage.contains("Item1"));
		}
		catch(Throwable e)
		{
			System.out.println("Validation message for mandatory field is not as expected ");
		}
		
		driver.switchTo().alert().accept();
		
		
		

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	// This code is for parameterization
	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data type test should run
		// column stands for how many values in each test
		Object[][] data = new Object[1][2];

		data[0][0] = "sourabh.jain@citiustech.com";
		data[0][1] = "Citius@123456789";

		return data;

	}
	
	@DataProvider
	public Object[][] getData1() {
		// Row stands for how many different data type test should run
		// column stands for how many values in each test
		Object[][] data = new Object[1][2];

		data[0][0] = "sourabhj";
		data[0][1] = "Citius@123456789";

		return data;

	}

}
