package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import pages.CartPage;
import testScripts.base.BaseTest;

/**
 * @author Sujana Kotike
 * This test script:
 * 1. Adds a product to the cart from API instead of from UI (This functionality is already 
 * tested on UI hence taking the short cut, so that the script executes faster and will be less flaky)
 * 2. Navigates to the cart page directly
 * 3. Verifies if the added cart item is present in the cart
 * 4. Clears the cart and
 * 5. Verifies the status of the cart
 */
public class ClearShoppingCartTest extends BaseTest{
	

	@BeforeMethod
	public void addProduct() throws UnirestException {
	String body = 
	
				Unirest.post("http://shop.demoqa.com/product/tokyo-talkies/")
	.field("attribute_color", "Red")
	.field("attribute_size", "M")
	.field("quantity", 1)
	.field("add-to-cart",704)
	.field("product_id", 704)
	.field("variation_id", 1153)	
	.asString()
    .getBody();
	
	assertNotNull(body);
	assertTrue(body.contains("Tokyo Talkies"));
	
	System.out.println("Post request successful: " +body.contains("Tokyo Talkies"));
 
	}
	
	@Test
	public void clearShoppingCart() {		
		
		System.out.println("I'm in ClearShoppingCartTest");
		
		var cp = new CartPage(driver);
		
		//Go to the cart page
		cp.goToCartPage();
		
		//Verify if the Add to cart page is opened
		assertTrue(cp.isPageOpened(),"Cart page is not opened");
		
		//Verify if a cart item is present in the cart
		assertTrue(cp.isCartItemPresent(),"Cart item is not present in the cart");		
		
		//Remove the all the items from shopping cart
		cp.clearShoppingCart();
		
		//Verify that the cart is empty
		assertEquals(cp.getCartStatus(),"Your cart is currently empty.");
		
	}

}
