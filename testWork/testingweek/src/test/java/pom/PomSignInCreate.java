package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomSignInCreate {
	@FindBy(css = "#email_create")
	private WebElement email;
	
	@FindBy(css = "#SubmitCreate > span")
	private WebElement createAcc;
	
	@FindBy(css = "#email")
	private WebElement userEmail;
	
	@FindBy(css = "#passwd")
	private WebElement password;
	
	@FindBy(css = "#SubmitLogin > span")
	private WebElement loginBtn;
	
	@FindBy(css="#create_account_error > ol > li")
	private WebElement cantCreate;
	
	@FindBy(css="#center_column > div.alert.alert-danger > ol > li")
	private WebElement failedLogin;
	
	public void addEmail(String email) {
		this.email.sendKeys(email);
	}

	public void createAcc() {
		this.createAcc.click();
	}

	public void setUserEmail(String userEmail) {
		this.userEmail.sendKeys(userEmail);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void loginBtn() {
		this.loginBtn.click();
	}
	
	public Boolean cantCreateShown() {
		if(cantCreate.isDisplayed())
			return true;
		return false;
	}
	public Boolean failedLogin() {
		if(failedLogin.isDisplayed())
			return true;
		return false;
	}
	
}
