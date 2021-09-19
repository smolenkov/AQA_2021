package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='search-term-banner']/p[@class='vp-JnyG']")
    private WebElement titleSearchResult;

    @FindBy(xpath = "//li[@data-dropdown-id ='sort']//button")
    private WebElement sortButton;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_high_to_low']")
    private WebElement sortPriceHighToLowButton;

    @FindBy(xpath = "(//span[@data-auto-id='productTilePrice']/span)[1]")
    private WebElement firstPrice;

    @FindBy(xpath = "(//span[@data-auto-id='productTilePrice']/span)[2]")
    private WebElement secondPrice;

    @FindBy(xpath = "(//button[@data-auto-id ='saveForLater'])[1]")
    private WebElement firstSaveButton;

    @FindBy(xpath = "(//div[@data-auto-id ='productTileDescription'])[1]//p")
    private WebElement firstSaveProductTitle;






    public String getTextOfSearchResultTitle() { return titleSearchResult.getText(); }

    public WebElement getTitle() { return titleSearchResult; }

    public WebElement getSortButton() { return sortButton; }

    public void clickSortButton() { sortButton.click(); }

    public void clickSortPriceHighToLowButton() { sortPriceHighToLowButton.click(); }

    public WebElement getPriceHighToLowButton() {
        return sortPriceHighToLowButton;
    }

    public WebElement getFirstPrice() { return firstPrice; }

    public WebElement getSecondPrice() { return secondPrice; }

    public String getFirstPriceText() { return firstPrice.getText(); }

    public String getSecondPriceText() { return secondPrice.getText(); }

    public WebElement getFirstSaveButton() {return firstSaveButton;}

    public void clickFirstSaveButton() { firstSaveButton.click(); }

    public String getFirstSaveProductTitleText() { return firstSaveProductTitle.getText(); }


}
