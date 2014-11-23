package com.selenium.trial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DriverFactory {

	 private static WebDriver driver  = null;
	 public static final int FIREFOX_DRIVER = 0;
	 public static final int HTML_DRIVER = 1;

	 
	 protected DriverFactory() {
	      // Exists only to defeat instantiation.
	 }
		   
	 public static WebDriver getInstance(int type) {
	      if(driver == null) {
	    	  switch (type) {
	    	  	case 0 : driver = new FirefoxDriver();
	    	  			 break;
	  			default : driver = new HtmlUnitDriver();
	  					break;
	    	  }
	      }
	      return driver;
	}

}
