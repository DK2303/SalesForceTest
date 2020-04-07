package com.seleniumTestPrograme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverTest extends ChromeDriverTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeDriverTest obj=new EdgeDriverTest();
		//obj.geckoTest();
		//obj.chromeTest();
		//obj.edgeTest();
	}
	
	public void edgeTest() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium Project\\Edge Driver\\MicrosoftWebDriver.exe");
		
		driver=new EdgeDriver();
		
		driver.get("https://www.facebook.com/login.php");
		
		driver.manage().window().maximize();
		
		String appTitle=driver.getTitle();
		
		String expTitle="Log in to Facebook | Facebook";
		
		if(appTitle.equals(expTitle))
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		//driver2.manage().window().setPosition(new Point(1200,800));
		
		driver.findElement(By.name("email")).sendKeys("dinesh2303@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("pass")).sendKeys("password");
		Thread.sleep(2000);
		
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);

		driver.close();

	}

}
