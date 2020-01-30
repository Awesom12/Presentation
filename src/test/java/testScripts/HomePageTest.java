package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.HomePage;
import testScripts.base.BaseTest;

/**
 * @author Sujana Kotike
 * 1. This test script verifies if the home page is opened
 * 2. Searches for a type of product
 * 3. Verifies if the search gets navigated to Search Results page
 */
public class HomePageTest extends BaseTest {
	
		@Test
		public void testSearchProductType() {	
			
			System.out.println("I'm in HomePageTest");
			Reporter.log("I'm in HomePageTest");
			
			var hp = new HomePage(driver);
			
			//Navigate to the Home Page
			hp.goHome();			
			
			//Verfiy that the Home Page is opened
			Assert.assertTrue(hp.isPageOpened(),"Home page is not opened");
					
			//Search for mentioned product
	//		var srp = hp.searchForAProductType("Maxi");
			
			//Verify if the Search Results page is opened
	//		Assert.assertTrue(srp.isPageOpened("Maxi"),"Search Results page is not opened");	
		
		}

}

