package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
	WebDriver driver;
	Logger log=Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		log.info("launching chrome browser");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Getting the url from config.properties file
		driver.get("https://www.freecrm.com/");	
		log.info("entering application url");
		log.warn("Just warning msg");
		log.fatal("this is a fatal msg");
		log.debug("debugger msg");
	}
	
	
	@Test
	public void freecrmtitle(){
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
	}
	@Test
	public void freecrmtitle1(){
		
	}
	@Test
	public void freecrmlogotest(){
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
