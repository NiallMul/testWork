package testingweek;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitExample {

	private WebDriver webDriver;
	private static final String BASE_URL = "https://www.qa.com";
	
	@BeforeClass
	public static void init() {
		System.out.println("Before class");
	}
	@Before
	public void setUp() {
		System.out.println("Before");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	}
	@Test
	public void printTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement searchBar = webDriver.findElement(By.cssSelector("#select2-chosen-2")); 
		searchBar.sendKeys("THE SHAFEEQ");
	}
	@After
	public void cleanup() {
		System.out.println("After");
		webDriver.quit();
	}
	@AfterClass
	public static void teardown() {
		System.out.println("Tear down");
	}
}
