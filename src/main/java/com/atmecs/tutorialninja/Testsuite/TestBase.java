package com.atmecs.tutorialninja.Testsuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.atmecs.tutorialsninja.utils.ExtentReport;
import com.atmecs.tutorialsninja.utils.LogReport;
import com.atmecs.tutorialsninja.utils.ProjectBaseConstantPaths;
import com.atmecs.tutorialsninja.utils.ReadLocatorsFile;

public class TestBase extends ExtentReport{
    LogReport log=new LogReport();
	public WebDriver driver;
	String browsername;
     //String url;
	
	@BeforeTest
	public void invokeBrowser() throws IOException {
		//browsername=ReadLocatorsFile.readPropertiesFile("Browser", ProjectBaseConstantPaths.CONFIG_FILE);
		//url=ReadLocatorsFile.readPropertiesFile("url", ProjectBaseConstantPaths.CONFIG_FILE);
		browsername=System.getenv("browserName");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectBaseConstantPaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser started...");

		}else if(browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ProjectBaseConstantPaths.IE_FILE);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			driver = new InternetExplorerDriver(ieCaps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("IE browser started...");
//to open the given url and maximize the window
		//driver.get(url);
		driver.manage().window().maximize();
		log.info("Application is open...");
	}
}
}