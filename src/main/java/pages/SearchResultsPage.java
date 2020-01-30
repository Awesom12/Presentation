/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sujana Kotike
 *   This class(SearchResultsPage) contains the web elements of
 * Search Results Page  and  the actions performed(methods) on those elements
 * 
 */
public class SearchResultsPage {	

	private WebDriver driver;		
	
	private By productImage = By.xpath("//img[contains(@alt,'Tokyo-Talkies-Women-Black-Printed-Maxi-Dress')]");
		
	public SearchResultsPage(WebDriver driver){
      this.driver = driver;      
    }
	
	public void goToSearchResultsPage(String productType) {
		driver.get("http://shop.demoqa.com/?s="+productType+"&post_type=product");
	}
	
	public boolean isPageOpened(String productType) {
				
		boolean srpOpened = driver.getCurrentUrl().contains(productType);
		if(srpOpened==true) {
			System.out.println("Search Results page is opened");
		}
		
		return srpOpened;		
	}
	
	
	
	public boolean isTheSpecificProductDisplayed(String sProduct){	
					
	WebElement element = driver.findElement(productImage);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	(js).executeScript("arguments[0].scrollIntoView(true);", element);
	
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
	
	boolean isProductDisplayed = element.isDisplayed();
	
	if(isProductDisplayed==true) {
	System.out.println("The product searched for: " + sProduct + " is displayed: ");
	}
	
	return isProductDisplayed;

}
	
	public AddToCartPage clickOnSpecificProduct(){	
		
		driver.findElement(productImage).click();
		return new AddToCartPage(driver);
	}
}
