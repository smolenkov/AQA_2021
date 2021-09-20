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









    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton() {return addToCartButton; }

    public WebElement getCountOfProductInCart() {return countOfProductInCart; }

    public String getCountOfProductInCartText() { return countOfProductInCart.getText(); }


}
