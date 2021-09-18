package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage{

    @FindBy(xpath = "//form//select[@id='country']")
    private WebElement listOfCountries;

    @FindBy(xpath = "(//button[@data-testid = 'country-selector-btn'])[1]")
    private WebElement countrySelectorButton;

    @FindBy(xpath = "//button[@type='submit' and @data-testid='save-country-button']")
    private WebElement applyChangesButton;

    @FindBy(xpath = "(//button[@data-testid = 'country-selector-btn'])[2]/../span")
    private WebElement inscriptionShoppingFrom;

    @FindBy(xpath = "//input[@type ='search']")
    private WebElement searchField;



    public HomePage(WebDriver driver) { super(driver);}

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnCountrySelectorButton() {
        countrySelectorButton.click();
    }

    public WebElement getListOfCountries() {
        return listOfCountries;
    }

    public void openListOfCountries() {
        listOfCountries.click();
    }

    public WebElement countryInList(String country) { return
            driver.findElement(xpath("//select[@id='country']//option[contains(text(), '"+country+"')]"));
    }

    public void clickToChooseCountry(String country) {
        countryInList(country).click();
    }

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
}
