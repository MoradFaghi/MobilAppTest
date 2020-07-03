package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {
	
public  ProductsPage(AndroidDriver<AndroidElement>driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
		@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
		public WebElement addProduct1;
		
		@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
		public WebElement addProduct2;

		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		public WebElement CartBtn;

}
