package SmokeTests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class SmokeTest extends BaseTest {

    private static final String EXPECTED_COUNT_OF_PRODUCT_IN_CART = "1";
    private static final String EXPECTED_COUNT_AFTER_DELETE = "0";
    private static final String SEARCH_KEYWORD = "epam";
    private static final String EXPECTED_SEARCH_QUERY = "epam";
    private static final int WAITING_TIME = 90;
    private static final int EXPECTED_SEARCH_COUNT = 1;
    Integer minPrice, nextPrice;


    @Test(priority = 1)
    public void checkThatProductCanToAddToCart() throws InterruptedException {
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        assertTrue(getHomePage().isSearchFieldVisible());
        assertTrue(getHomePage().isSearchButtonVisible());
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().waitVisibilityOfElement(WAITING_TIME, getHomePage().getSearchButton());
        getHomePage().clickSearchButton();
        getSearchPage().waitForPageLoadComplete(WAITING_TIME);
        getSearchPage().waitForUrlContains(WAITING_TIME, EXPECTED_SEARCH_QUERY);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
        assertTrue(getSearchPage().getSearchResultsCount() >= EXPECTED_SEARCH_COUNT);
        getSearchPage().waitForPageLoadComplete(WAITING_TIME);
        getSearchPage().clickBuyButton();
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getAddToCartPopup());
        assertTrue(getSearchPage().isAddToCartPopupVisible());
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getComeBackButton());
        getSearchPage().clickComeBackButton();
        assertEquals(getSearchPage().getTextFromCartsCount(), EXPECTED_COUNT_OF_PRODUCT_IN_CART);
    }

    @Test(priority = 2)
    public void checkThanTheProductCanRemoveFromCart(){
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        assertTrue(getHomePage().isSearchFieldVisible());
        assertTrue(getHomePage().isSearchButtonVisible());
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().waitVisibilityOfElement(WAITING_TIME, getHomePage().getSearchButton());
        getHomePage().clickSearchButton();
        getSearchPage().waitForPageLoadComplete(WAITING_TIME);
        getSearchPage().waitForUrlContains(WAITING_TIME, EXPECTED_SEARCH_QUERY);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
        assertTrue(getSearchPage().getSearchResultsCount() >= EXPECTED_SEARCH_COUNT);
        getSearchPage().waitForPageLoadComplete(WAITING_TIME);
        getSearchPage().clickBuyButton();
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getAddToCartPopup());
        assertTrue(getSearchPage().isAddToCartPopupVisible());
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getComeBackButton());
        getSearchPage().clickComeBackButton();

        getSearchPage().waitForPageLoadComplete(WAITING_TIME);
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getCartField());
        getSearchPage().clickOnCartField();
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getAddToCartPopup());
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getRemoveFromCartField());
        getSearchPage().clickOnRemoveFromCartField();
        getSearchPage().waitVisibilityOfElement(WAITING_TIME, getSearchPage().getBackToSiteFromCart());
        getSearchPage().clickOnBackToSiteFromCart();
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        assertEquals(getSearchPage().getTextFromCartsCount(), EXPECTED_COUNT_AFTER_DELETE);

    }
}
