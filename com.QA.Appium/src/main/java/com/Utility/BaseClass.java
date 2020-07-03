package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	
	public static AndroidDriver<AndroidElement> driver;
	
	//  Start Appium Server Programmatically
	public static AppiumDriverLocalService service;

	public static AppiumDriverLocalService startServer()
	{
	boolean flag= checkIfServerIsRunnning(4723);

	if(!flag)
	{

	service=AppiumDriverLocalService.buildDefaultService();
	service.start();
	}
	return service;

	}
	public static boolean checkIfServerIsRunnning(int port) {

	boolean isServerRunning = false;
	ServerSocket serverSocket;
	try {
	serverSocket = new ServerSocket(port);

	serverSocket.close();
	} catch (IOException e) {
	//If control comes here, then it means that the port is in use
	isServerRunning = true;
	} finally {
	serverSocket = null;
	}
	return isServerRunning;
	}

	
	// End of Server Starting
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException{
		FileInputStream fis= new FileInputStream("/Users/moradfaghi/MavenWeb/com.QA.Appium/src/main/java/com/Utility/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		
		File appDir = new File("src");
		File app = new File(appDir,(String)prop.getProperty(appName));
		
			DesiredCapabilities cap = new DesiredCapabilities();
			
			String deviceName=(String)prop.get("device");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
			driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Basice Settings has been completed.");
			
			
			return driver;
		}
	
//	@AfterClass
//	public void afterClass(){
//		
//		driver.quit();
//		
//	}

}
