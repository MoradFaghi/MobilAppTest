package regressionSuite;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utility.BaseClass;
import com.Pages.CartPage;
import com.Pages.ProductsPage;
import com.Pages.SignUpPage;
import com.Utility.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPageTest extends BaseClass{
	@Test
	public void loginStart()throws IOException, InterruptedException {
		
//		service=startServer();    // Starts the Server 
//		System.out.println("Appium Server Started");
//		
		AndroidDriver<AndroidElement>driver = capabilities("GeneralStoreApp");
		
		SignUpPage sp = new SignUpPage(driver);
		
		sp.enterName.sendKeys("Test Name");
		
		sp.getfemalBtn().click();
		
		sp.dropdownCountryName.click();
		
		Utilities ut= new Utilities(driver);
		ut.scrollElement("Austria");
		
		sp.clickOnCountryName.click();
		
		sp.loginBtn.click();
		
		ProductsPage  pp= new ProductsPage(driver);
		
		pp.addProduct1.click();
		pp.addProduct2.click();
		pp.CartBtn.click();
		
		Thread.sleep(3000);
		
		CartPage cp = new CartPage(driver);
		
		String amnt1= cp.amount1.get(0).getText();
		amnt1 = amnt1.substring(1);
		double amntVal1= Double.parseDouble(amnt1);
		System.out.println("Amount1 Price is :"+amntVal1);
		
		
		String amnt2= cp.amount2.get(1).getText();
		amnt2 = amnt2.substring(1);
		double amntVal2 = Double.parseDouble(amnt2);
		System.out.println("Amount2 Price is :"+amntVal2);
		
		double sumOfProducts = amntVal1 + amntVal2;
		
		System.out.println("Sum of amount value is :"+ sumOfProducts);
		
		String amntToal= cp.TotalAmount.getText();
		amntToal = amntToal.substring(1);
		double toalval = Double.parseDouble(amntToal);
		System.out.println("TotalAmount Price is :"+toalval);
		
		Assert.assertEquals(sumOfProducts, toalval);
		
		if (sumOfProducts == toalval){
			
			System.out.println("The sum of the pricing is correct");
			} else
			{
				System.out.println("The pricing calculation is not correct");	
			}
			
		}
	}

	
//	@Test
//	public void loginStart()throws IOException {
//		AndroidDriver<AndroidElement>driver = capabilities("GeneralStoreApp");
//		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test Name");
//		//driver.hideKeyboard();
//		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))");
//		
//		WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']"));
//		
//		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		
//		String elText=element.getText();
//		System.out.println(elText);
//		element.click();
//		AssertJUnit.assertEquals(elText, "Austria");    //Negativtest: überprüfen ob der Text mit expected Result Austria11111 übereinstimmt
//		
//	}


