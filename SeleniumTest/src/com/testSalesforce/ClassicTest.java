package com.testSalesforce;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Properties;	
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassicTest {
		
		public static void testing() throws IOException
		{
			try {
				
			
			//Chrome Driver 	
			System.setProperty("webdriver.chrome.driver","F:\\Chrome Driver\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			
			
			//Notification handling
			Map<String, Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			//1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs",prefs);
			
			ClassMain obj=new ClassMain();
			WebDriver driver=new ChromeDriver(options);
			//Title check
					String actualtitle = " ";
					String proxytitle = "Login | Salesforce";
					driver.get(obj.getPropValues("url"));
					driver.manage().window().maximize();
					actualtitle=driver.getTitle();
					if(actualtitle.contentEquals(proxytitle))
					{
						System.out.println("test passes");
					}
					else
					{
						System.out.println("failed");
					}
					
			//Salesforce login
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys(obj.getPropValues("uname"));
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(obj.getPropValues("pw"));
			driver.findElement(By.cssSelector(obj.getPropValues("loginbutton"))).click();
			WebDriverWait wait=new WebDriverWait(driver, 50);
			
			//Account Creation
					driver.findElement(By.id("Account_Tab")).click();
					Thread.sleep(10000);
					driver.findElement(By.name("new")).click();
					Thread.sleep(10000);
					driver.findElement(By.id("acc2")).sendKeys(obj.getPropValues("namevalue"));
					Select ownership = new Select(driver.findElement(By.name("acc14")));
					ownership.selectByVisibleText(obj.getPropValues("dropdownvalue"));
					Select Rating = new Select(driver.findElement(By.name("acc9")));
					Rating.selectByIndex(1);
					Select value = new Select(driver.findElement(By.name("acc7")));
					value.selectByValue(obj.getPropValues("dropdown3"));
					driver.findElement(By.id("acc3_lkwgt")).click();
					
					//Search
					String MainWindow=driver.getWindowHandle();	
					System.out.println("Mainwindow"+MainWindow);
					Set<String> s1=driver.getWindowHandles();		
					System.out.println("size"+s1.size());
					System.out.println(s1);
				    Iterator<String> i1=s1.iterator();		
				    while(i1.hasNext())			
				        {		
				        	System.out.println(i1);
				            String ChildWindow=i1.next();	
				            System.out.println(ChildWindow);
				            		
				            if(!(MainWindow.equalsIgnoreCase(ChildWindow)))			
				            {    		
				            	System.out.println("Loop"+ChildWindow);
				            	driver.switchTo().window(ChildWindow);
				            	actualtitle=driver.getTitle();
				            	driver.switchTo().frame("resultsFrame");
				            	System.out.println("Actual title"+actualtitle);
				            	driver.findElement(By.linkText("HR")).click();
				            }
				        }
				        
				    
			//Switch to main window
			driver.switchTo().window(MainWindow);
			driver.findElement(By.name("save")).click();
				
			
			//Classic to lightning 
			driver.findElement(By.linkText("Switch to Lightning Experience")).click();
			
			//Fox image
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[3]")));
			
			//App Launcher
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("slds-icon-button")));
			driver.findElement(By.xpath("//*[@id=\"318:80;a\"]/div")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Content")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		}

	}

