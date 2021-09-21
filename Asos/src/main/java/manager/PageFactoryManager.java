package manager;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.SavedPage;
import pages.SignUpPage;
import pages.Marketplace;
import pages.EmailContacts;


public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public SavedPage getSavedPage() {
        return new SavedPage(driver);
    }

    public SignUpPage getSignUpPage() {
        return new SignUpPage(driver);
    }

    public Marketplace getMarketplace() { return new Marketplace(driver); }

    public  EmailContacts getEmailContacts() { return new EmailContacts(driver); }




}