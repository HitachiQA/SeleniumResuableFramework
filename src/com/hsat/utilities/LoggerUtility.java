package com.hsat.utilities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoggerUtility {

	public static String filename = "log.txt";
	public static String filePath = System.getProperty("user.dir");
	public static File file = new File(filePath + "\\" + filename);
	ExtentReports logger;
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
	

	public void ExtentReport_init_Report(String className){
		logger = ExtentReports.get(className);
		String fname = new SimpleDateFormat("yyyyMMddHHm").format(new Date())+className+"_Report";
		logger.init("C:\\Report\\"+fname+".html",true);
		logger.startTest(className);		
	}
	
	public void ExtentReport_info(String message){
		logger.log(LogStatus.INFO, message);		
	}
	
	public void ExtentReport_pass(String message){
		logger.log(LogStatus.PASS, message);		
	}
	
	public void ExtentReport_endTest(){
		logger.endTest();
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
