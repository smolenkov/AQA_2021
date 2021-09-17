package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;



public class SearchPage extends BasePage{

    @FindBy(xpath = "//span[@class='shopping-cart__count']")
    private WebElement countOfCart;

    @FindBy(xpath = "//button[contains(@class, 'buy-button')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[contains(@class, 'products-layout__item')]")
    private List <WebElement> searchResult;

    @FindBy(xpath = "//div[@class ='v-modal__cmp-header']")
    private WebElement addToCartPopupHeader;

    @FindBy(xpath = "//button[@class='comeback']")
    private WebElement comeBackButton;

    @FindBy(xpath = "//div[@class='shopping-cart__mobile-click']")
    private WebElement cartField;

    @FindBy(xpath = "//*[contains(@class, 'v-icon sprite-shared remove v-icon v-icon__close')]")
    private WebElement removeFromCartField;

    @FindBy(xpath = "//div[@class='cart-popup__content']//a[contains(@href,'https://allo.ua/')]")
    private WebElement backToSiteFromCart;




    public SearchPage(WebDriver driver) { super(driver); }

    public List<WebElement> getSearchResultList(){ return searchResult;}

    public int getSearchResultsCount() {
        return getSearchResultList().size();
    }

    public WebElement getAddToCartPopup() { return addToCartPopupHeader;}

    public WebElement getComeBackButton() { return comeBackButton;}

    public WebElement getBackToSiteFromCart() { return backToSiteFromCart;}

    public WebElement getRemoveFromCartField() { return removeFromCartField;}

    public WebElement getCartField() { return cartField;}

    public void clickBuyButton() {
        buyButton.click();
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public void clickComeBackButton() { comeBackButton.click();}

    public String getTextFromCartsCount(){return countOfCart.getText();}


    public void clickOnCartField(){WebElement element = cartField;
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);}

    public void clickOnRemoveFromCartField() { removeFromCartField.click();}

    public void clickOnBackToSiteFromCart() { backToSiteFromCart.click();}





}
