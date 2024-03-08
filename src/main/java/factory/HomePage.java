package factory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "amount")
	private WebElement amountHeader;

	@FindBys({ @FindBy(xpath = "//table[@id='transactionsTable']//tbody//tr//td[last()]") })
	private List<WebElement> amounts;

	public void clickAmountHeader() {
		amountHeader.click();
	}

	public void verifyRecordsSorted() {
		int previousAmount = Integer.MIN_VALUE;
		for (WebElement amount : amounts) {
			String[] texts = amount.getText().split(" ");
			int currentAmount = Integer
					.parseInt(texts[0] + texts[1].substring(0, texts[1].length() - 3).replaceAll(",", ""));
			Assert.assertTrue(previousAmount < currentAmount);
		}
	}
}
