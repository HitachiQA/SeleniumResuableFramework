package com.hsat.utilities;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerUtility {

	public static String filename = "log.txt";
	public static String filePath = System.getProperty("user.dir");
	public static File file = new File(filePath + "\\" + filename);
	
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

}
