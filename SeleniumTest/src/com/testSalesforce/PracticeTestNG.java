package com.testSalesforce;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@BeforeSuite
	void beforeSuite() {
		System.out.println("Before Suite:");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("Before Class:");
		
	}
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test:");
		
	}
	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Method:");
		
	}
	
	@Test
	void test() {
		System.out.println("Test");
	}

/*@AfterMethod
void afterMethod() {
	System.out.println("After Method:");
	
}
@AfterTest
void afterTest() {
	System.out.println("After Test:");
	
}
@Test
void Test10() {
	System.out.println("Test");
}

@AfterClass
void afterClass() {
	System.out.println("After Class:");
	
}
@AfterSuite
void afterSuite() {
	System.out.println("After Suite:");
}*/

@Test(timeOut=500)
public void Test(){
    System.out.println("Executes Test");
}
@Test(invocationCount=10)
public void InvocationCounts(){
    System.out.println("InvocationCounts");
}

@Test(invocationCount=2)
public void Test1(){
    System.out.println("Test");
}
}




