package com.testSalesforce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


public class InputFileReader{

	public String getPropertyValue(String key) throws IOException {
		
			Properties prop = new Properties();
			FileReader reader=new FileReader(System.getProperty("user.dir")+"\\config.properties");
			prop.load(reader);  
	        return prop.getProperty(key);
		
	}
	
	public String getXmlValue(String key) throws DocumentException{
		
		String object;
		//File xmlReader=new File("C:\\Users\\whirldata-sa\\WorkSpace-Selenium\\SeleniumTest\\src\\com\\testSalesforce\\Test Repository\\Data.xml");
		File inputFile = new File(System.getProperty("user.dir") +"\\data.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		object = document.selectSingleNode("//menu/"+key).getText();
		System.out.println(object);
		return object;		
	}
	
	/*DocumentBuilderFactory bdFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = bdFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(xmlReader);*/

	
}