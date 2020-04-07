package com.testSalesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableHandling extends ChromeDriver1{
	
	public String DynamicWebTableHandling(String name) throws InterruptedException {
		
		Thread.sleep(3000);
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/thead/tr/th"));
		int colCount=cols.size();
		System.out.println(colCount);
	
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr"));
		int rowsCount=rows.size();
		System.out.println(rowsCount);
		
		for(int i=1;i<=rowsCount;i++) {
			
				String value=driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/th")).getText();
				//System.out.println(value);
				if(value.contains(name)) 
				{
					System.out.println("Contact Person name : "+value);
					for(int j=3;j<colCount;j++) {
					String colValue=driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					if(!(colValue.isBlank()))
						System.out.println(colValue);
					}
					break;
					}
			}
	
		
		return name;
		
	}

}
