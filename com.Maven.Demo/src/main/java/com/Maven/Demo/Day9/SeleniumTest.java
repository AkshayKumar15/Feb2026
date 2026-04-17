package com.Maven.Demo.Day9;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();
		System.out.println("this is my last line");
	}

}
