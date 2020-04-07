package com.testSalesforce;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class N1 {

	public static void Chromedriver() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Code\\Selenium_Mar16\\newjavaprojects\\drivers\\chromedriver.exe");
	//WebDriver driver=new ChromeDriver();
	ChromeOptions options=new ChromeOptions();
	Map<String, Object> prefs=new HashMap<String,Object>();
	prefs.put("profile.default_content_setting_values.notifications", 1);
	//1-Allow, 2-Block, 0-default
	options.setExperimentalOption("prefs",prefs);
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://login.salesforce.com/");
	driver.findElement(By.xpath("//input[@type='email' and @id='username']")).sendKeys("nitishbharadwaj@gmail.com");
	driver.findElement(By.xpath("//*[@type='password']")).sendKeys("xxxxxxxx");
	driver.findElement(By.xpath("//*[contains(@type,'sub')]  ")).click();
	 driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("slds-icon-waffle")));
	driver.findElement(By.className("slds-icon-waffle")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='al-menu-search-bar']//following::div//input")));
	driver.findElement(By.xpath("//*[@class='al-menu-search-bar']//following::div//input")).sendKeys("Dice Application Lightning");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//one-app-launcher-menu-item/a[@data-label='Dice Application Lightning']/div/lightning-formatted-rich-text/span")));
	driver.findElement(By.xpath("//one-app-launcher-menu-item/a[@data-label='Dice Application Lightning']/div/lightning-formatted-rich-text/span")).click();
	Actions actionmouse=new Actions(driver);
	actionmouse.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='slds-context-bar__label-action dndItem' and @title='Dice.com Job Forms']")))).click().build().perform();
	
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Chromedriver();
	}

}

	