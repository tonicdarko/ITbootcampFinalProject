package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public LoginPage loginPage;
    public ProductPage productPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckOutYourInformation checkOutYourInformation;
    public FinishOrder finishOrder;
    public ThankYouOrder thankYouOrder;
    public CheckOutOverview checkOutOverview;
    public String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
    public String expectedFinishOrderURL = "https://www.saucedemo.com/v1/checkout-complete.html";
    public String expectedThankYouText = "THANK YOU FOR YOUR ORDER";
    public String expectedLoginPageURL = "https://www.saucedemo.com/v1/index.html";
    public String expectedStepOneInformationURL = "https://www.saucedemo.com/v1/checkout-step-one.html";
    public String expectedCheckOutStepTwoURL = "https://www.saucedemo.com/v1/checkout-step-two.html";
    public String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    public String expectedLockedOutMessage = "Epic sadface: Sorry, this user has been locked out.";
    public static ExcelReader excelReader;

    public void logInMethod() {
        String userName = excelReader.getStringData("TestCredentials", 1, 0);
        String password = excelReader.getStringData("TestCredentials", 1, 1);
        loginPage.inputUserName(userName);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }

    public void logInvalidMethod() {
        String userName = excelReader.getStringData("TestCredentials", 2, 2);
        String password = excelReader.getStringData("TestCredentials", 2, 3);
        loginPage.inputUserName(userName);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }

    public void logLockedOutUserMethod() {
        String userName = excelReader.getStringData("TestCredentials", 1, 2);
        String password = excelReader.getStringData("TestCredentials", 1, 3);
        loginPage.inputUserName(userName);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }

    public void fillInYourInformation() {
        checkOutYourInformation.inputFirstName();
        checkOutYourInformation.inputLastName();
        checkOutYourInformation.inputPostalCode();
        checkOutYourInformation.clickOnContinue();
    }

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("src\\test\\java\\UsernameAndPassword.xlsx");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutYourInformation = new CheckOutYourInformation();
        finishOrder = new FinishOrder();
        thankYouOrder = new ThankYouOrder();
        checkOutOverview = new CheckOutOverview();

    }

}
