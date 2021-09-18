package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.ProductPage;
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
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
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



    @After
    public void tearDown() {
        driver.close();
    }



}

