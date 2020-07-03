package com.Utility;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
	AndroidDriver<AndroidElement>driver;
	
	public Utilities (AndroidDriver<AndroidElement>driver) {
		this.driver=driver;
	}

	public void scrollElement(String countryName) {
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\""+countryName+"\"))");
	}
	
//	public void amount1Only(double amnt) {
//		
//		String amnt1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
//		amnt1 = amnt1.substring(1);
//		double amnt1val= Double.parseDouble(amnt1);
//	}
	
}
