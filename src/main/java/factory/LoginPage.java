package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "log-in")
	private WebElement loginBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement remeberMe;

	@FindBy(xpath = "//div[@role='alert' and @id!='alertEmpty']")
	private WebElement loginError;

	@FindBy(className = "logo")
	private WebElement logo;

	public void enterUserName(String name) {
		userName.sendKeys(name);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void checkRemeberMeCheckbox() {
		remeberMe.click();
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void verifyLoginError(String error) {
		Assert.assertEquals(error, loginError.getText());
	}

	public void verifyLoggedIn() {
		boolean isLogoDisplayed = logo.isDisplayed();
		Assert.assertTrue(isLogoDisplayed);
	}
}
