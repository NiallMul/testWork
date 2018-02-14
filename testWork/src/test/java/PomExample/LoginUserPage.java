package PomExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUserPage {
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement userNameLogin;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement userPasswordLogin;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement loginUser;

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	private WebElement successText;
	
	public void enterUsername(String value) {
		this.userNameLogin.sendKeys(value);
	}
	public void enterPassword(String value) {
		this.userPasswordLogin.sendKeys(value);
	}
	public void login() {
		this.loginUser.click();
	}
	public boolean verifyLogin() {
		String loginText = successText.getText();
		return successText.isDisplayed() && !"**Failed Login**".equals(loginText);
	}
}
