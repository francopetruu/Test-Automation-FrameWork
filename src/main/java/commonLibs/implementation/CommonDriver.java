package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
	
	private WebDriver driver; 
	
	//implicit wait
	private int pageLoadTimeout; 
	
	private int elementDetectionTimeout; 

	
	public CommonDriver(String browserType) throws Exception {
		
		pageLoadTimeout = 10;
		elementDetectionTimeout = 10;
		
		if (browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserType.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdrive.edge.driver", ".src/main/resources/Edge/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid browser type" + browserType);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	public void navigateToUrl(String url) {
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}


	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	
	public void quitBrowser() {
		driver.quit();
		
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
}
