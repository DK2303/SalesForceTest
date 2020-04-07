package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkTest {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","F:\\Chrome Driver\\chromedriver.exe");					
	        WebDriver driver = new ChromeDriver();					
	        String url="https://www.webfx.com/blog/web-design/50-examples-of-drop-down-navigation-menus-in-web-designs/";		
	        driver.get(url);					
	        
	        //link text
	        /*driver.findElement(By.linkText("6) Find Element Selenium")).click();	
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.findElement(By.partialLinkText("Nex")).click();*/
	        
	        
	        //for drop down
	        System.out.println("title of page is: " + driver.getTitle());
	        try {
	        Select drpCountry = new Select(driver.findElement(By.name("categories")));
			drpCountry.selectByVisibleText("SEARCH");
			Thread.sleep(5000);
			drpCountry.deselectByVisibleText("SEARCH");
			Thread.sleep(5000);
			drpCountry.selectByIndex(4);
			Thread.sleep(5000);
	        }
	        catch(InterruptedException e) {
	        	e.printStackTrace();
	       }
	        }
		}



