package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='Sign in' and @id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id= 'EmailAddress-error'] ")
    private List<WebElement> errorMessage;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;





//    public WebElement getSignButton() { return signInButton; }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void enterTextToSearchField(String enterEmail){
        emailField.sendKeys(enterEmail);
    }

    public String emailFieldResponse(){
        passwordField.click();
        if (errorMessage.size()==0) return "";
        else return errorMessage.get(errorMessage.size()-1).getText();
    }

}
