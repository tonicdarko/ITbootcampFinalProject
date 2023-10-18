package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWebPage extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1");
    }

    @Test(priority = 5)
    public void userLogin() throws InterruptedException {

        logInMethod();

        Thread.sleep(500);

        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(productPage.shoppingCart.isDisplayed());

    }

    @Test(priority = 10)
    public void userSortItems() throws InterruptedException {

        logInMethod();

        Thread.sleep(500);

        productPage.clickOnProductSorter();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Name (Z to A)")).click();

        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(productPage.shoppingCart.isDisplayed());

    }


    @Test(priority = 15)
    public void addItemsToShoppingChart() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);
        productPage.clickOnAddingButton();
        productPage.clickOnAddingButton();

        Assert.assertNotEquals(productPage.countNumber(), 0);

    }

    @Test(priority = 20)
    public void removeItemsFromShoppingChart() throws InterruptedException {
        logInMethod();
        Thread.sleep(1000);

        productPage.clickOnAddingButton();
        productPage.clickOnAddingButton();
        productPage.clickOnRemoveButton();
        productPage.clickOnRemoveButton();
        productPage.clickOnRemoveButton();
        productPage.clickOnRemoveButton();

        Thread.sleep(1000);

        Assert.assertEquals(productPage.countNumber(), 0);

    }


    @Test(priority = 25)
    public void clickOnShoppingCart() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);

        productPage.clickOnShoppingCart();

        Assert.assertTrue(shoppingCartPage.checkoutButton.isDisplayed());

    }

    @Test(priority = 30)
    public void clickOnCheckoutButton() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);

        productPage.clickOnShoppingCart();
        Thread.sleep(1000);
        shoppingCartPage.clickOnCheckOutButton();

        Assert.assertEquals(driver.getCurrentUrl(), expectedStepOneInformationURL);
        Assert.assertTrue(checkOutYourInformation.continueButton.isDisplayed());
    }

    @Test(priority = 35)
    public void clickOnContinueYourInformation() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);

        productPage.clickOnShoppingCart();
        Thread.sleep(1000);
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);
        fillInYourInformation();

        Assert.assertEquals(driver.getCurrentUrl(), expectedCheckOutStepTwoURL);
        Assert.assertTrue(checkOutOverview.finishButton.isDisplayed());

    }

    @Test(priority = 40)
    public void finishOrder() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);

        productPage.clickOnShoppingCart();
        Thread.sleep(1000);
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);
        fillInYourInformation();
        finishOrder.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), expectedFinishOrderURL);
        Assert.assertEquals(thankYouOrder.thankYouHeader.getText(), expectedThankYouText);

    }

    @Test(priority = 45)
    public void logOut() throws InterruptedException {
        logInMethod();
        Thread.sleep(2000);

        productPage.clickOnShoppingCart();
        Thread.sleep(1000);
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);
        fillInYourInformation();
        finishOrder.clickOnFinishButton();
        thankYouOrder.clickOnBurgerButton();
        Thread.sleep(1000);
        thankYouOrder.clickOnLogoutButton();

        Assert.assertEquals(expectedLoginPageURL, driver.getCurrentUrl());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 50)
    public void invalidUserLogin() throws InterruptedException {

        logInvalidMethod();
        Thread.sleep(2000);


        Assert.assertEquals(loginPage.error.getText(), expectedErrorMessage);
        Assert.assertTrue(loginPage.error.isDisplayed());
    }

    @Test(priority = 55)
    public void lockedOutUserLogin() throws InterruptedException {

        logLockedOutUserMethod();
        Thread.sleep(2000);


        Assert.assertEquals(loginPage.error.getText(), expectedLockedOutMessage);
        Assert.assertTrue(loginPage.error.isDisplayed());
    }


    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
