package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selenium {
   public WebDriver driver;
    public Selenium(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class=\"mute\"]")
    public WebElement soundClick;

    @FindBy(xpath = "//span[@class=\"score appear\"]")
    public WebElement gamescore;



    public void cLick(WebElement operation)
    {
        operation.click();
    }

    public String getURL()
    {
        return driver.getCurrentUrl();
    }
    public String gameScore()
    {
        return gamescore.getText();
    }

}
