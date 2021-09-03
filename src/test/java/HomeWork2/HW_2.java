package HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.List;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HW_2 {

 private WebDriver driver;

 @BeforeTest
    public void profileSetup(){
     System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
 }

 @BeforeMethod
    public void testSetup(){
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://avic.ua/");
 }

 @AfterMethod
    public void tearDown(){
     driver.close();
 }
@AfterTest
    public void end(){
     driver.quit();
}
























}
