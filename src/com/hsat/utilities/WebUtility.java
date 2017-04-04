package com.hsat.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebUtility {
	
	public static BufferedWriter out;
	public Boolean logFile = false;
	
	
	//constructor method where log file is opened to write
	public WebUtility(){
		LoggerUtility f = new LoggerUtility();
		File file = f.returnFile();	
		FileWriter fileWriter;
		
		try{
			if (file.exists()){
				fileWriter = new FileWriter(file);
				out = new BufferedWriter(fileWriter);
				logFile = true;
				System.out.println("Log file is accessible to write");
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
			System.out.println("Log file is not accessible to write");
		}
	}
	
	public void log(String message){
		if(logFile){
			try {
				out.write(message);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	//enter text in a text box
	public Exception enterTextUsingXPath(String textVal, String xpath,WebDriver driver,String field) {
		try{
				driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).sendKeys(textVal);
		log("Entered "+textVal+" in : "+ field);
		return null;
	}
	
	public Exception enterTextUsingID(String textVal, String id,WebDriver driver,String field){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.id(id)).sendKeys(textVal);
		log("Entered "+textVal+" in : "+ field);
		return null;
	}
	
	public Exception enterTextUsingName(String textVal, String name,WebDriver driver,String field){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.name(name)).sendKeys(textVal);
		log("Entered "+textVal+" in : "+ field);
		return null;
	}
	
	public Exception enterTextUsingClassName(String textVal, String className,WebDriver driver,String field){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.className(className)).sendKeys(textVal);
		log("Entered "+textVal+" in : "+ field);
		return null;
	}
		
	//select value from drop down
	public Exception selectValueFromDropdownUsingXpath(String xpath,String selectValue,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByValue(selectValue);
		log("Selected "+selectValue+" from drop down : "+ field);
		return null;
	}
	
	public Exception selectValueFromDropdownUsingXpath(String xpath,int id,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByIndex(id);
		log("Selected "+id+" from drop down : "+ field);
		return null;
	}
	
	public Exception selectByVisibleTextfromDropDownUsingXpath(String xpath,String visibleText,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByVisibleText(visibleText);
		log("Selected "+visibleText+" from drop down : "+ field);
		return null;
	}
	
	//checking or unchecking a checkbox	
	public Exception selectCheckboxUsingXpath(String xpath,WebDriver driver,Boolean selectCheckBox,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.xpath(xpath)).isSelected()){
			driver.findElement(By.xpath(xpath)).click();
			log("Checked/Unchecked based on value "+selectCheckBox+" from checkbox : "+ field);
		}
		return null;
	}
	
	public Exception selectCheckboxUsingID(String id,WebDriver driver,Boolean selectCheckBox,String field){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.id(id)).isSelected()){
			driver.findElement(By.id(id)).click();
			log("Checked/Unchecked based on value "+selectCheckBox+" from checkbox : "+ field);
		}
		return null;
	}
	
	public Exception selectCheckboxUsingClassName(String className,WebDriver driver,Boolean selectCheckBox,String field){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.className(className)).isSelected()){
			driver.findElement(By.className(className)).click();
			log("Checked/Unchecked based on value "+selectCheckBox+" from checkbox : "+ field);
		}
		return null;
	}
	
	public Exception selectCheckboxUsingName(String name,WebDriver driver,Boolean selectCheckBox,String field){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.name(name)).isSelected()){
			driver.findElement(By.name(name)).click();
			log("Checked/Unchecked based on value "+selectCheckBox+" from checkbox : "+ field);
		}
		return null;
	}

	//click button 
	public Exception clickButtonUsingXpath(String xpath,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).click();
		log("Clicked on button - "+ field);
		return null;
	}
	
	public Exception clickButtonUsingID(String id,WebDriver driver,String field){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.id(id)).click();
		log("Clicked on button - "+ field);
		return null;
	}
	
	public Exception clickButtonUsingClassName(String className,WebDriver driver,String field){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.className(className)).click();
		log("Clicked on button - "+ field);
		return null;
	}
	
	public Exception clickButtonUsingName(String name,WebDriver driver,String field){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.name(name)).click();
		log("Clicked on button - "+ field);
		return null;
	}
	
	//click link
	public Exception clickLinkUsingXpath(String xpath,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).click();
		log("Clicked on link - "+ field);
		return null;
	}

	public Exception clickLinkUsingLinkText(String linkText,WebDriver driver,String field){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.linkText(linkText)).click();
		log("Clicked on link - "+ field);
		return null;
	}

	public Exception clickLinkUsingPartialText(String partialText,WebDriver driver,String field){
		try{
			driver.findElement(By.partialLinkText(partialText));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.partialLinkText(partialText)).click();
		log("Clicked on link - "+ field);
		return null;
	}
	
	
	//select from List
	public Exception selectListItemUsingValue(String xpath,String itemName,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
	 	listbox.selectByValue(itemName);
	 	log("Selected value "+itemName+" from list box : "+ field);
		return null;
	}

	public Exception selectListItemUsingIndex(String xpath,int id,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
		listbox.selectByIndex(id);
		log("Selected value by index"+id+" from list box : "+ field);
		return null;
	}

	public Exception selectListItemUsingText(String xpath,String text,WebDriver driver,String field){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
		listbox.selectByVisibleText(text);
		log("Selected value by visible text "+text+" from list box : "+ field);
		return null;
	}

	
	//navigate tree structure
	//tree path ~ full path of the node till the point of navigation separated with comma
	//treeSymbolAbsPath ~ the plus or other tree symbol abs path from the root node
	public Exception nabigateToNode(String treePath,WebDriver driver,String treeSymbolAbsPath){
		String nodes[] = treePath.split(",");
		for(String node : nodes){
			try{
				driver.findElement(By.xpath("//*[contains(text(),"+node+")]/preceding-sibling::"+treeSymbolAbsPath));
			}catch(NoSuchElementException e){
				return e;
			}
			driver.findElement(By.xpath("//*[contains(text(),"+node+")]/preceding-sibling::"+treeSymbolAbsPath)).click();
			log("Expanding tree element : "+node);
		}
		return null;
	}
	
	//click image
	//click webelement
	//click table
	//click calander
}

