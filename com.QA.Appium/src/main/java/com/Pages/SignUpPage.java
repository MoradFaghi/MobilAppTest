package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {
	public  SignUpPage(AndroidDriver<AndroidElement>driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement enterName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femalBtn;
	
	public WebElement getfemalBtn() {
		return femalBtn;
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement dropdownCountryName;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Austria']")
	public WebElement clickOnCountryName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement loginBtn;
	
}
