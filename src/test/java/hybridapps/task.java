package hybridapps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class task {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity ");
		//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public  void test()  throws InterruptedException {
	driver.findElement(MobileBy.id("android:id/text1")).click();
	Thread.sleep(3000);
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sai");
	
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	Thread.sleep(3000);
	String kiran= driver.findElementByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Converse All Star\" ))").getText();
	System.out.println(" Scrolled to the product -> "+kiran);
	
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
	
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(5000);
	
	
String price1=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productPrice")).getText();
	
	price1=price1.substring(1);
	
	Double cost1=Double.parseDouble(price1);
	System.out.println(cost1);
	
	Thread.sleep(5000);
	driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
	
	driver.findElement(MobileBy.className("android.widget.Button")).click();
	
	 
	}
}

