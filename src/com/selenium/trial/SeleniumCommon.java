package com.selenium.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SeleniumCommon {
	  public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
	  	  return new ExpectedCondition<WebElement>() {
	  	    public WebElement apply(WebDriver driver) {
	  	      WebElement toReturn = driver.findElement(locator);
	  	      if (toReturn.isDisplayed()) {
	  	        return toReturn;
	  	      }
	  	      return null;
	  	    }
	  	  };
	   }
	  
	  public static void wait(WebDriver driver, long second) {
		  driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	  }
}
