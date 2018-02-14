package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMAccountPage {
	@FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
	private WebElement accName;
	
	public boolean isCorrectName(String name) {
		if (accName.equals(name))
			return true;
		return false;
	}
}
