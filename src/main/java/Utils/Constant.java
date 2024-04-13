package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Constant {
   static WebDriver driver;

    public Constant(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        Constant.driver=driver;
    }

    List<String> board =new ArrayList<>();

    void Board()
    {
        board.clear();
        board.add("NIU");
        for (int i = 0; i < 9; i++)
            board.add("-1");
    }
    

    

    void upDate()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=1;i<=9;i++)
        {
            String updatedData=driver.findElement(By.xpath("//div[@class=\"board\"]/div["+i+"]/div")).getAttribute("class");
            board.set(i,updatedData);
        }
    }
    

    int checkConditions(String value)
    {
        upDate();
        // ROW 1
        if((board.get(1).equals(value))&&(board.get(2).equals(value))&&("".equals(board.get(3))))
            return 3;
        if((board.get(2).equals(value))&&(board.get(3).equals(value))&&("".equals(board.get(1))))
            return 1;
        if((board.get(1).equals(value))&&(board.get(3).equals(value))&&("".equals(board.get(2))))
            return 2;

        //ROW 2
        if((board.get(4).equals(value))&&(board.get(5).equals(value))&&("".equals(board.get(6))))
            return 6;
        if((board.get(5).equals(value))&&(board.get(6).equals(value))&&("".equals(board.get(4))))
            return 4;
        if((board.get(4).equals(value))&&(board.get(6).equals(value))&&("".equals(board.get(5))))
            return 5;

        //ROW 3
        if((board.get(8).equals(value))&&(board.get(9).equals(value))&&("".equals(board.get(7))))
            return 7;
        if((board.get(7).equals(value))&&(board.get(9).equals(value))&&("".equals(board.get(8))))
            return 8;
        if((board.get(7).equals(value))&&(board.get(8).equals(value))&&("".equals(board.get(9))))
            return 9;

        //Line1
        if((board.get(4).equals(value))&&(board.get(7).equals(value))&&("".equals(board.get(1))))
            return 1;
        if((board.get(1).equals(value))&&(board.get(7).equals(value))&&("".equals(board.get(4))))
            return 4;
        if((board.get(1).equals(value))&&(board.get(4).equals(value))&&("".equals(board.get(7))))
            return 7;

        //Line2
        if((board.get(2).equals(value))&&(board.get(5).equals(value))&&("".equals(board.get(8))))
            return 8;
        if((board.get(2).equals(value))&&(board.get(8).equals(value))&&("".equals(board.get(5))))
            return 5;
        if((board.get(5).equals(value))&&(board.get(8).equals(value))&&("".equals(board.get(2))))
            return 2;

        //Line3
        if((board.get(3).equals(value))&&(board.get(6).equals(value))&&("".equals(board.get(9))))
            return 9;
        if((board.get(3).equals(value))&&(board.get(9).equals(value))&&("".equals(board.get(6))))
            return 6;
        if((board.get(6).equals(value))&&(board.get(9).equals(value))&&("".equals(board.get(3))))
            return 3;


        //D1
        if(board.get(1).equals(value)&&board.get(5).equals(value)&&"".equals(board.get(9)))
            return 9;
        if(board.get(1).equals(value)&&board.get(9).equals(value)&&"".equals(board.get(5)))
            return 5;
        if(board.get(5).equals(value)&&board.get(9).equals(value)&&"".equals(board.get(1)))
            return 1;

        //D2
        if(board.get(5).equals(value)&&board.get(7).equals(value)&&"".equals(board.get(3)))
            return 3;
        if(board.get(3).equals(value)&&board.get(7).equals(value)&&"".equals(board.get(5)))
            return 5;
        if(board.get(3).equals(value)&&board.get(5).equals(value)&&"".equals(board.get(7)))
            return 7;


        else return -1;

    }
}
