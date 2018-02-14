package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomCartPage {
	@FindBy(css = "#product_1_1_0_0 > td.cart_description > p > a")
	private WebElement productName;
	
	@FindBy(css = "#\\31 _1_0_52197 > i")
	private WebElement remove;
	
	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
	private WebElement proceedToCheckout;
}
