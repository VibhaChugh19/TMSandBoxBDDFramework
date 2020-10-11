package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;


public class WebUIUtilty {
	
	 static WebDriver driver;
		
	public static WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
   		driver.manage().window().maximize();
   		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   		return driver;
	}
		
	public static void lauchApplication(String url) {
		driver.navigate().to(url);
	}
	
	public static void timeOUt(long seconds) {
		long milliseconds = seconds*1000;
		try {
			Thread.sleep(milliseconds);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getTextOfAlert() {
		 Alert alertObj = driver.switchTo().alert();
		 String alertText = alertObj.getText();
		 return alertText;
		
	}
		
	 public static WebUIUtilty scrollArrowDown(int numberOfTimes) {
  	   Actions actionObj = new Actions(driver);
  	   for(int i=0;i<numberOfTimes;++i) {
  		   actionObj.sendKeys(Keys.ARROW_DOWN).build().perform();
  	   }
  	   WebUIUtilty obj = new WebUIUtilty();
  	   return obj;
  	
     }
     

     public static void scrollArrowUP(int numberOfTimes) {
  	   Actions actionObj = new Actions(driver);
  	   for(int i=0;i<numberOfTimes;++i) {
  		   actionObj.sendKeys(Keys.ARROW_UP).build().perform();
  	   }
  	
     }
     
     public static void pressTab(int numberOfTimes) {
  	   Actions actionObj = new Actions(driver);
  	   for(int i=0;i<numberOfTimes;++i) {
  		   actionObj.sendKeys(Keys.TAB).build().perform();
  	   }
     }

     
     public static void scrollPageDown(int numberOfTimes) {
  	   Actions actionObj = new Actions(driver);
  	   for(int i=0;i<numberOfTimes;++i) {
  		   actionObj.sendKeys(Keys.PAGE_DOWN).build().perform();
  	   }
     }
  	      
     public static void scrollPageUP(int numberOfTimes) {
  	   Actions actionObj = new Actions(driver);
  	   for(int i=0;i<numberOfTimes;++i) {
  		   actionObj.sendKeys(Keys.PAGE_UP).build().perform();
  	   }
  	
     }
     
    public static void pressEnter() {
 	   Actions actionObj = new Actions(driver);
		   actionObj.sendKeys(Keys.ENTER).build().perform();
    }
    
	 public static void takeScreenShot(String testCaseID) {
		   
		   TakesScreenshot tsObj = (TakesScreenshot)driver;
		   File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		   String filePath = "Screenshot//" + testCaseID +" " +  getTimeStamp() + ".png";
		   File destFile = new File(filePath); 
		   try {
			//FileUtils.copyFile(fileObj, destFile);
			//FileUtils.copyFile(fileObj, destFile);
			FileHandler.copy(fileObj, destFile);
		   } catch (IOException e) {
		
		   }
   }
	 
	 public static String getTimeStamp() {
		 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String date = sd.format(new Date());
		 String date1 = date.replaceAll("[^0-9]", "");
		 return date1;
		 
	 }

}


