package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	
public  CartPage(AndroidDriver<AndroidElement>driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

		@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		public List<WebElement> amount1;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		public List<WebElement> amount2;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
		public WebElement TotalAmount;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
		public WebElement VisitToWebsite;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
		public WebElement ConditionsTerms;
		
		@AndroidFindBy(xpath="//*[@text='Send me e-mails on discounts related to selected products in future']")
		public WebElement SendMeCheckBox;
		
		
//		String amnt1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
//		amnt1 = amnt1.substring(1);

}
