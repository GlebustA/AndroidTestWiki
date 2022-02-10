import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SimpleTest {

    AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10.0");

        File file = new File("D:\\IDEA_projects\\Test\\src\\main\\resources\\org.wikipedia.apk");
        desiredCapabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testFindWfewfewfwegweg(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testFindWfewfewfwegweg();
    }

    @Test
    public void testFindStarWars(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testFindStarWars();
    }

    @Test
    public void testFindGitHub(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testFindGitHub();
    }

    @Test
    public void testFindApple(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testFindApple();
    }

    @Test
    public void testTryLoginUsernameQwertyPass123(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testTryLoginUsernameQwertyPass123();
    }

    @Test
    public void testTryLoginUsername123PassQwerty(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.testTryLoginUsername123PassQwerty();
    }

    @Test
    public void checkCorrectLanguageRus(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.checkCorrectLanguageRus();

    }

    @Test
    public void checkCorrectLanguageEng(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.checkCorrectLanguageEng();

    }

    @Test
    public void checkCorrectLanguageGerman(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.checkCorrectLanguageGerman();
    }

    @Test
    public void checkCorrectLanguageSwedish(){
        PageObjectFind pageObjectFind = new PageObjectFind(driver);
        pageObjectFind.checkCorrectLanguageSwedish();
    }

}