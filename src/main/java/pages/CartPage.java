package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class CartPage extends Test_Base{
	
//	obj Repo
	@FindBy (xpath = "//span[@class=\"title\"]") private WebElement cartTitle;
	@FindBy (xpath = "//button[@id=\"checkout\"]") private WebElement checkout;
	@FindBy (xpath = "//button[@id=\"continue-shopping\"]") private WebElement continueShopping;
	
	public CartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyCartURL() {
		return driver.getCurrentUrl();	
	}
	
	public String VerifyCartTitle() {
		return cartTitle.getText();	
	}
	
//	void es liye use kiya kyoki button par click hona chahiye
	public void ChechOutBtn() {
		checkout.click();
	}
	
//	public void continueShoppingBtn() {
//		continueShopping.click();
//		
//	}
//	first we have to click on cart. then we have to go inventory page and use click method
	
	

}
