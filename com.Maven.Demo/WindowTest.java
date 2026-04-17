package com.Selenium.Demo.Day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.Selenium.Demo.Day3.BaseFireBase;

public class WindowTest extends BaseFireBase{

	public static void main(String[] args) throws Exception {
		launchBrowser("firefox");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_Firebase();
		Thread.sleep(4000);

		WebElement switchToEle = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[1]/button"));

		Actions actions=new Actions(driver);
		actions.moveToElement(switchToEle).build().perform();
		Thread.sleep(4000);
		WebElement alertMenu = driver.findElement(By.linkText("Windows"));
		alertMenu.click();
		System.out.println("clicked on Windows menu");
		Thread.sleep(4000);
		WebElement newTabbutton = driver.findElement(By.xpath("//button[contains(text(),'Tab')]"));
		newTabbutton.click();
		System.out.println("new tab clicked");
		Thread.sleep(4000);
		//	WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		//	newTab.get("https://www.google.com");
		//	System.out.println("Title in new tab: " + newTab.getTitle());

		Set<String> TabIds = driver.getWindowHandles();

		Iterator<String> Iterator1 = TabIds.iterator();

		List<String> TabIndex= new ArrayList<String>();
		while(Iterator1.hasNext())
		{
			TabIndex.add(Iterator1.next());
		}

		driver.switchTo().window(TabIndex.get(1));

		System.out.println("Tab Title= "+driver.getTitle());

		driver.findElement(By.name("q")).sendKeys("Selenium");

		Thread.sleep(4000);

		driver.close();

		Thread.sleep(4000);

		driver.switchTo().window(TabIndex.get(0));
		System.out.println("Tab Title= "+driver.getTitle());
		Thread.sleep(3000);
		
		
		WebElement newWinbutton = driver.findElement(By.xpath("//button[contains(text(),'Window')]"));
		newWinbutton.click();
		System.out.println("new window clicked");
		Thread.sleep(4000);

		//	WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
		//	newWindow.get("https://www.google.com");
		//	System.out.println("Title in new tab: " + newWindow.getTitle());

		Set<String> WindowIds = driver.getWindowHandles();

		Iterator<String> Iterator2 = WindowIds.iterator();

		List<String> WindowIndex= new ArrayList<String>();
		while(Iterator2.hasNext())
		{
			WindowIndex.add(Iterator2.next());
		}

		driver.switchTo().window(WindowIndex.get(1));

		System.out.println("Window Title= "+driver.getTitle());

		driver.findElement(By.name("q")).sendKeys("Selenium");

		Thread.sleep(4000);

		driver.close();

		Thread.sleep(4000);

		driver.switchTo().window(WindowIndex.get(0));
		System.out.println("Window Title= "+driver.getTitle());
		Thread.sleep(4000);
		driver.quit();

	}

}
