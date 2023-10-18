package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    public WebElement error;

    //==================================

    public void inputUserName(String string) {
        userName.sendKeys(string);
    }

    public void inputPassword(String string) {
        password.sendKeys(string);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }


}
