package hybridapps;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


public class hybridclass {
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
		
	driver.findElement(MobileBy.id( "com.androidsample.generalstore:id/spinnerCountry")).click();
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
	Thread.sleep(2000);
	driver.findElement(MobileBy.className( "android.widget.EditText")).sendKeys("span");
	 Thread.sleep(2000);
	driver.findElement(MobileBy.id( "com.androidsample.generalstore:id/radioFemale")).click();
	 Thread.sleep(2000);
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 Thread.sleep(2000);
//	String toast = driver.findElement(MobileBy.xpath("//android.widget.toast[1]")).getText();
//	System.out.println(toast);
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	 Thread.sleep(2000);
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(2000);
    String	price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
    price1 = price1.substring(1);
    System.out.println(price1);
    Thread.sleep(2000);
    String	price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
    price2 = price2.substring(1);
    System.out.println(price1 + price2);
    Double firstprice=Double.parseDouble(price1);
	   Double secondprice=Double.parseDouble(price2);
	    
	   Double totalprice=firstprice+secondprice;
	   
			   
	    System.out.println(totalprice);
//	   
//	String ele1 =   driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Total Purchase Amount:\")")).getText();
//	   System.out.println(ele1+firstprice+secondprice);
	    
//	  String ele1 =  driver.findElement(MobileBy.className("android.widget.TextView")).getText();
//	    System.out.println(+firstprice+secondprice);
	
//    
  String total =  driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    
    total = total.substring(1);
      double combine = Double.parseDouble(total);
      System.out.println(combine);
//     try { 
//      Assert.assertEquals(totalprice, combine);}
//     
//      catch (Assertion error)
//      {
 
     
      
     if(totalprice.equals(combine))
      {
    	  System.out.println("price matched");
      }
      else
      { 
    	  
    	  System.out.println("price not matched");
    	  
      }
 

	
    
//    driver.findElements(MobileBy.className("android.widget.CheckBox")).get(0).click();
//    Thread.sleep(2000);
//    driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
//		
      
		
}
	

}
