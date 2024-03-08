package home;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import factory.HomePage;
import factory.LoginPage;

public class Home extends Base {
	private static LoginPage loginPage;
	private static HomePage homePage;

	@BeforeMethod
	public static void setup() {
		initDriver();
		loginPage = new LoginPage(Driver);
		homePage = new HomePage(Driver);
		Driver.get("https://sakshingp.github.io/assignment/login.html");
		loginPage.enterUserName("username");
		loginPage.enterPassword("password");
		loginPage.checkRemeberMeCheckbox();
		loginPage.clickLoginBtn();
	}

	@Test
	public static void sortTransactionsAsPerAmounts() {
		homePage.clickAmountHeader();
		homePage.verifyRecordsSorted();
	}

	@AfterMethod
	public static void teardown() {
		Driver.quit();
	}
}
