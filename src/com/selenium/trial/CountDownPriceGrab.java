package com.selenium.trial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountDownPriceGrab {

	public CountDownPriceGrab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) throws Exception {
		CountDownPriceGrab countDown = new CountDownPriceGrab();
		countDown.countdownPrice();
	}
	
	public void countdownPrice() throws Exception {
		WebDriver driver = DriverFactory.getInstance(DriverFactory.FIREFOX_DRIVER);
		
		driver.get("http://shop.countdown.co.nz/#url=/Shop/Browse");

        // wait until element is displayed
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element= wait.until(SeleniumCommon.
        								visibilityOfElementLocated(By.id("product-list")));    
 
        String delims = "[\n]+";
        String[] tokens = element.getText().split(delims);

		File outputFile = new File("users.csv");
		// before we open the file check to see if it already exists
		if ( !outputFile.exists() )
			outputFile.createNewFile();

        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter( fw );

        for (String s: tokens) {
        	 if (s.matches("^qty.*")) {
        		 continue;
        	 }
        	 else if (s.matches("^was.*")) {
        	     continue;
        	 } 
        	 else if (s.matches("^\\$.*")) {
        		 writer.write(s+"\r\n");
        	 } else {
        		 writer.write(s+",");
        	 }
        }
        writer.flush();
        writer.close();
        fw.close();

        driver.quit();
		
	}

}
