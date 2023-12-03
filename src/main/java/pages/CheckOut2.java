package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class CheckOut2 extends Test_Base{
	
	@FindBy (xpath = "//span[@class=\"title\"]") private WebElement checkout2Title;
	@FindBy (xpath = "(//div[@class=\"inventory_item_name\"])[1]") private WebElement inventory_item_name1;
	@FindBy (xpath = "//button[@id=\"finish\"]") private WebElement finishBtn;
//	@FindBy (xpath = "/") private WebElement checkout2Title;
//	@FindBy (xpath = "/") private WebElement checkout2Title;
//	@FindBy (xpath = "/") private WebElement checkout2Title;
//	@FindBy (xpath = "/") private WebElement checkout2Title;
	
	public CheckOut2() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkout2Titlepage() {
		return checkout2Title.getText();
	}
	
	public String inventory_item_name1page() {
		return inventory_item_name1.getText();
		
	}	
	
	public String getURLofCheckout2() {
		return driver.getCurrentUrl();
	}
	
	public void clickFinishBtn() throws InterruptedException {
//		Thread.sleep(4000);
		finishBtn.click();
	}

}
