package SmokeTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest{

    private final String SEARCH_KEYWORD = "samsung";
    private final String EXPECTED_SEARCH_QUERY = "query=samsung";
    Integer minPrice, nextPrice;


    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));

    }
    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        assertEquals(getSearchPage().getSearchResultsCount(), 12);
}
    @Test(priority = 3)
    public void checkSortedProduct() throws InterruptedException {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchPage().implicitWait(10);
        getSearchPage().clickCheckBoxSmartphones();
        getSearchPage().implicitWait(10);
        getSearchPage().clickCheckBoxAvailable();
        getSearchPage().implicitWait(10);
        getSearchPage().clickToSortedButton();
        getSearchPage().implicitWait(10);
        getSearchPage().clickToSortedASC();
        getSearchPage().implicitWait(10);
        minPrice = Integer.parseInt(getSearchPage().getMinPriceSamsungPhone().replaceAll("[^0-9]", ""));
        nextPrice = Integer.parseInt(getSearchPage().getNextPriceSamsungPhone().replaceAll("[^0-9]", ""));
        assertTrue(minPrice <= nextPrice);


    }
}
