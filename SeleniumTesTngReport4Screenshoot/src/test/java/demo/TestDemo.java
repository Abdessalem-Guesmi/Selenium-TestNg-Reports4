package demo;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.HomePageFactory;
import pomPages.LoginPageFactory;
import test.utils.Basic;

public class TestDemo {
	LoginPageFactory loginPage;
	HomePageFactory homePage;
	Basic basic;
	public WebDriver driver = null;

	@DataProvider(name = "dataForLogin")
	public Object dataForLogin() {
		Object[][] data = new Object[2][2];
		data[0][0] = "sselenium674@gmail.com";
		data[0][1] = "Selenium01";

		// 2nd row
		data[1][0] = "sselenium674@gmail.com";
		data[1][1] = "Selenium02";
		return data;
		/*
		 * 
		 * new Object[][]{
		 * 
		 * { "sselenium674@gmail.com", "abdou01" }, { "sselenium674@gmail.com",
		 * "Selenium01" } };
		 * 
		 * }
		 */
	}

	@Test(priority = 1, dataProvider = "dataForLogin")
	public void testLogin(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		loginPage = new LoginPageFactory(driver);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@Test(priority = 2)
	public void testHomePage() {
		loginPage = new LoginPageFactory(driver);
		loginPage.enterUsername("sselenium674@gmail.com");
		loginPage.enterPassword("Selenium01");
		loginPage.clickLogin();
		homePage = new HomePageFactory(driver);

		assertFalse(homePage.checkckLinkText());

	}

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
