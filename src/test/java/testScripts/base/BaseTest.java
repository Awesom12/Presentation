package testScripts.base;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

import pages.HomePage;
//import utils.EventReporter;

/**
 * @author Sujana Kotike
 * 
 * 1. This test script initializes the browser
 * 2. Maximizes the browser window
 * 3. creates a handle to the Home page
 */

public class BaseTest {
	
	protected WebDriver driver;
		protected HomePage hp;	
		

    @BeforeClass
	public void setUp(){    	
   
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
      
        //EventFiringWebDriver listens to and triggers the events
     /*  driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions( )));
        driver.register(new EventReporter());*/
        
        driver = new ChromeDriver();            

        // Maximize the window
        driver.manage().window().maximize();       
       
        
      //create object of home page class
        hp = new HomePage(driver);      

}
    
    
  	/*private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();        
       // options.addArguments("disable-infobars"); //Disabling info-bars is no longer supported by Chromium
        //options.setHeadless(true);
        return options;
    }*/
  	
  	
  	@AfterMethod
  	public void recordFailure(ITestResult result){

  	    if(ITestResult.FAILURE == result.getStatus())
  	    {
  	        var camera = (TakesScreenshot)driver;
  	      File screenshot = camera.getScreenshotAs(OutputType.FILE);
  	      
  	      //Giving unique name to the screenshot retains the older ones
  	    //  File screenshotName = new File("src/test/resources/screenshots/"+result.getName() +System.currentTimeMillis()+ ".png");
  	    
  	      //screenshot with same name overrides the previous ones
  	      File screenshotName = new File("src/test/resources/screenshots/"+result.getName() + ".png");   
  	        try{
  	            Files.move(screenshot, screenshotName);
  	        }catch(IOException e){
  	            e.printStackTrace();
  	        }
  	      Reporter.log("<br><img src='"+screenshotName+"' height='400' width='400'/><br>");
  	    }
  	}
 
  	 /*@AfterClass
    public void tearDown() {
    	// driver.quit();
    }*/
  	
}
