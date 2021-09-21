package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;

public class EmailContacts extends BasePage {
    public EmailContacts(WebDriver driver) {
        super(driver);
    }
    private  int countWrongEmail;

    @FindBy(xpath = "//a[contains(@href, 'mailto')]")
    private List<WebElement> emailAddress;


    public WebElement getLastEmailAddress() { return emailAddress.get(emailAddress.size()-1); }

    public int checkEmailAddress() {

        for (WebElement link : emailAddress) {
            System.out.println(link.getText()+" "+(Pattern.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", link.getText())));
            if (!(Pattern.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", link.getText()))) countWrongEmail++;
        }
        return countWrongEmail;
    }

}

