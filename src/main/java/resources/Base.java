package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		//instantiating properties class to get browser value on run time from properties file
		prop=new Properties();
		FileInputStream fis;
		fis=new FileInputStream("C:\\Users\\Sourabh Jain\\eclipse-workspace\\InterCT\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			//firefox driver code
		}
		
		else if(browserName.equals("IE")) {
			//IE driver code
		}
		
		//Setting implicit wait for all the elements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	
}
