package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.ProductPage;
import pages.SavedPage;
import pages.SearchResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionStep {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    SavedPage savedPage;
    PageFactoryManager pageFactoryManager;
    Float firstPrice, secondPrice;
    String titleFirstSavedProduct;

    @Before
    public void testsSetUp() {
        chromedriver().setup();


        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @And ("User opens {string} page")
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
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getApplyChangesButton());
        homePage.clickOnApplyChanges();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.scrollTitllElementIsVisible(homePage.inscriptionShoppingFrom());
    }

    @And("User checks that the inscription SHOPPING FROM: is changed on {string}")
    public void userChecksThatTheInscriptionSHOPPINGFROMIsChangedOnInscription(final String inscription) {
        assertEquals(inscription, homePage.getTextOfSettingsInscription());
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
    public void userClicksSearchButton() { homePage.clickSearchButton();}

    @And("User check that search page contains {string}")
    public void userCheckThatSearchPageContainsSearchTitle(final String expectedTitle) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getTitle());
        assertTrue(searchResultPage.getTextOfSearchResultTitle().equalsIgnoreCase(expectedTitle));
    }

    @And("User selects sort price high to low")
    public void userSelectsSortPriceHighToLow(){
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getSortButton());
        searchResultPage.clickSortButton();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getPriceHighToLowButton());
        searchResultPage.clickSortPriceHighToLowButton();
    }

    @And("User checks that first product is most expensive")
    public void userChecksThatFirstProductIsMostExpensive() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstPrice());
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getSecondPrice());
        searchResultPage.scrollTitllElementIsVisible(searchResultPage.getFirstPrice());
        firstPrice = Float.parseFloat(searchResultPage.getFirstPriceText().replaceAll("[^0-9]", ""));
        secondPrice = Float.parseFloat(searchResultPage.getSecondPriceText().replaceAll("[^0-9]", ""));
        assertTrue(firstPrice >= secondPrice);
    }

    @And("User adds first product to saved page")
    public void userAddsFirstProductToSavedPage() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        titleFirstSavedProduct =searchResultPage.getFirstSaveProductTitleText();
        searchResultPage.clickFirstSaveButton();

    }

    @And("User opens saved page")
    public void userOpensSavedPage() {
        savedPage = pageFactoryManager.getSavedPage();
        savedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that product contains on saved page")
    public void userChecksThatProductContainsOnSavedPage() {
        assertTrue(savedPage.getTextOfTitleSavedProduct().equalsIgnoreCase(titleFirstSavedProduct));
    }

    @After
    public void tearDown() {
        driver.close();
    }



}

