package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedPage extends BasePage{
    public SavedPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "(//div[contains(@class, 'productTile')])[1]//p")
    private WebElement titleSavedProduct;



    public String getTextOfTitleSavedProduct() {
        return titleSavedProduct.getText();
    }

    public WebElement getTitleSavedProduct() {
        return titleSavedProduct;
    }
}
