package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//import pages.SearchResultsPage;

/**
 * @author Sujana Kotike
 * 
 * This class(HomePage) contains the web elements of
 * Home page of http://shop.demoqa.com/ and 
 * the actions performed(methods) on those elements
 * i.e., searchForAProductType
 *
 */


public class HomePage {
	
	private WebDriver driver;	
	
	private By searchLink = By.xpath("//a[@class = 'noo-search']");
	private By searchInput = By.xpath("//input[@type = 'search']");

	public HomePage(WebDriver driver){
      this.driver = driver;
    }
	
	public void goHome() {
    	//Navigate to the shopping site
    	driver.get(" http://shop.demoqa.com/");  	    	
    }
    
	
	public boolean isPageOpened() {
		
		boolean homepageOpened = driver.getCurrentUrl().equals("http://shop.demoqa.com/");
		if(homepageOpened==true) {
			System.out.println("Home page is opened");
		}
		
		return homepageOpened;		
	}
	
	
	public SearchResultsPage searchForAProductType(String product) {
		
		driver.findElement(searchLink).click();
		driver.findElement(searchInput).sendKeys(product+ Keys.ENTER);
		return new SearchResultsPage(driver);
	}
}
