package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;
import utility.HandleDropDown;

public class InventoryPage extends Test_Base{
	// object repository heps to identify the web element by using xpath
	@FindBy (xpath="//span[@class=\"title\"]") private WebElement ProductTitleText;
	@FindBy (xpath= "//li[@class=\"social_twitter\"]") private WebElement twitterLogo;
	@FindBy (xpath= "//button[@id=\"add-to-cart-sauce-labs-backpack\"]") private WebElement backpack;
	@FindBy (xpath= "//button[@id=\"add-to-cart-sauce-labs-bike-light\"]") private WebElement bikelight;
	@FindBy (xpath= "//button[@id=\"remove-sauce-labs-bike-light\"]") private WebElement removeBikelight;	
	@FindBy (xpath= "//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]") private WebElement bolttshirt;
	@FindBy (xpath= "//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]") private WebElement fleecejacket;
	@FindBy (xpath= "//button[@id=\"add-to-cart-sauce-labs-onesie\"]") private WebElement onesie;
	@FindBy (xpath= "//button[@id=\"remove-sauce-labs-onesie\"]") private WebElement removeOnesie;
	@FindBy (xpath= "//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]") private WebElement redTshirt;
	@FindBy (xpath= "//select[@class=\"product_sort_container\"]") private WebElement selectFilter;
	@FindBy (xpath= "//span[@class=\"shopping_cart_badge\"]") private WebElement cartCount;
	
	// constructor is call when class of obj is created
	public InventoryPage(){
		PageFactory.initElements(driver, this);
	}
	// create method 
	public String VerifyProductLabel() {
//		xpath.method
		return ProductTitleText.getText();
		
	}
//	to indentify the logo, image
	public boolean VerifyLogo() {
		return twitterLogo.isDisplayed();
	}
	
	public String verifyNumElementCart() {
		// select is class, now we have use elect class so many times in a application at diff. places then we create separte class
//		className.method(parameter)
		HandleDropDown.dropDownClass(selectFilter , "Price (low to high)");
//		Select s = new Select(selectFilter);
//		s.selectByVisibleText("Price (low to high)");
		backpack.click();
		bikelight.click();
		bolttshirt.click();
		fleecejacket.click();
		onesie.click();
		redTshirt.click();
		selectFilter.click();
		return cartCount.getText();
		
	}
	
//interview ques. how to excecute failed test cases	
//	Note: Dynamic element ka more then 1 xpath hota hai. here in this case add to cart and remove element
	public String removeToCart() throws InterruptedException {	
		verifyNumElementCart();
//		Thread.sleep(4000);
		removeOnesie.click();
		removeBikelight.click();
		return cartCount.getText();
	}

	public void clickCartCount() {
		cartCount.click();
	}
 
}
