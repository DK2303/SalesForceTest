package com.testSalesforce;


import java.awt.Point;
import java.io.FileInputStream;
import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.edge.EdgeDriver;

public class ChromeDriver1 extends InputFileReader{
	
		WebDriver driver;
		
		
		public void chromeTest() throws InterruptedException, NoSuchElementException{
			
			ChromeDriver1 obj1=new ChromeDriver1();
	try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Project\\Chrome Driver\\chromedriver.exe");
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			
			driver= new ChromeDriver(opt);
			Dimension d=new Dimension(800,1200);
			
			
			driver.get(obj1.getXmlValue("sfurl"));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String appTitle=driver.getTitle();
			
			String expTitle=obj1.getXmlValue("sfexpTitle");
			
			if(appTitle.equals(expTitle))
			{
				System.out.println("Test Passed");
			}
			else {
				System.out.println("Test Failed");
			}
			
			driver.manage().window().setSize(d);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id(obj1.getPropertyValue("SFusername"))).sendKeys(obj1.getXmlValue("sfusername"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id(obj1.getPropertyValue("SFpassword"))).sendKeys(obj1.getXmlValue("sfpassword"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//WebElement checkBox=driver.findElement(By.id("rememberUn"));  // for Remainder Me Key code
			//checkBox.click();
			
			//System.out.println(checkBox.isSelected());
			
			driver.findElement(By.id(obj1.getPropertyValue("SFLogin"))).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(5000);
					
			//driver.findElement(By.xpath(obj1.getPropertyValue("SFswitchToLightning"))).click();  //Switch to Lightning link code
			WebDriverWait wait1=new WebDriverWait(driver,60);
			
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(obj1.getPropertyValue("SFfoxImageHandling"))));   // fox image handling code
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.className(obj1.getPropertyValue("SFclosebutton_popup")))).click(); //security alert pop up handling code
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFappLauncher")))).click();       //App_launcher button clicking code
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj1.getPropertyValue("SFsearchBar"))));               //Search Bar handle
			driver.findElement(By.xpath(obj1.getPropertyValue("SFsearchBar"))).sendKeys(obj1.getXmlValue("appName"));               //App selection
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		    //Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj1.getPropertyValue("SFsearchedAppSelect")))).click();       //Searched App Seection 
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    Actions actionmouse=new Actions(driver);
			actionmouse.moveToElement(wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFObjectSelect"))))).click().build().perform();  //Contact Object Selection
			
		//for(int k=0;k<=2;k++) {
				
		   wait1.until(ExpectedConditions.elementToBeClickable(By.className(obj1.getPropertyValue("SFnewContact")))).click(); //new contact creation new button click
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath(obj1.getPropertyValue("SFphoneNumberTab"))).sendKeys("9944996611"); //select and give input in phone number content tab
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   wait1.until(ExpectedConditions.elementToBeClickable(By.className("select"))).click(); // select to Salutation content tab
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   actionmouse.moveToElement(wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/a[@title='Mr.']")))).click().build().perform(); //Select particular content in salutation Drop down
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath(obj1.getPropertyValue("SFnameTab"))).sendKeys("Hari"); //select and give input in name content tab 
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath(obj1.getPropertyValue("SFlastNameTab"))).sendKeys("G"); //select and give input in Last name content tab
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath(obj1.getPropertyValue("SFaccountSelectTab"))).click(); //Select Account Name Content tab
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath(obj1.getPropertyValue("SFselectAccount"))).click(); //Select particular Account
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   String date="20-1-2020";
		   String[] dateVal= date.split("-");
		   
		   LocalDate currentDate = LocalDate.now();
		   Calendar now = Calendar.getInstance();
		   System.out.println(currentDate.now());
		   
		   	  int length=dateVal.length;
			  String year=dateVal[length-1];
			  System.out.println(year);
			  String month=dateVal[length-2];
			  String day=dateVal[length-3];
			  
			 if(Integer.parseInt(year)>2000 && Integer.parseInt(year)<2021)
			  {
				  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFdate")))).click(); //Date Content Tab Year Selection
				  Select select = new Select(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.getPropertyValue("SFyearSelect"))))); //Year Select
				  select.selectByVisibleText(year);
			  }
			  int presentMonth=(now.get(Calendar.MONTH)+1);
			  int value;
			  if(Integer.parseInt(month)>presentMonth) 
			  {
				  value=Integer.parseInt(month)-presentMonth;
				  for(int i=1;i<=value;i++)
				  {
					  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFnextMonth")))).click();  //Future month select
				  }
			  }
			  else 
			  {
				  value=presentMonth-Integer.parseInt(month);
				  for(int i=1;i<=value;i++) 
				  {
					  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFprevMonth")))).click();  //Prev Month Select
				  }
		      }	
			//div/table[contains(@class,'calGrid')]/thead//following-sibling::tbody/tr/td - date selection xpath
			//*[@id="2249:0"]/div/div[2]/table/tbody/tr[1]/td[1]
				  
			List<WebElement> cols=driver.findElements(By.xpath(obj1.getPropertyValue("SFdateTableColm"))); //take date colm length
			int colCount=cols.size();
			System.out.println(colCount);
				
			List<WebElement> rows=driver.findElements(By.xpath(obj1.getPropertyValue("SFdateTableRow")));
			int rowsCount=rows.size();
			System.out.println(rowsCount);
				boolean flag=false;	
				for(int i=1;i<colCount;i++) 
				{
					for(int j=1;j<=rowsCount;j++) 
					{
							String val=driver.findElement(By.xpath("//div/table[contains(@class,'calGrid')]/thead//following-sibling::tbody/tr["+i+"]/td["+j+"]")).getText();
							if(val.contains(day)) { 
							wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/table[contains(@class,'calGrid')]/thead//following-sibling::tbody/tr["+i+"]/td["+j+"]"))).click();		
							flag=true;
							break;
							}
					}
					if(flag==true) {
						break;}
				 }
			//if(k==0) {	  
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFnewContactSave")))).click(); //Save Button Click
		    Thread.sleep(5000);
		   
		    actionmouse.moveToElement(wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFreleaseContactButton"))))).release(); //release contact Button
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		    actionmouse.moveToElement(wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(obj1.getPropertyValue("SFObjectSelect"))))).click().build().perform(); //again click contact button
		                                     		   
		    /*wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[8]/span/div/a/lightning-icon/lightning-primitive-icon"))).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[9]/div/ul/li[2]/a"))).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Delete')]/span"))).click();
		    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div")));
		    }
			else if(k==1) {
		    	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Save & New')]/span"))).click(); //Save Button Click
		    	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div")));
		    }
			else if(k==2) {
		    	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Cancel')]/span"))).click();
		    }
		    	
	}*/
		//html/body/div[4]/div[1]/section/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[8]/span/div/a/lightning-icon/lightning-primitive-icon
		
		//driver.close();
			//driver.quit();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public static void main(String[] args) throws InterruptedException {
			WebTableHandling obj=new WebTableHandling();
			//ChromeDriver1 obj = new ChromeDriver1();
			obj.chromeTest();	
			obj.DynamicWebTableHandling("MS Dhoni");
			}
	}