import ReadExcel.ExcelFlipkart;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Vector;

public class Flipkart extends BaseUI
{

    public static String model;
    public void ordering()
    {
        try
        {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(close))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mobile_tab))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shopnow))).click();

            Thread.sleep(3000);
            Select select = new Select(driver.findElement(By.xpath(dropdown)));
            select.selectByValue("10000");

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,600)","");

            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='4★ & above']//div[@class='_24_Dny']"))).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(compare1))).click();

            Thread.sleep(3000);
            //js.executeScript("window.scrollBy(0,600)","");

           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(compare2))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(compare_button))).click();

            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(choosebrand))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input))).sendKeys(model);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(oneplus))).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(choose_a_product))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nord_ce2))).click();
            screenshot();
            Thread.sleep(3000);
            propwrite();



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }

    public void excelloading(){


        try
        {

            ExcelFlipkart ef = new ExcelFlipkart();
            Vector dataholder = ef.readexcelfile();

            int size = dataholder.size();
            start=1;
            stop=1;

            for (int j=start;j<=stop;j++)
            {

                int x = 0;
                Vector cellstorevalue = (Vector)dataholder.elementAt(j);
                XSSFCell name = (XSSFCell)cellstorevalue.elementAt(x++);
                model = name.toString().trim();
                


            }
            System.out.println(model);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }




}
