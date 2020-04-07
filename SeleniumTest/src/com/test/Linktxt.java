package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Linktxt {

	   static String url="https://www.guru99.com/select-option-dropdown-selenium-webdriver.html";

		public void linktxt() 
		{
			WebDriver driver = new ChromeDriver();
			driver.get(url);					
			try {
				driver.findElement(By.linkText("6) Find Element Selenium")).click();	
				Thread.sleep(5000);
				driver.findElement(By.partialLinkText("Nex")).click();
			} 
			catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
