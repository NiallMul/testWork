package Website_Testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Screenshot.ScreenShot;
import pom.*;


public class WebStoreTests {
	private WebDriver webDriver;
	private PomWebStore mainPage;
	private PomSignInCreate addUserPage;
	private PomAccountCreation accntCreationPage;
	private POMAccountPage accountPage;
	private static ExtentReports report;
	private static final String TEST_URL = "http://automationpractice.com/index.php";
	
	@BeforeClass
	public static void init() {
		 report = new ExtentReports(); 
		 String fileName = "WebStoreTests" + ".html";
		 String filePath = System.getProperty("user.dir") + File.separatorChar + fileName; 
		 report.attachReporter(new ExtentHtmlReporter(filePath));
		 }
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		mainPage = PageFactory.initElements(webDriver, PomWebStore.class);
	}
	@Test
	public void createAccountTest() {
		ExtentTest test = report.createTest("Successful Account Creation");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, PomSignInCreate.class);
		addUserPage.addEmail("nmulready@hotmail15.com");
		addUserPage.createAcc();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accntCreationPage = PageFactory.initElements(webDriver, PomAccountCreation.class);
		accntCreationPage.setfName("Niall");
		accntCreationPage.setlName("Mul");
		accntCreationPage.setPassword("password");
		accntCreationPage.setAddress("Anchorage floor 5");
		accntCreationPage.setCity("Manchester");
		accntCreationPage.setState(1);
		accntCreationPage.setZip("00000");
		accntCreationPage.setCountry(1);
		accntCreationPage.setPhone("0833123585");
		accntCreationPage.setAlias("address");
		accntCreationPage.clickRegister();
		accountPage = PageFactory.initElements(webDriver, POMAccountPage.class);
		boolean isTrue = accountPage.isCorrectName("Niall Mul");
		String imgPath;
		try {
			imgPath = ScreenShot.take(webDriver, "Successful account creation");
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = Boolean.toString(isTrue);
		test.log(Status.INFO, result);	
		try{
			Assert.assertTrue("successful test", isTrue);
            test.pass("Passed");
        } catch (AssertionError e) {
            String details = "This test failed: " + e.getMessage();
            test.fail(details);
            throw e;
        }
	}

	@Test
	public void createAccountTestFail() {
		ExtentTest test = report.createTest("Successful failed Account Creation test");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, PomSignInCreate.class);
		addUserPage.addEmail("nmulready@hotmail.com");
		addUserPage.createAcc();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isShown = addUserPage.cantCreateShown();
		String imgPath;
		try {
			imgPath = ScreenShot.take(webDriver, "Successful failed account creation test");
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = Boolean.toString(isShown);
		test.log(Status.INFO, result);	
		try{
			Assert.assertTrue("unsuccessful test", isShown);
            test.pass("Passed");
        } catch (AssertionError e) {
            String details = "This test failed: " + e.getMessage();
            test.fail(details);
            throw e;
        }
}

	@Test
	public void loginSuccessTest() {
		ExtentTest test = report.createTest("Successful login");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, PomSignInCreate.class);
		addUserPage.setUserEmail("niallmulready@gmail.com");
		addUserPage.setPassword("Hivemind101");
		addUserPage.loginBtn();
		accountPage = PageFactory.initElements(webDriver, POMAccountPage.class);
		boolean isTrue = accountPage.isCorrectName("Niall Mulready");
		String imgPath;
		try {
			imgPath = ScreenShot.take(webDriver, "Successful failed login test");
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = Boolean.toString(isTrue);
		test.log(Status.INFO, result);	
		try{
			Assert.assertTrue("unsuccessful test", isTrue);
            test.pass("Passed");
        } catch (AssertionError e) {
            String details = "This test failed: " + e.getMessage();
            test.fail(details);
            throw e;
        }
	}
	@Test
	public void loginFailedTest() {
		ExtentTest test = report.createTest("Successful failed login");
		webDriver.navigate().to(TEST_URL);
		
		mainPage.addUser();
		addUserPage = PageFactory.initElements(webDriver, PomSignInCreate.class);
		addUserPage.setUserEmail("niallmulry@gmail.com");
		addUserPage.setPassword("Hive");
		addUserPage.loginBtn();

		boolean isShown = addUserPage.failedLogin();		
		String imgPath;
		try {
			imgPath = ScreenShot.take(webDriver, "failed login");
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = Boolean.toString(isShown);
		test.log(Status.INFO, result);	
		try{
			Assert.assertTrue("unsuccessful test", isShown);
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
