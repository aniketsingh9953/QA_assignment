package login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import factory.LoginPage;

public class Login extends Base {
	private static LoginPage loginPage;

	@BeforeMethod
	public static void setup() {
		initDriver();
		loginPage = new LoginPage(Driver);
		Driver.get("https://sakshingp.github.io/assignment/login.html");
	}

	@Test
	public static void loginWithValidCredentials() {
		loginPage.enterUserName("username");
		loginPage.enterPassword("password");
		loginPage.checkRemeberMeCheckbox();
		loginPage.clickLoginBtn();
		loginPage.verifyLoggedIn();
	}

	@Test
	public static void loginWithoutUsernamePassword() {
		loginPage.clickLoginBtn();
		loginPage.verifyLoginError("Both Username and Password must be present");
	}

	@Test
	public static void loginWithoutUsername() {
		loginPage.enterPassword("password");
		loginPage.clickLoginBtn();
		loginPage.verifyLoginError("Username must be present");
	}

	@Test
	public static void loginWithoutPassword() {
		loginPage.enterUserName("username");
		loginPage.clickLoginBtn();
		loginPage.verifyLoginError("Password must be present");
	}

	@AfterMethod
	public static void teardown() {
		Driver.quit();
	}
}
