package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomProductPage {
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement addUser;
	
	@FindBy(css = "#add_to_cart > button > span")
	private WebElement addProduct;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	private WebElement proceedToCheckout;
	
	public void addUser() {
		this.addUser.click();
	}
}
