package com.suite.base;
/**
 * @author gaurav.wani
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.suite.utility.ExcelLibrary;
import com.suite.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
//	public static WebDriver driver;
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	
	@BeforeSuite(groups = { "Smoke", "Regression","Sanity" })
	public void LogInitializer() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	public Base(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/suite/configuration"
					+ "/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	
	public static void Initialization(String browserName) throws InterruptedException {
	
		if(browserName.equals("chrome")) {
			
			ChromeOptions option = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
		
			
			String downloadFilepath = System.getProperty("user.home") + "\\Downloads";
			//contentSettings.put("geolocation", 1);
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", downloadFilepath);
			prefs.put("download.prompt_for_download", false);
			option.setExperimentalOption("prefs", prefs);
			option.addArguments("enable-automation");
						
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(option));
			
		}else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		getDriver().get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
	
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Regression","Sanity" })
	public void setup(String browser) throws InterruptedException {
		Initialization(browser);
	}
	
	@AfterMethod(groups = { "Smoke", "Regression","Sanity" })
	public void closer() {
		/*
		 * HomePage homepage = new HomePage(); homepage.logout(); LoginPage loginpage =
		 * new LoginPage(); loginpage.validatePageLogo();
		 */
		getDriver().quit();
	}

	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}
