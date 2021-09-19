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

//    @FindBy(xpath = "(//span[@class='_16nzq18'])[1]")
//    private WebElement firstPrice;

    @FindBy(xpath = "(//span[@class='_16nzq18'])[1]/../../span")
    private List<WebElement> listFirstPrices;


//    @FindBy(xpath = "(//span[@class='_16nzq18'])[2]")
//    private WebElement secondPrice;

    @FindBy(xpath = "(//span[@class='_16nzq18'])[1]/../../span")
    private List<WebElement> listSecondPrices;

    @FindBy(xpath = "(//button[@data-auto-id ='saveForLater'])[1]")
    private WebElement firstSaveButton;

    @FindBy(xpath = "(//div[@data-auto-id ='productTileDescription'])[1]//p")
    private WebElement firstSaveProductTitle;

    @FindBy(xpath = "//a[contains(@href,'saved-list')]")
    private WebElement goToSaveListButton;

//    @FindBy(xpath = "//span[@class='_16nzq18']")
//    private List<WebElement> searchListPrices;
//
    @FindBy(xpath = "//img[@data-auto-id='productTileImage']")
    private List<WebElement> searchListImages;

//    @FindBy(css="(span[class='_16nzq18']span[style='font-size: 14px'])[1]")
//    private WebElement firstPrice;

// driver.findElement(By.cssSelector("div[class='ajax_enabled'] [style='display:block']"));
    // @FindBy(css="a[da-qid='inventory']")
    // List<WebElement> elements;
    // WebElement fsize = driver.findElement(By.id(“abc”)).getCssValue(“font-size”);




    public String getTextOfSearchResultTitle() { return titleSearchResult.getText(); }

    public WebElement getTitle() { return titleSearchResult; }

    public WebElement getSortButton() { return sortButton; }

    public void clickSortButton() { sortButton.click(); }

    public void clickSortPriceHighToLowButton() { sortPriceHighToLowButton.click(); }

    public WebElement getPriceHighToLowButton() {
        return sortPriceHighToLowButton;
    }

//    public WebElement getFirstPrice() { return firstPrice; }
//
//    public WebElement getSecondPrice() { return secondPrice; }

    public String getFirstPriceText() { return listFirstPrices.get(listFirstPrices.size()-1).getText();}

            // Boolean isPresent = driver.findElements(By.yourLocator).size() > 0
        // //div[@class='_1MVUcS8']  - скидка на фото


    public String getSecondPriceText() { return listSecondPrices.get(listSecondPrices.size()-1).getText(); }

    public WebElement getFirstSaveButton() {return firstSaveButton; }

    public void clickFirstSaveButton() { firstSaveButton.click(); }

    public WebElement getFirstSaveProductTitle() {return firstSaveProductTitle; }

    public String getFirstSaveProductTitleText() { return firstSaveProductTitle.getText(); }

    public void clickGoToSaveListButton() {
        goToSaveListButton.click();
    }

//    public String getLastPriceText() { return searchListPrices.get(searchListPrices.size()).getText(); }
//
//    public WebElement getLastPrice() { return searchListPrices.get(searchListPrices.size()); }

    public WebElement getLastImage() { return searchListImages.get(searchListImages.size()-1); }



}
