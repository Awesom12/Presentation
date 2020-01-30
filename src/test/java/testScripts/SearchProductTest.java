package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.SearchResultsPage;
import testScripts.base.BaseTest;

/**
 * @author Sujana Kotike 
 * 
 * This Test Script:
 * 1. Navigates to the Product search results page directly(utilizing short cut) and
 * 2. Verifies if a specific product is displayed in the results
 * 3. Clicks on that specific product
 * 4. Verifies if the click on this specific product opens Add To Cart Page
 */

public class SearchProductTest extends BaseTest{	
	
	@Test 
	public void specificProductSearchTest() throws InterruptedException {		
		
		System.out.println("I'm in SearchProductTest");
		var srp = new SearchResultsPage(driver);
				
		//go to Search Results page url directly instead of from home(utilizing short cuts)
		srp.goToSearchResultsPage("Maxi");			
				
		//Verify if the Search Results page is opened
		assertTrue(srp.isPageOpened("Maxi"),"Search Results page is not opened");	
		
		//verify if the specific product that needs to be added to the cart is displayed
		assertTrue(srp.isTheSpecificProductDisplayed("Tokyo-Talkies"),"The specific product searched for is not displayed");
		
		//Click on the product to be added to cart
		var acp = srp.clickOnSpecificProduct();		
				
		//Verify if the Add to cart page is opened
		assertTrue(acp.isPageOpened("tokyo-talkies"),"Add to cart page is not opened");
	}

}
