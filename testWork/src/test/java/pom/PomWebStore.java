package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomWebStore {
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement addUser;
	
	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
	private WebElement product;
	
	public void addUser() {
		this.addUser.click();
	}
}
