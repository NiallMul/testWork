package MouseActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PomHome {
	@FindBy(css = "#menu-item-141 > a")
	private WebElement droppableMenu;
	
	public void selectDemo() {
		droppableMenu.click();
	}
}
