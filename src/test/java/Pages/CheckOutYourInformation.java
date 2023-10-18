package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutYourInformation extends BaseTest {
    public CheckOutYourInformation() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(css = ".btn_primary.cart_button")
    public WebElement continueButton;

    //====================================

    public void inputFirstName() {
        firstName.sendKeys("Marko");
    }

    public void inputLastName() {
        lastName.sendKeys("Kraljevic");
    }

    public void inputPostalCode() {
        postalCode.sendKeys("11000");
    }

    public void clickOnContinue() {
        continueButton.click();
    }


}
