package com.hsat.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoadDriver {
	public static Properties pro;
	public static WebDriver driver;
	
	public LoadDriver(){
		File src = new File("./ConfigurationFiles/drivers.property");
		try {
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();			
			pro.load(fs);
			
		} catch (Exception e) {
			System.out.println("Error message is -- "+ e.getMessage());
		}//catch block ends here
		
	}
	
	//This method returns the Firefox driver
	public WebDriver getGeckoDriver(){
		String geckoDriver = pro.getProperty("FireFoxGeckoDriver");
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		driver = new FirefoxDriver();
		return driver;
	}
	
	//This method returns a ChromeDriver
	public WebDriver getChromeDriver(){
		String chromeDriver = pro.getProperty("ChromeDriver");
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		return driver;
	}
	
	//This method returns an IEDriver
	public WebDriver getIEDriver(){
		String ieDriver = pro.getProperty("IEDriver");
		System.setProperty("webdriver.ie.driver", ieDriver);
		driver = new InternetExplorerDriver();
		return driver;
	}
}
