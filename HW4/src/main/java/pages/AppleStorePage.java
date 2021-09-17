package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class AppleStorePage extends BasePage{
    private static final String MACBOOKTEXTBUTTON = "//div[(@class='brand-box__title')]//a[(@href= 'https://avic.ua/macbook')]";

    @FindBy(xpath = "//div[(@class='brand-box__title')]//a[(@href= 'https://avic.ua/macbook')]")
    private WebElement macbookButton;

    public AppleStorePage(WebDriver driver) {super(driver);}

    public void clickMacbookTextButton(){
        macbookButton.click();
    }


}
