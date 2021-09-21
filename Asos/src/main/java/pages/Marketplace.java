package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.support.FindBy;


public class Marketplace extends BasePage{

    public Marketplace(WebDriver driver) { super(driver); }
    public final String LINKS_ATTRIBUTE = "href";
    private int countOfBrokenLink;

    @FindBy(xpath = "//a[string-length(@href) < 10]")
    private List<WebElement> links;


    public int findBrokenLinks() {
        for (WebElement link : links) {
            try {
                String urlLink = link.getAttribute(LINKS_ATTRIBUTE);
                URL url = new URL(urlLink);
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if (httpURLConnect.getResponseCode() >= 400) {
                    System.out.println(urlLink + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
                    countOfBrokenLink++;
                } else {
                    System.out.println(urlLink + " - " + httpURLConnect.getResponseMessage());
                }
            } catch (Exception e) {
            }
        }
        return countOfBrokenLink;
    }
}