import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertEquals;

public class PageObjectFind {
    AndroidDriver driver;

    public PageObjectFind(AndroidDriver driver) {
        this.driver = driver;
    }

    //вспомогательные методы

    public void searchSomeThing(String keys){
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchInput.click();
        AndroidElement searchString = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_src_text"));
        searchString.sendKeys(keys);
    }

    public void assertThatNoResultsFound(){
        AndroidElement noResultFoundElement = (AndroidElement) driver.findElement(By.xpath("//*[./*[contains(@text, 'No results found')]]"));// находим элемент говорящий что ничего не найдено
        System.out.println(noResultFoundElement);
    }

    public void clickOnNecessaryPage(String xpath){
        AndroidElement desiredPageElement = (AndroidElement) driver.findElement(By.xpath(xpath));
        desiredPageElement.click();
    }

    public void clickOnMoreOptionsButton(){
        AndroidElement moreOptionsButtonElement = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/menu_overflow_button"));
        moreOptionsButtonElement.click();
    }

    public void inputUsernameAndPassInFieldsAndLogin(String username, String pass){
        AndroidElement usernameField = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/login_username_text"));
        usernameField.sendKeys(username);
        AndroidElement passwordField = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Toggle password visibility']/preceding-sibling::*"));
        passwordField.sendKeys(pass);
        AndroidElement loginButton = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/login_button"));
        loginButton.click();
    }

    public void checkUserGetMessageIncorrectValues(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("org.wikipedia:id/snackbar_text")));
        String actualMessage = driver.findElement(By.id("org.wikipedia:id/snackbar_text")).getText();
        String expectedMessage = "Incorrect username or password entered.\n" +
                "Please try again.";
        assertEquals(expectedMessage,actualMessage);
    }

    public void clickOnLoginButton(){
        AndroidElement loginButton = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/explore_overflow_account_name"));
        loginButton.click();
    }


    //инкапсулированная логика тестов

    public void testFindWfewfewfwegweg() {
       searchSomeThing("Wfewfewfwegweg");
       assertThatNoResultsFound();

    }

    public void testFindStarWars(){
        searchSomeThing("StarWars");
        clickOnNecessaryPage("//*[./*[contains(@text, 'Epic science')]]");
    }

    public void testFindGitHub(){
        searchSomeThing("GitHub");
        clickOnNecessaryPage("//*[./*[contains(@text, 'Hosting service')]]");
    }

    public void testFindApple(){
        searchSomeThing("Apple");
        clickOnNecessaryPage("//*[./*[contains(@text, 'American technology')]]");
    }

    public void testTryLoginUsernameQwertyPass123(){
        clickOnMoreOptionsButton();
        clickOnLoginButton();
        inputUsernameAndPassInFieldsAndLogin("qwerty","123");
        checkUserGetMessageIncorrectValues();
    }

    public void testTryLoginUsername123PassQwerty(){
        clickOnMoreOptionsButton();
        clickOnLoginButton();
        inputUsernameAndPassInFieldsAndLogin("123","qwerty");
        checkUserGetMessageIncorrectValues();
    }

    public void checkCorrectLanguageRus(){
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchInput.click();
        driver.findElement(By.id("org.wikipedia:id/search_lang_button")).click();
        driver.findElement(By.xpath("//*[./*[contains(@text, 'Русский')]]")).click();
        searchSomeThing("qwerty");
        driver.findElement(By.xpath("//*[./*[contains(@text, 'Наиболее популярная раскладка')]]"));
    }

    public void checkCorrectLanguageEng(){
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchInput.click();
        driver.findElement(By.id("org.wikipedia:id/search_lang_button")).click();
        driver.findElement(By.xpath("//*[./*[contains(@text, 'English')]]")).click();
        searchSomeThing("qwerty");
        driver.findElement(By.xpath("//*[./*[contains(@text, 'keyboard layout')]]"));
    }

    public void checkCorrectLanguageGerman(){
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchInput.click();
        driver.findElement(By.id("org.wikipedia:id/search_lang_button")).click();
        driver.findElement(By.xpath("//*[./*[contains(@text, 'Deutsch')]]")).click();
        searchSomeThing("apple");
        driver.findElement(By.xpath("//*[./*[contains(@text, 'amerikanisches Hardware')]]"));
    }

    public void checkCorrectLanguageSwedish(){
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchInput.click();
        driver.findElement(By.id("org.wikipedia:id/search_lang_button")).click();
        driver.findElement(By.xpath("//*[./*[contains(@text, 'Svenska')]]")).click();
        searchSomeThing("apple");
        driver.findElement(By.xpath("//*[./*[contains(@text, 'Amerikanskt dator')]]"));
    }



}
