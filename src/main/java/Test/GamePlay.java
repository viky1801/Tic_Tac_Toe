package Test;


import Utils.DriverFactory;
import Utils.Selenium;
import Utils.gameWin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class GamePlay {

    public Selenium s;
    public gameWin gw;
    Properties configFile;

    WebDriver driver;

    @BeforeClass
    void Tearup()
    {
        configFile= new Properties();
        try {
            FileInputStream input= new FileInputStream("config.properties");
            configFile.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver=DriverFactory.launchBrowser(configFile.getProperty("BrowserName"));
        s=new Selenium(driver);
        gw=new gameWin(driver);
        driver.get(configFile.getProperty("URL"));
    }

    @Test(priority = 1)
    void getUrl()
    {
        Assert.assertEquals(s.getURL(),configFile.getProperty("URL"));
    }


    @Test(priority = 2)
    void gamePlay() throws InterruptedException {

        gw.ClickOnBoard();
        Assert.assertEquals(s.gameScore(),configFile.getProperty("Score"));

    }

    @Test(priority = 3)
    void Teardown()
    {
        //driver.quit();
    }


}