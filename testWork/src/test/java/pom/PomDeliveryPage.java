package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomDeliveryPage {
	
	@FindBy(css = "#center_column > form > p > button > span")
	private WebElement proceedToCheckout;
}
