package com.hsat.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebUtility {
	
	//enter text in a text box
	public Exception enterTextUsingXPath(String textVal, String xpath,WebDriver driver){
		try{
				driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).sendKeys(textVal);
		return null;
	}
	
	public Exception enterTextUsingID(String textVal, String id,WebDriver driver){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.id(id)).sendKeys(textVal);
		return null;
	}
	
	public Exception enterTextUsingName(String textVal, String name,WebDriver driver){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.name(name)).sendKeys(textVal);
		return null;
	}
	
	public Exception enterTextUsingClassName(String textVal, String className,WebDriver driver){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.className(className)).sendKeys(textVal);
		return null;
	}
		
	//select value from drop down
	public Exception selectValueFromDropdownUsingXpath(String xpath,String selectValue,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByValue(selectValue);
		return null;
	}
	
	public Exception selectValueFromDropdownUsingXpath(String xpath,int id,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByIndex(id);
		return null;
	}
	
	public Exception selectByVisibleTextfromDropDownUsingXpath(String xpath,String visibleText,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByVisibleText(visibleText);
		return null;
	}
	
	//checking or unchecking a checkbox	
	public Exception selectCheckboxUsingXpath(String xpath,WebDriver driver,Boolean selectCheckBox){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.xpath(xpath)).isSelected()){
			driver.findElement(By.xpath(xpath)).click();
		}
		return null;
	}
	
	public Exception selectCheckboxUsingID(String id,WebDriver driver,Boolean selectCheckBox){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.id(id)).isSelected()){
			driver.findElement(By.id(id)).click();
		}
		return null;
	}
	
	public Exception selectCheckboxUsingClassName(String className,WebDriver driver,Boolean selectCheckBox){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.className(className)).isSelected()){
			driver.findElement(By.className(className)).click();
		}
		return null;
	}
	
	public Exception selectCheckboxUsingName(String name,WebDriver driver,Boolean selectCheckBox){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		if (selectCheckBox && !driver.findElement(By.name(name)).isSelected()){
			driver.findElement(By.name(name)).click();
		}
		return null;
	}

	//click button 
	public Exception clickButtonUsingXpath(String xpath,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).click();
		return null;
	}
	
	public Exception clickButtonUsingID(String id,WebDriver driver){
		try{
			driver.findElement(By.id(id));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.id(id)).click();
		return null;
	}
	
	public Exception clickButtonUsingClassName(String className,WebDriver driver){
		try{
			driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.className(className)).click();
		return null;
	}
	
	public Exception clickButtonUsingName(String name,WebDriver driver){
		try{
			driver.findElement(By.name(name));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.name(name)).click();
		return null;
	}
	
	//click link
	public Exception clickLinkUsingXpath(String xpath,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.xpath(xpath)).click();
		return null;
	}

	public Exception clickLinkUsingLinkText(String linkText,WebDriver driver){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.linkText(linkText)).click();
		return null;
	}

	public Exception clickLinkUsingPartialText(String partialText,WebDriver driver){
		try{
			driver.findElement(By.partialLinkText(partialText));
		}catch(NoSuchElementException e){
			return e;
		}
		driver.findElement(By.partialLinkText(partialText)).click();
		return null;
	}
	
	
	//select from List
	public Exception selectListItemUsingValue(String xpath,String itemName,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
	 	listbox.selectByValue(itemName);
		return null;
	}

	public Exception selectListItemUsingIndex(String xpath,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
		listbox.selectByIndex(0);
		return null;
	}

	public Exception selectListItemUsingText(String xpath,String text,WebDriver driver){
		try{
			driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			return e;
		}
		Select listbox = new Select(driver.findElement(By.xpath(xpath)));
		listbox.selectByVisibleText(text);
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
		}
		return null;
	}
	
	//click image
	//click webelement
	//click table
	//click calander
}

