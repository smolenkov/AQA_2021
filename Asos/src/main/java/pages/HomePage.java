package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage{

    @FindBy(xpath = "//form//select[@id='country']")
    private WebElement listOfCountries;

    @FindBy(xpath = "//form//select[@id='currency']")
    private WebElement listOfCurrency;

    @FindBy(xpath = "(//button[@data-testid = 'country-selector-btn'])[1]")
    private WebElement countrySelectorButton;

    @FindBy(xpath = "//button[@type='submit' and @data-testid='save-country-button']")
    private WebElement applyChangesButton;

    @FindBy(xpath = "(//button[@data-testid = 'country-selector-btn'])[2]/../span")
    private WebElement inscriptionShoppingFrom;

    @FindBy(xpath = "//input[@type ='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type ='submit'  and @data-testid ='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='myAccountDropdown']/button")
    private WebElement signUpDropDownButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//a[@data-testid='myaccount-link']")
    private WebElement goToSignUpPageButton;

    @FindBy(xpath = "//div[@data-testid='topbar']//a[contains(@href,'https://marketplace.asos.com')]")
    private WebElement marketplaceLink;






    public HomePage(WebDriver driver) { super(driver);}

    public void openHomePage(String url) { driver.get(url); }

    public void clickOnCountrySelectorButton() {
        countrySelectorButton.click();
    }

    public WebElement getListOfCountries() {
        return listOfCountries;
    }

    public WebElement getListOfCurrency() { return listOfCurrency; }

    public void openListOfCountries() {
        listOfCountries.click();
    }

    public void openListOfCurrency() { listOfCurrency.click(); }

    public WebElement countryInList(String country) { return
            driver.findElement(xpath("//select[@id='country']//option[contains(text(), '"+country+"')]")); }

    public WebElement currencyInList(String currency) { return
            driver.findElement(xpath("//select[@id='currency']//option[contains(text(), '"+currency+"')]")); }

    public void clickToChooseCountry(String country) {
        countryInList(country).click();
    }

    public void clickToChooseCurrency(String currency) { currencyInList(currency).click(); }

    public WebElement getApplyChangesButton() {
        return applyChangesButton;
    }

    public void clickOnApplyChanges() {
        applyChangesButton.click();
    }

    public WebElement inscriptionShoppingFrom() {
        return inscriptionShoppingFrom;
    }

    public String getTextOfSettingsInscription() {
        return inscriptionShoppingFrom.getText();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText); }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignUpButton() {
        signUpDropDownButton.click();
    }

    public WebElement getSignUpDropDownButton() {
        return signUpDropDownButton;
    }

    public WebElement getGoToSignUpPageButton() {
        return goToSignUpPageButton;
    }

    public void clickGoToSignUpButton() {
        goToSignUpPageButton.click();
    }

    public void clickGoToMarketplace() {
        marketplaceLink.click();
    }

}
