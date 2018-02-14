package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomDeliveryType {
	@FindBy(css = "#form > p > button > span")
	private WebElement proceedToCheckout;

	@FindBy(css = "#cgv")
	private WebElement aggreeChk;
}
