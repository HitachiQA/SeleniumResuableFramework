package com.hsat.utilities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoggerUtility {

	public static String filename = "log.txt";
	public static String filePath = System.getProperty("user.dir");
	public static File file = new File(filePath + "\\" + filename);
	ExtentReports report;
	ExtentTest logger;
	Logger log4j;
	
public LoggerUtility(){	
		
		try {	
				if (!file.exists()) {
		            file.createNewFile();
		            System.out.println("Empty Log File is created");
		            //return out;		            
		        } else {
		        	PrintWriter writer = new PrintWriter(file);
		        	writer.close();
		        	System.out.println("Log File already exist, contents are cleared.");
			    }
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
	}
	
	public File returnFile(){
		return file;
	}
	
	public void clearFiles(){
		try {
			FileUtils.cleanDirectory(new File("./Screenshots/"));
		} catch (IOException e) {
			System.out.println("Unable to clear files");
			e.printStackTrace();
		}
	}
	
	public String captureScreenshot(WebDriver driver,String ssName){
		String dest = "./Screenshots/"+ssName+".png";		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);			
			FileUtils.copyFile(source, new File(dest));
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Exception while taking Screenshot");
			e.printStackTrace();
			return null;
		}
		return dest;
		
	}
	
	
	public void ExtentReport_init_Report(String className){
		String fname = new SimpleDateFormat("yyyyMMddHHmss").format(new Date())+className+"_Report";
		report = new ExtentReports("C:\\Report\\"+fname+".html");
		logger= report.startTest(className);
		//System.out.println("logger created is "+logger);
	}
	
	public void ExtentReport_info(String message,WebDriver driver,String ssName){
		String ssPath = captureScreenshot(driver, ssName);
		String image = logger.addScreenCapture(ssPath);
		logger.log(LogStatus.INFO,message,image);
	}
	
	public void ExtentReport_pass(String message,WebDriver driver,String ssName){
		String ssPath = captureScreenshot(driver, ssName);
		String image = logger.addScreenCapture(ssPath);
		logger.log(LogStatus.PASS,message,image);		
	}
	
	public void ExtentReport_fail(String message,WebDriver driver,String ssName){
		String ssPath = captureScreenshot(driver, ssName);
		String image = logger.addScreenCapture(ssPath);
		logger.log(LogStatus.FAIL,message,image);
	}
	
	public void ExtentReport_endTest() {
		try {
			report.endTest(logger);
			report.flush();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void log4j_intialize(String className){		
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		log4j = Logger.getLogger(className);		
	}
	
	public void log4j_loginfo(String message){		
		log4j.info(message);
	}
	
}
