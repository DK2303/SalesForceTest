package com.seleniumTestPrograme;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;


public class GeckoDriver{
	
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		GeckoDriver obj=new GeckoDriver();
		obj.geckoTest();
		}
	
	public void geckoTest() throws InterruptedException {
		
		
		String actualtitle="";
		try {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium Project\\Gecko Driver(FireFox)\\geckodriver.exe");
		
		FirefoxOptions opt=new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		
		driver=new FirefoxDriver(opt);
		Dimension d=new Dimension(800,1200);
		
		
		driver.get("http:\\login.salesforce.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String appTitle=driver.getTitle();
		
		String expTitle="Login | Salesforce";
		
		if(appTitle.equals(expTitle))
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("dinesh2303@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("password")).sendKeys("Dinesh123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebElement checkBox=driver.findElement(By.id("rememberUn"));  // for Remainder Me Key code
		//checkBox.click();
		
		//System.out.println(checkBox.isSelected());
		
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		//driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/a[1]")).click();  //Switch to Lightning link code
		WebDriverWait wait1=new WebDriverWait(driver,60);
		
		
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[3]")));  // fox image handling code
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("close-btn"))); //security alert pop up handling code
		driver.findElement(By.className("close-btn")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-icon-waffle"))); //App_launcher button clicking code
		driver.findElement(By.className("slds-icon-waffle")).click();
	   //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  // wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[contains(@type,'search')]")));
		
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='al-menu-search-bar']//following::div//input"))); //OfficeHelp App select and Click 
		driver.findElement(By.xpath("//*[@class='al-menu-search-bar']//following::div//input")).sendKeys("OfficeHelp Lightning");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    //Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
	    wait1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("OfficeHelp Lightning")));
	    driver.findElement(By.className("slds-truncate")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contacts")));
	    driver.findElement(By.linkText("Contacts")).click();
	    
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("forceActionLink")));
	   driver.findElement(By.className("forceActionLink")).click();
	   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("select")));
	   driver.findElement(By.className("select")).click();
	   //Thread.sleep(4000);
	   
	   driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[2]/a")).click();
	   Thread.sleep(5000);
	  // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("First Name")));
	   driver.findElement(By.xpath("//*[@id=\"178:1591;a\"]")).sendKeys("Dinesh");
	   Thread.sleep(4000);
	   
	   driver.findElement(By.xpath("//*[@id=\"188:1591;a\"]")).sendKeys("A");
	   WebElement b1=wait1.until(ExpectedConditions.elementToBeClickable(By.className("label bBody")));
	   System.out.println(b1);
	   
	   driver.findElement(By.className(" label bBody")).click();
	   
	   
	   
	   /*Select dropDown=new Select(driver.findElement(By.className("select")));
	   Thread.sleep(4000);
	   
	   
	   
	   dropDown.selectByVisibleText("Mr.");
	   Thread.sleep(4000);
	   
	   dropDown.deselectByVisibleText("Mr.");
	   Thread.sleep(4000);
	   
	   dropDown.deselectByIndex(1);
	   
	   
	   /*Select dropDown=new Select((WebElement) driver);
	   ((WebDriver) dropDown).findElement(By.className("select")).click();
       
	  /* //one-app-launcher-menu-item/a[@data-label='Marketing']/div/lightning-formatted-rich-text/span
	   * public String getPropValues(String key) throws IOException {
		Properties prop = new Properties();
		FileReader reader=new FileReader("C:\\Code\\Selenium_Mar16\\SeleniumProject\\newFile.properties");
		prop.load(reader);  
        return prop.getProperty(key);
	}
	   */
	   
	   /*String MainWindow=driver.getWindowHandle();
	   System.out.println("MainWindow="+MainWindow);
	   Set<String> s1=driver.getWindowHandles();
	   System.out.println("Size="+s1.size());
	   System.out.println(s1);
	   
	   Iterator<String> i1=s1.iterator();
	   
	   while(i1.hasNext()) {
		   
		   System.out.println(i1);
           String ChildWindow=i1.next();	
           System.out.println(ChildWindow);
           
           if(!(MainWindow.equalsIgnoreCase(ChildWindow)))			
           {    		
           		
        	   System.out.println("Loop"+ChildWindow);
        	   driver.switchTo().window(ChildWindow);
        	   actualtitle=driver.getTitle();
        	   driver.switchTo().frame(ChildWindow); 	   
           }

	   }
	   
	   
	    
	    //driver.findElement(By.className("slds-button")).click();
	    //Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);	
		
		//driver.findElement(By.linkText("OfficeHelp Lightning")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	   /* Wait<WebDriver> newwait = new FluentWait<>(driver)
                .withTimeout(1000, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        
            newwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objName)));*/
        

		//driver.close();
		//driver.quit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
	/*public void properticeConfig() throws FileNotFoundException {
		Properties config;
		config = new Properties();
		FileInputStream fis;
		fis=new FileInputStream("C:\\Users\\whirldata-sa\\WorkSpace-Selenium\\SeleniumTest\\src\\com.seleniumTestPrograme\\config.properties");
	}*/
	
	
}