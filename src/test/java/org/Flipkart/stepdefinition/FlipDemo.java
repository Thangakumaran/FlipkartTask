package org.Flipkart.stepdefinition;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipDemo {

	public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        
        ChromeOptions v = new ChromeOptions();
        v.addArguments("--start-maximized");
        c.setCapability(ChromeOptions.CAPABILITY, v);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\cucumber\\SeleniumA\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		//driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		try {
			WebElement w = driver.findElement(By.xpath("//button[text()='✕']"));
			w.click();
			
		} catch (Exception e) {
			
		}
		WebElement u = driver.findElement(By.xpath("//div[text()='Travel']"));
		u.click();
		
		Thread.sleep(2000);
		WebElement q1 = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		q1.sendKeys("Chennai, MAA - Chennai International Airport");
		WebElement q2 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		q2.sendKeys("Mumbai, BOM - Chatrapati Shivaji International Airport");
		WebElement q3 = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		q3.click();
		WebElement p = driver.findElement(By.tagName("table"));
		List<WebElement> o = p.findElements(By.tagName("tr"));
		for (int i = 0; i <o.size(); i++) {
			WebElement ll = o.get(6);
			List<WebElement> column = ll.findElements(By.tagName("td"));
			
				WebElement oo = column.get(3);
				String text = oo.getText();
				System.out.println(text);	
				if(text.equals("29")) {
					oo.click();
				}
			}
			
		
		
		
		
		
	}

}
