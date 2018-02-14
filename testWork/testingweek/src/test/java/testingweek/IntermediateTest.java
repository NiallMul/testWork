package testingweek;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PomExample.AddUserPage;
import PomExample.LoginUserPage;
import PomExample.MainPage;
import Screenshot.ScreenShot;
import reporting_example.ExtentReportManager;
import reporting_example.ReportDetails;

public class IntermediateTest {
/*
Login Test -
Set up a test that will go to this website - http://thedemosite.co.uk – and create a user then log in as that user and assert it was successful.
*/
	private WebDriver webDriver;
	private MainPage mainPage;
	private AddUserPage addUserPage;
	private LoginUserPage loginUserPage;
	private static ExtentReports report;
	private static final String TEST_URL = "http://thedemosite.co.uk/";
	
	@BeforeClass
	public static void init() {
		 report = new ExtentReports(); 
		 String fileName = "LoginTests" + ".html";
		 String filePath = System.getProperty("user.dir") + File.separatorChar + fileName; 
		 report.attachReporter(new ExtentHtmlReporter(filePath));
		 }
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		mainPage = PageFactory.initElements(webDriver, MainPage.class);
	}
	@Test
	public void loginTest() {
		ExtentTest test = report.createTest("SuccessfulLoginTest");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, AddUserPage.class);
		
		addUserPage.enterNewUsername("user1");
		addUserPage.enterNewPassword("password");
		addUserPage.saveNewUser();
		addUserPage.loginPage();

		loginUserPage = PageFactory.initElements(webDriver, LoginUserPage.class);
		loginUserPage.enterUsername("user1");
		loginUserPage.enterPassword("password");
		loginUserPage.login();
		
		boolean successfulLogin = loginUserPage.verifyLogin();
		String result = Boolean.toString(successfulLogin);
		test.log(Status.INFO, result);
		Assert.assertTrue("Unsuccessful login", successfulLogin);		
	}
	
	@Test
	public void failedLoginTest() throws IOException{
		ExtentTest test = report.createTest("FailedLoginTest");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, AddUserPage.class);
		
		addUserPage.enterNewUsername("user1");
		addUserPage.enterNewPassword("password");
		addUserPage.saveNewUser();
		addUserPage.loginPage();

		loginUserPage = PageFactory.initElements(webDriver, LoginUserPage.class);
		loginUserPage.enterUsername("user2");
		loginUserPage.enterPassword("waaagh");
		loginUserPage.login();
		
		boolean successfulLogin = loginUserPage.verifyLogin();
		String imgPath = ScreenShot.take(webDriver, "failed login");
		test.addScreenCaptureFromPath(imgPath);
		String result = Boolean.toString(successfulLogin);
		test.log(Status.INFO, result);	
		try{
			Assert.assertFalse("Unsuccessful test", successfulLogin);
            test.pass("Passed");
        } catch (AssertionError e) {
            String details = "This test failed: " + e.getMessage();
            test.fail(details);
            throw e;
        }
    }
	@After
	public void cleanup() {
		System.out.println("After");
		webDriver.quit();
	}
	@AfterClass
	public static void teardown() {
		report.flush();
	}
}


/*
	WebElement element = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")); 
	element.click();
	WebElement userName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
	userName.sendKeys("user1");
	WebElement userPassword = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
	userPassword.sendKeys("password");
	WebElement saveUser = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
	saveUser.click();
	WebElement login = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")); 
	login.click();
	WebElement userNameLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
	userNameLogin.sendKeys("user1");
	WebElement userPasswordLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
	userPasswordLogin.sendKeys("password");
	WebElement loginUser = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
	loginUser.click();
	WebElement successText = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
	Assert.assertTrue("Was not equal",successText.getText().equals("**Successful Login**"));
*/