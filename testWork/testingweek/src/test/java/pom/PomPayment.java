package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomPayment {
	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement payByWire;

	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(2) > div > p > a > span")
	private WebElement payByCheck;
}
