package com.ibm.seleniumconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		driver.get("https://www.spicejet.com");

		WebElement tripEle = driver.findElement(By.xpath("(//input[@value='RoundTrip'])[1]"));
		tripEle.click();
		
		
		WebElement fromddEle= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		fromddEle.click();
		System.out.println("From section is selected....");
		
		WebElement MAAEle = driver.findElement(By.partialLinkText("Chennai"));
		MAAEle.click();
		
		//WebElement toddEle= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		WebElement toddEle= driver.findElement(By.partialLinkText("Bengaluru"));
		toddEle.click();
		
		WebElement depdateEle= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]"));
		depdateEle.click();
		Thread.sleep(1000);
		System.out.println("Depart date is selected....");
				
		WebElement retundateEle= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));
		retundateEle.click();
		System.out.println("Return date calendar is clicked....");
		
		WebElement retdateEle= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[1]"));
		retdateEle.click();
		System.out.println("Return date is selected....");
		Thread.sleep(2000);
		
		WebElement passEle= driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		passEle.click();
		Thread.sleep(2000);
		
		WebElement adultEle= driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
		adultEle.click();
		System.out.println("No of Adult is selected as 2....");
		
		WebElement curEle= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']/option[4]"));
		curEle.click();
		System.out.println("Currency is selected as USD....");
		
		WebElement searchEle= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
		searchEle.click();
		System.out.println("Search result displayed....");
		
		WebElement resultEle= driver.findElement(By.xpath("//span[text()=' Chennai  to  Bengaluru ']"));
		String output = resultEle.getText();
		
		System.out.println(output);
		
		if(output.trim().equals("Chennai to Bengaluru"))
		{
			System.out.println("The output of search result is verified");
		}
			
		else
			
			System.out.println("The output of search result is not as expected...");
			
	}
}
