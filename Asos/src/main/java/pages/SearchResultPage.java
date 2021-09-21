package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "(//span[@class='_16nzq18'])[1]/../../span")
    private List<WebElement> listFirstPrices;


    @FindBy(xpath = "(//span[@class='_16nzq18'])[1]/../../span")
    private List<WebElement> listSecondPrices;

    @FindBy(xpath = "(//button[@data-auto-id ='saveForLater'])[1]")
    private WebElement firstSaveButton;

    @FindBy(xpath = "(//div[@data-auto-id ='productTileDescription'])[1]//p")
    private WebElement firstSaveProductTitle;

    @FindBy(xpath = "//a[contains(@href,'saved-list')]")
    private WebElement goToSaveListButton;

    @FindBy(xpath = "//img[@data-auto-id='productTileImage']")
    private List<WebElement> searchListImages;


    @FindBy(xpath = "//div[@role='region' and @data-testid='welcome-message']")
    private List<WebElement> deliveryBanner;

    @FindBy(xpath = "//div[@data-testid='welcome-message']//button[contains(@class, '_19qEA_b')]")
    private WebElement deliveryButton;




    public String getTextOfSearchResultTitle() { return titleSearchResult.getText(); }

    public WebElement getTitle() { return titleSearchResult; }

    public WebElement getSortButton() { return sortButton; }

    public void clickSortButton() { sortButton.click(); }

    public void clickSortPriceHighToLowButton() { sortPriceHighToLowButton.click(); }

    public WebElement getPriceHighToLowButton() {
        return sortPriceHighToLowButton;
    }

    public void clickFirstPrice() {listFirstPrices.get(0).click(); }

    public WebElement getFirstPriceLink() {return listFirstPrices.get(0); }

    public String getFirstPriceText() { return listFirstPrices.get(listFirstPrices.size()-1).getText();}

    public String getSecondPriceText() { return listSecondPrices.get(listSecondPrices.size()-1).getText(); }

    public WebElement getFirstSaveButton() {return firstSaveButton; }

    public WebElement getFirstSaveProductTitle() {return firstSaveProductTitle; }

    public String getFirstSaveProductTitleText() { return firstSaveProductTitle.getText(); }

    public void clickGoToSaveListButton() { goToSaveListButton.click(); }

    public WebElement getLastImage() { return searchListImages.get(searchListImages.size()-1); }

    public Float getSecondPrice() {
        return Float.parseFloat(getSecondPriceText().replaceAll("[^0-9.]", ""));
    }

    public Float getFirstPrice() {
        return Float.parseFloat(getFirstPriceText().replaceAll("[^0-9.]", ""));
    }


}
