package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PomAccountCreation {

	@FindBy(css = "#customer_firstname")
	private WebElement fName;
	
	@FindBy(css = "#customer_lastname")
	private WebElement lName;
	
	@FindBy(css = "#email")
	private WebElement email;
	
	@FindBy(css = "#passwd")
	private WebElement password;

	@FindBy(css = "#address1")
	private WebElement address;

	@FindBy(css = "#city")
	private WebElement city;

	@FindBy(css = "#id_state")
	private WebElement state;

	@FindBy(css = "#postcode")
	private WebElement zip;

	@FindBy(css = "#id_country")
	private WebElement country;

	@FindBy(css = "#phone_mobile")
	private WebElement phone;

	@FindBy(css = "#alias")
	private WebElement alias;

	@FindBy(css = "#submitAccount > span")
	private WebElement register;

	public void setfName(String fName) {
		this.fName.sendKeys(fName);
	}

	public void setlName(String lName) {
		this.lName.sendKeys(lName);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void setAddress(String address) {
		this.address.sendKeys(address);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setState(int index) {
		Select dropdown = new Select(this.state);
		dropdown.selectByIndex(index);
		//this.state.sendKeys(dropdown.toString());
	}

	public void setZip(String zip) {
		this.zip.sendKeys(zip);
	}

	public void setCountry(int country) {
		Select dropdown = new Select(this.state);
		dropdown.selectByIndex(country);
		//this.country.sendKeys(dropdown.toString());
	}

	public void setPhone(String phone) {
		this.phone.sendKeys(phone);
	}

	public void setAlias(String alias) {
		this.alias.sendKeys(alias);
	}

	public void clickRegister() {
		this.register.click();
	}
	
}
