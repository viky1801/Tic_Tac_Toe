package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class gameWin {

   static WebDriver driver;
    Constant c;
    public gameWin(WebDriver driver)
    {
        gameWin.driver =driver;
        PageFactory.initElements(driver,this);
        c=new Constant(driver);
    }



    public void ClickOnBoard() throws InterruptedException {
       c.Board();
       click(7);

       c.upDate();

       if(freespot(3).isEmpty()){
           click(3);
           if(click(c.checkConditions("x"))){return;}
           //winning
       }

       else if (freespot(1).isEmpty()) {
           click(1);
           if(click(c.checkConditions("x"))){return;}
           //winning
       }


       if(click(c.checkConditions("x")));
       else {
           if (click(c.checkConditions("o"))) ;
           else {
               if (freespot(1).isEmpty())
                   click(1);
               else if (freespot(9).isEmpty())
                       click(9);
           }
       }


       if(click(c.checkConditions("x"))){return;}
       else if(click(c.checkConditions("o"))){
           refresh();
       }


       c.upDate();


       if(click(c.checkConditions("x"))){return;}
       if(click(c.checkConditions("o"))){
           refresh();
       }


   }


    void refresh() throws InterruptedException {
       Thread.sleep(500);
       if((driver.findElement(By.xpath("/html/body/div[4]/p[2]/span")).getText()).equals("1"))
       {
           driver.navigate().refresh();
           ClickOnBoard();
       }
   }



    static boolean click(int i)
    {
        if(i==-1)
            return false;
        driver.findElement(By.xpath("//div[@class=\"board\"]/div["+i+"]")).click();
        return true;
    }



     public String freespot(int i) throws InterruptedException {
        Thread.sleep(1000);
        WebElement e=driver.findElement(By.xpath("//div[@class=\"board\"]/div["+i+"]/div"));
        return e.getAttribute("class");
    }



}
