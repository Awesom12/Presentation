package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pages.AddToCartPage;
//import pages.CartPage;
import testScripts.base.BaseTest;

/**
 * @author Sujana Kotike 
 * 
 * This Test Script:
 * 1. Navigates to the Add to cart page directly(utilizing short cut) and
 * 2. Selects the color and size options
 * 3. Verifies if the options are selected
 * 4. Adds a specific product to the cart and
 * 5. Verfies if the add to cart functionality is successful
 */

public class AddProductToTheCartTest extends BaseTest{
	
	@Test(priority =1)
	public void testAddToCartFunctionality() {
		
		System.out.println("I'm in AddProductToTheCartTest");
	
	//Using 'var' which enables to skip the long class name and we'll call this acp(Introduced in Java 10)
	var acp = new AddToCartPage(driver);	
	
	String endPoint = "tokyo-talkies";
	
	// Go to the specific Page mentioned in the endpoint
	//Again utilizing the short cut
	acp.goAddToCartPage(endPoint);	
	
	//Verify if the Add to cart page is opened
	assertTrue(acp.isPageOpened(endPoint),"Add to cart page is not opened");
	
	//Select the color option from the drop down	
	String colorOption = "Red";
	acp.selectColorFromDropdown(colorOption);
	
	var selectedOptions = acp.getSelectedOptionsColor();
	
	//Verify if the mentioned option is selected
	assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
	assertTrue(selectedOptions.contains(colorOption), "Option not selected");
	
	
	//Select the size option from the drop down	
	String sizeOption = "L";
	acp.selectSizeFromDropdown(sizeOption);
	
	var selectedOptionsSize = acp.getSelectedOptionsSize();
	
	//Verify if the mentioned option is selected
	assertEquals(selectedOptionsSize.size(), 1, "Incorrect number of selections");
	assertTrue(selectedOptionsSize.contains(sizeOption), "Option not selected");
	
	//Add the item mentioned in the endpoint to the cart
	acp.AddItemToCart();
	assertTrue(acp.GetAlertText().contains("“Tokyo Talkies” has been added to your cart."));
	
	
}
	/*@AfterMethod
	public void emptyCart() throws UnirestException {
		
		int status =
				Unirest.delete("http://shop.demoqa.com/cart/?empty-cart") // ;
						.asString()
						.getStatus();
		System.out.println(status);
		             
		
	}*/
	
	/*@Test(priority =2)
	public void clearShoppingCart() {			
		
		var cp = new CartPage(driver);
		
		//Go to the cart page
		cp.goToCartPage();
		
		//Verify if the Add to cart page is opened
		assertTrue(cp.isPageOpened(),"Cart page is not opened");
		
		
		//Remove the all the items from shopping cart
		cp.clearShoppingCart();
		
		//Verify that the cart is empty
		assertEquals(cp.getCartStatus(),"Your cart is currently empty.");
		
	}*/
}