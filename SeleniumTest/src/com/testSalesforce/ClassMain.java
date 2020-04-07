package com.testSalesforce;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ClassMain extends ClassicTest {
		public String getPropValues(String key) throws IOException {
			Properties prop = new Properties();
			FileReader reader=new FileReader("F:\\Eclipse\\Selenium\\src\\defalut_package\\gprp.properties");
			prop.load(reader);  
	        return prop.getProperty(key);
		}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			testing();
		}

	}

