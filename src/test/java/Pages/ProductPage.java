package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BaseTest {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCart;

    @FindBy(css = ".btn_primary.btn_inventory")
    public WebElement addingButton;

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x")
    public WebElement counter;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public WebElement removeButton;

    @FindBy(className = "product_sort_container")
    public WebElement productSorter;


    //==========================================

    public void clickOnAddingButton() {
        addingButton.click();
    }

    public int countNumber() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".fa-layers-counter.shopping_cart_badge"));
        int elementsCount = elements.size();
        return elementsCount;
    }

    public void clickOnShoppingCart() {
        counter.click();
    }

    public void clickOnRemoveButton() {
        removeButton.click();
    }

    public void clickOnProductSorter() {
        productSorter.click();
    }
}
