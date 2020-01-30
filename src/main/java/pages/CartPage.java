/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Sujana Kotike
 * This class(Cart Page) contains the web elements of
 * Cart Page  and  the actions performed(methods) on those elements
 */
public class CartPage {
	
	private WebDriver driver;		

	//private By cartItem = By.xpath("//tr[@class='cart_item']");
	private By emptyCart = By.xpath("//a[@class='empty-cart']");	
	private By cartStatusInfo = By.xpath("//p[@class='cart-empty woocommerce-info']");
				
	
	public CartPage(WebDriver driver){
      this.driver = driver;      
    }
	
	
	
	public void goToCartPage() {
		driver.get("http://shop.demoqa.com/cart/");
	}
	
	public boolean isPageOpened() {				
		
		boolean CartPageOpened = driver.getCurrentUrl().contains("cart");
		if(CartPageOpened==true) {
			System.out.println("Cart page is opened");
		}
		
		return CartPageOpened;		
	}
	
	public boolean isCartItemPresent() {
		//return driver.findElement(cartItem).isDisplayed();
		 boolean displayed = false;
		try {
		    WebElement cartItem = driver.findElement(By.xpath("//tr[@class='cart_item']"));
		     displayed = cartItem.isDisplayed();		    
		    
		} catch (NoSuchElementException e) {
		    //perform other tasks
		}
		return displayed;
	}

	
	//Clear the Shopping Cart
	public void clearShoppingCart() {
		
		driver.findElement(emptyCart).click();
		
	}
	
	//Verify the status of the cart
	public String getCartStatus() {
		
		System.out.println(driver.findElement(cartStatusInfo).getText());
		return driver.findElement(cartStatusInfo).getText();
		
	}

}
