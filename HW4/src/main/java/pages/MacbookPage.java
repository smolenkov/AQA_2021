package pages;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.id;


public class MacbookPage extends BasePage{


    @FindBy(xpath = "//div[(@class='btns-cart-holder')]//a[text()= ' Продолжить покупки']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[contains(@class,'prod-cart')]//a[(@class= 'prod-cart__buy')][1]")
    private WebElement firstFieldMacbook;

    private static final String ADD_TO_CART_POPUP = "js_cart";

    public MacbookPage(WebDriver driver) { super(driver);}


    public void clickBuyFirstMacbookButton(){ firstFieldMacbook.click();}

    public void clickContinueShoppingButton() {continueShoppingButton.click();}

    public By getAddToCartPopup() { return id(ADD_TO_CART_POPUP);}


}

