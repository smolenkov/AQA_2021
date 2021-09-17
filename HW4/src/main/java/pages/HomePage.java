package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='search-form__input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'search-form__submit-button')]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public boolean isSearchButtonVisible() {
        return searchButton.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchInput.isDisplayed();
    }

    public void searchByKeyword(final String keyword) { searchInput.sendKeys(keyword); }

    public void clickSearchButton(){WebElement element = searchButton;
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);}

}
