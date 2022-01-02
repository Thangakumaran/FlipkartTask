package org.Flipkart.stepdefinition;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartTask {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\cucumber\\SeleniumA\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		try {
			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
			close.click();
		} catch (Exception e) {
		}
		
		WebElement electronics = driver.findElement(By.xpath("//div[@id='container']/div/div[2]/div/div/div[5]"));
		Actions a= new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(electronics).perform();
		
		WebElement accessories = driver.findElement(By.xpath("//a[contains(text(),'MobileAccessory')]"));
		a.moveToElement(accessories).perform();
		
		WebElement camera = driver.findElement(By.xpath("//a[contains(text(),'Camera Lens Protectors')]"));
		camera.click();
		
		List<WebElement> alltag = driver.findElements(By.tagName("a"));
		List<WebElement> allelements = driver.findElements(By.xpath("//a[contains(text(),' Camera Lens ')]"));
		for (WebElement x : allelements) {
			String alltext = x.getText();
			System.out.println(alltext);
		}
		WebElement cameragaurd = driver.findElement(By.xpath("(//a[contains(text(),'ICREATOR Camera Lens Protector for Apple')])[14]"));
		String Expectedtext = cameragaurd.getText();
		System.out.println("ordered text :"+Expectedtext);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	
		j.executeScript("arguments[0].scrollIntoView(true)", cameragaurd);
		j.executeScript("arguments[0].click()", cameragaurd);
		
		
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String w:child) {
			if(!parent.equals(child)) {
				driver.switchTo().window(w);
				
			}
		}
		WebElement Extext  = driver.findElement(By.xpath("//span[contains(text(),'ICREATOR Camera Lens Protector for ')]"));
		String expectedtext = Extext.getText();
		System.out.println("purchase text :" +expectedtext);
		if(Expectedtext.equals(expectedtext)) {
			System.out.println("Matching text is :"+expectedtext);
			
		}
		else {
			System.out.println("Not matched that text");
		}
		Thread.sleep(1500);
		WebElement addtocart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		j.executeScript("arguments[0].scrollIntoView(true)", addtocart);
		addtocart.click();
		//j.executeScript("arguments[0].click()", addtocart);
		
		WebElement placeorder = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
		placeorder.click();
	}

}
