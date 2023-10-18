package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouOrder extends BaseTest {
    public ThankYouOrder() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    public WebElement thankYouHeader;

    @FindBy(className = "bm-burger-button")
    public WebElement burgerButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //=======================================


    public void clickOnBurgerButton() {
        burgerButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }


}
