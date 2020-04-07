package com.seleniumTestPrograme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest extends GeckoDriver{

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriverTest obj=new ChromeDriverTest();
		obj.chromeTest();
	}
	
	public void chromeTest() throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Project\\Chrome Driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		driver.manage().window().maximize();
		
		String appTitle=driver.getTitle();

		String expTitle="Gmail";
		
		if(appTitle.equals(expTitle))
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		/* WebElement username=driver1.findElement(By.cssSelector("input#username")); 
		  WebElement password=driver1.findElement(By.xpath("//*[@id=\"password\"]")); 
		  WebElement login=driver1.findElement(By.xpath("//*[@id=\"Login\"]")); 
		  username.sendKeys("example@gmail.com"); password.sendKeys("password"); 
		  login.click();*/

		
		//driver1.manage().window().setPosition(new Point(-2000, 0));
		
		driver.findElement(By.id("identifierId")).sendKeys("dineshkrishna2303@gmail.com");
		driver.findElement(By.className("CwaK9")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("password")).sendKeys("Dinesh132");
		Thread.sleep(4000);
		driver.findElement(By.className("CwaK9")).click();
		
		driver.close();
		//System.exit(0);

	}

}
