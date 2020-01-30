/**
 * 
 */
package pages;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * @author Sujana Kotike
 * This class(Add to Cart Page) contains the web elements of
 * Add to Cart Page  and  * the actions performed(methods) on those elements
 */
public class AddToCartPage {
	
	private WebDriver driver;	
	
	private By chooseColor = By.xpath("//select[@id='color']");
	private By chooseSize = By.xpath("//select[@id='size']");	
	private By addToCart = By.xpath("//button[text()='Add to cart']");	
	private By alertText = By.xpath("//div[@role='alert']");
			
		
	public AddToCartPage(WebDriver driver){
      this.driver = driver;      
    }
	
	public void goAddToCartPage(String endPoint) {
		driver.get("http://shop.demoqa.com/product/"+endPoint);
	}
	
	/*public void goAddToCartPage() {
		driver.get("http://shop.demoqa.com/product/pink-fruit-graphic-fitted-t-shirt/");
	}*/
	
	public boolean isPageOpened(String sProduct) {				
		
		boolean AddToCartPageOpened = driver.getCurrentUrl().contains(sProduct);
		if(AddToCartPageOpened==true) {
			System.out.println("Add To Cart page is opened");
		}
		
		return AddToCartPageOpened;		
	}
		
	
	public void selectColorFromDropdown(String option) {
		Select dropdownElement = findColorDropDownElement();
		dropdownElement.selectByVisibleText(option);
	}
	
	public List<String> getSelectedOptionsColor(){
        List<WebElement> selectedElements = findColorDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
	
   private Select findColorDropDownElement(){
	        return new Select(driver.findElement(chooseColor));
	    }
   
   
   public void selectSizeFromDropdown(String option) {
		Select dropdownElement = findSizeDropDownElement();
		dropdownElement.selectByVisibleText(option);
	}

	public List<String> getSelectedOptionsSize(){
        List<WebElement> selectedElements = findSizeDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
	
   private Select findSizeDropDownElement(){
	        return new Select(driver.findElement(chooseSize));
	    }
   
   
   public void AddItemToCart() {
	   driver.findElement(addToCart).click();
   }
   
   public String GetAlertText() {
	   System.out.println(driver.findElement(alertText).getText());
	   return driver.findElement(alertText).getText();
   }

   

}
