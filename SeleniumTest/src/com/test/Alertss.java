package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertss {

		static String url="file://C:/Users//Aravind//Desktop//index.html";

		public void alerts() 
		{
				
			//Alerts
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			WebElement click=driver.findElement(By.id("tb"));
			click.click();
			
			Alert alert = driver.switchTo().alert();		

			// Capturing alert message.    
			String alertMessage= driver.switchTo().alert().getText();		

			// Displaying alert message		
			System.out.println(alertMessage);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			alert.accept();
		}

	}

