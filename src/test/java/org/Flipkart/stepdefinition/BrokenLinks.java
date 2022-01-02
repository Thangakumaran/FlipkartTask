package org.Flipkart.stepdefinition;

import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		String s="https://www.facebook.com/";
		String url="";
		HttpURLConnection hp;
		
		System.setProperty("", "");
		WebDriver driver = new ChromeDriver();
		driver.get("");
		driver.manage().window().maximize();
		
		List<WebElement> w = driver.findElements(By.xpath("a"));
		for(WebElement x:w) {
			String ex = x.getAttribute("href");
			System.out.println(ex);
			if(ex==null||ex.isEmpty()) {
				System.out.println("ex not configured");
				
			}
			if (!ex.startsWith(s)) {
				System.out.println(ex);
				
			}
			try {
			//	hp=(HttpURLConnection)(new ur)
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
