package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='add-item']/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement countOfProductInCart;

    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement countOfEmptyCart;

    @FindBy(xpath = "//button[@aria-label='Delete this item']")
    private WebElement deleteProductButton;











    public void clickAddToCartButton () {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton () {return addToCartButton; }

    public WebElement getCountOfProductInCart () {return countOfProductInCart; }

    public WebElement getCountOfEmptyCart () {return countOfEmptyCart; }


    public void clickCountOfProductInCart () { countOfProductInCart.click(); }

    public String getCountOfProductInCartText () { return countOfProductInCart.getText(); }

    public WebElement getDeleteProductButton () {return deleteProductButton; }

    public void clickDeleteProductButton() {deleteProductButton.click(); }


}
