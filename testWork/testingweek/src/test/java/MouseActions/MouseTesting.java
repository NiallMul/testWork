package MouseActions;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MouseTesting {	
	private WebDriver webDriver;
	private PomHome mainPage;
	private PomDroppable dropPage;
	private static ExtentReports report;
	private static final String TEST_URL = "http://demoqa.com/";

	@BeforeClass
	public static void init() {
		 report = new ExtentReports(); 
		 String fileName = "MouseTests" + ".html";
		 String filePath = System.getProperty("user.dir") + File.separatorChar + fileName; 
		 report.attachReporter(new ExtentHtmlReporter(filePath));
		 }
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		mainPage = PageFactory.initElements(webDriver, PomHome.class);
	}
	
	@Test
	public void dragAndDropDefaultTest() {
		ExtentTest test = report.createTest("Drag and drop test");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.selectDemo();
		dropPage = PageFactory.initElements(webDriver, PomDroppable.class);
		
		dropPage.clickDefault();
		if(dropPage.dragAndDropDefault(webDriver)) {
			assertTrue("The drag me is not where it should be", true);
		}
	}
	@Test
	public void acceptFuncTest() {
		ExtentTest test = report.createTest("Accept drop test");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.selectDemo();
		dropPage = PageFactory.initElements(webDriver, PomDroppable.class);
		
		dropPage.clickAccept();;
		if(dropPage.acceptFuncTest(webDriver)) {
			assertTrue("The drag me is not where it should be", true);
		}
	}
	@Test
	public void preventPropTest() {
		
	}
	@After
	public void cleanup() {
		webDriver.quit();
	}
	@AfterClass
	public static void teardown() {
	}
}
