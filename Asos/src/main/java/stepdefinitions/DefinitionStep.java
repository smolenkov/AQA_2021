package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionStep {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    SavedPage savedPage;
    Marketplace marketplace;
    SignUpPage signUpPage;
    EmailContacts emailContacts;
    PageFactoryManager pageFactoryManager;
    Float firstPrice, secondPrice;
    String titleFirstSavedProduct;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks choose country icon")
    public void userClicksChooseCountryIcon() {
        homePage.clickOnCountrySelectorButton();
    }

    @And("User select country {string}")
    public void userSelectCountry(final String country) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getListOfCountries());
        homePage.openListOfCountries();
        homePage.scrollTitllElementIsVisible(homePage.countryInList(country));
        homePage.clickToChooseCountry(country);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User select currency {string}")
    public void userSelectCurrencyCurrency(final String currency) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getListOfCurrency());
        homePage.openListOfCurrency();
        homePage.scrollTitllElementIsVisible(homePage.currencyInList(currency));
        homePage.clickToChooseCurrency(currency);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }


    @And("User clicks update preferences button")
    public void userClicksUpdatePreferencesButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getApplyChangesButton());
        homePage.clickOnApplyChanges();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.scrollTitllElementIsVisible(homePage.inscriptionShoppingFrom());
    }

    @And("User checks that the inscription SHOPPING FROM: is changed on {string}")
    public void userChecksThatTheInscriptionSHOPPINGFROMIsChangedOnInscription(final String inscription) {
        assertEquals(inscription, homePage.getTextOfSettingsInscription());
    }

    @And("User checks that prefix in price equals {string}")
    public void userChecksThatPrefixInPriceEqualsPrefix(String expectedPrefix) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getLastImage());
        assertTrue(searchResultPage.getFirstPriceText().contains(expectedPrefix));
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String searchText) {
        homePage.enterTextToSearchField(searchText);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks that search page contains {string}")
    public void userCheckThatSearchPageContainsSearchTitle(final String expectedTitle) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getTitle());
        assertTrue(searchResultPage.getTextOfSearchResultTitle().equalsIgnoreCase(expectedTitle));
    }

    @And("User selects sort price high to low")
    public void userSelectsSortPriceHighToLow() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getSortButton());
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickSortButton();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getPriceHighToLowButton());
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickSortPriceHighToLowButton();
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getSortButton());
        searchResultPage.clickSortButton();
    }

    @And("User checks that first product is most expensive")
    public void userChecksThatFirstProductIsMostExpensive() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getLastImage());
        firstPrice = searchResultPage.getFirstPrice();
        secondPrice = searchResultPage.getSecondPrice();
        assertTrue("error:  firstprice=" + firstPrice + "  secondprise=" + secondPrice + " ", firstPrice >= secondPrice);
    }

    @And("User adds first product to saved page")
    public void userAddsFirstProductToSavedPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstSaveProductTitle());
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstSaveButton());
        searchResultPage.scrollTitllElementIsVisible(searchResultPage.getFirstSaveButton());
        titleFirstSavedProduct = searchResultPage.getFirstSaveProductTitleText();
        searchResultPage.clickOnElement(searchResultPage.getFirstSaveButton());
    }

    @And("User opens saved page")
    public void userOpensSavedPage() {
        savedPage = pageFactoryManager.getSavedPage();
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickGoToSaveListButton();
        savedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that product contains on saved page")
    public void userChecksThatProductContainsOnSavedPage() {
        savedPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedPage.getTitleSavedProduct());
        assertTrue(savedPage.getTextOfTitleSavedProduct().equalsIgnoreCase(titleFirstSavedProduct));
    }

    @And("User clicks sign-up button")
    public void userClickSignUpButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignUpDropDownButton());
        homePage.clickSignUpButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getGoToSignUpPageButton());
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickGoToSignUpButton();
    }

    @And("User checks that sign-up page is open")
    public void userCheckThatSignUpPageIsOpen() {
        signUpPage = pageFactoryManager.getSignUpPage();
        signUpPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signUpPage.isSignInButtonVisible();
    }

    @And("User checks that entered {string} is valid or displays an {string}")
    public void userCheckThatEnteredEmailIsValidOrDisplaysAnError(String email, String error) {
        signUpPage.enterTextToSearchField(email);
        assertTrue(signUpPage.emailFieldResponse().contains(error));
    }

    @And("User clicks on first product")
    public void userClickOnFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getLastImage());
        searchResultPage.scrollTitllElementIsVisible(searchResultPage.getFirstPriceLink());
        searchResultPage.clickFirstPrice();

    }

    @And("User checks that product page is opens")
    public void userCheckThatProductPageIsOpens() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on addToCart button")
    public void userClickOnAddToCartButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();
    }

    @And("User checks that count of product in cart is {string}")
    public void userChecksThatCountOfProductInCartIsCount(String count) {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCountOfProductInCart());
        assertTrue(productPage.getCountOfProductInCartText().equalsIgnoreCase(count));

    }

    @And("User clicks on cart icon")
    public void userClicksOnCartIcon() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCountOfProductInCart());
        productPage.clickCountOfProductInCart();
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);

    }

    @And("User clicks on delete product button")
    public void userClicksOnDeleteProductButton() {
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getDeleteProductButton());
        productPage.clickDeleteProductButton();
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getDeleteProductButton());
    }

    @And("User checks that cart is empty")
    public void userChecksThatCartIsEmpty() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCountOfEmptyCart());
        assertTrue(productPage.getCountOfEmptyCart().isDisplayed());
    }

    @And("User clicks marketplace link")
    public void userClicksMarketplaceLink() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickGoToMarketplace();
    }

    @And("User checks that some links on page isn't broken")
    public void userChecksThatSomeLinksOnPageIsnTBroken() {
        marketplace = pageFactoryManager.getMarketplace();
        marketplace.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(0, marketplace.findBrokenLinks());
    }

    @And("User checks that all e-mail links on page is valid")
    public void userChecksThatAllEMailLinksOnPageIsValid() {
        emailContacts = pageFactoryManager.getEmailContacts();
        emailContacts.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        emailContacts.waitVisibilityOfElement(DEFAULT_TIMEOUT, emailContacts.getLastEmailAddress());
        assertEquals(0, emailContacts.checkEmailAddress());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}



