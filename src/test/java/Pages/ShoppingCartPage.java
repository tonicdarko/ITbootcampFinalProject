package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseTest {
    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn_action.checkout_button")
    public WebElement checkoutButton;

    //========================================

    public void clickOnCheckOutButton() {
        checkoutButton.click();
    }

}
