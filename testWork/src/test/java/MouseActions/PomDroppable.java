package MouseActions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PomDroppable {

	@FindBy(css = "#ui-id-1")
	private WebElement defaultFunc;
	@FindBy(css = "#draggableview > p")
	private WebElement dragMeDefault;
	@FindBy(css = "#droppableview > p")
	private WebElement dropMeDefault;
	
	@FindBy(css = "#ui-id-2")
	private WebElement acceptfunc;
	@FindBy(css = "#draggable-nonvalid > p")
	private WebElement draggable;
	@FindBy(css = "#draggableaccept > p")
	private WebElement draggableaccept;
	@FindBy(css = "#droppableaccept")
	private WebElement droppableaccept;
	
	
	@FindBy(css = "#ui-id-3")
	private WebElement preventPropa;
	@FindBy(css = "#draggableprop > p")
	private WebElement draggableprop;
	@FindBy(css = "#droppableprop > p")
	private WebElement droppableprop;
	@FindBy(css = "#droppable-inner > p")
	private WebElement droppable_inner;
	@FindBy(css = "#droppableprop2 > p")
	private WebElement droppableprop2;
	@FindBy(css = "#droppable2-inner > p")
	private WebElement droppable2_inner;
	
	@FindBy(css = "#ui-id-4")
	private WebElement revertDrag;
	@FindBy(css = "#ui-id-5")
	private WebElement cart;
	
	public void clickDefault() {
		defaultFunc.click();
	}
	public boolean dragAndDropDefault(WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.moveToElement(dragMeDefault).clickAndHold()
											.moveToElement(dropMeDefault)
											.release()
											.perform();
		if(dropMeDefault.getText().equalsIgnoreCase("Dropped!")) {
			return true;
		}
		return false;
	}
	public void clickAccept() {
		acceptfunc.click();
	}
	public boolean acceptFuncTest(WebDriver driver) {
		Actions builder = new Actions(driver);
		boolean everythingsGood = false;
		builder.moveToElement(draggable).clickAndHold()
											.moveToElement(droppableaccept)
											.release()
											.perform();
		if(droppableaccept.getText().equalsIgnoreCase("Dropped!")) {
			everythingsGood = false;
		}
		builder.moveToElement(draggableaccept).clickAndHold()
		.moveToElement(droppableaccept)
		.release()
		.perform();
		if(droppableaccept.getText().equalsIgnoreCase("Dropped!")) {
			everythingsGood = true;
		}
		return everythingsGood;
	}
	public void clickPreventProp() {
		preventPropa.click();
		
	}
	public boolean preventPropTest(WebDriver driver) {
		boolean groupA, groupB;
		groupA=groupB=false;
		Actions builder = new Actions(driver);
		
		builder.moveToElement(draggableprop).clickAndHold()
											.moveToElement(droppableaccept)
											.perform();
		if(droppableaccept.getCssValue("background-color").equalsIgnoreCase(arg0)) {
			
		}
		
		return false;
	}
	public void clickDrag() {
		revertDrag.click();
	}
	public void clickCart() {
		cart.click();
	}
}
