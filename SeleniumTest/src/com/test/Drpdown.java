package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Drpdown {
	
		static String url="";

		public void dropdown() 
		{
			String url="https://www.webfx.com/blog/web-design/50-examples-of-drop-down-navigation-menus-in-web-designs/"; 
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			//for drop down
			System.out.println("title of page is: " + driver.getTitle());
			try
			{
				Select drpCountry = new Select(driver.findElement(By.name("categories")));
				drpCountry.selectByVisibleText("SEARCH");
				Thread.sleep(5000);
				drpCountry.deselectByVisibleText("SEARCH");
				Thread.sleep(5000);
				drpCountry.selectByIndex(4);
				Thread.sleep(5000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
