package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomOrderSummary {

	@FindBy(css = "#cart_navigation > button > span")
	private WebElement confirmOrder;
	
	@FindBy(css = "#center_column > div > p > strong")
	private WebElement successOrder;
	
	@FindBy(css = "#center_column > p")
	private WebElement emptyCart;
}
