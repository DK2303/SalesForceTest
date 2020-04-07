package com.test;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;


public class Link {

	
		public static void main(String[] args) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium Project\\Chrome Driver\\chromedriver.exe");					
			Alertss al= new Alertss();
			Linktxt l1=new Linktxt();
			Drpdown drp= new Drpdown();
			int x=0;
			do 
			{
				System.out.println("Enter 1 for links \t 2 for Dropdown \t 3 for alerts \t 4 exit");
				Scanner in = new Scanner(System.in);
				x=in.nextInt();
				switch(x) {
				case 1:
				{
					l1.linktxt();
					break;
				}
				case 2:
				{
					drp.dropdown();
					break;
				}
				case 3:
				{
					al.alerts();
					break;
				}
				case 4:
				{
					System.out.println("Exiting");
				}
				default: System.out.println("\n Invalid input");

				}
			}while(x!=4);

		} 		
	} 
