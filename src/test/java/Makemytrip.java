import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Makemytrip extends BaseUI
{


    public void booking()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='whiteText makeFlex perfectCenter langSlct']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='selectConInput']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='searchConWrap ']//p[1]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();



            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='From']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']"))).sendKeys("Hyderabad");
            WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//p[contains(@class,'font14 appendBottom5 blackText')][normalize-space()='Hyderabad, India']")));
            city.click();

           //String cityname = city.getText();
           //Assert.assertEquals("Hyderabad",cityname);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']"))).sendKeys("Coimbatore");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Coimbatore, India']"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='departure']"))).click();

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,200)","");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@aria-label,'Sat Aug 27 2022')]//p[contains(text(),'27')]"))).click();


            js.executeScript("window.scrollBy(0,50)","");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn')]"))).click();

            /*for pop up
            Thread.sleep(5000);
           WebElement okay = driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']"));;


            if (okay.isDisplayed())
            {
                okay.click();
            }

            else{
                System.out.println("Alert not available");
            }
*/
            js.executeScript("window.scrollBy(0,200)","");

            By selector = By.className("appendRight8");
            List <WebElement> viewprice = driver.findElements(selector);

            viewprice.get(0).click();

            js.executeScript("window.scrollBy(0,200)","");
            By book = By.xpath("//button[contains(text(), 'Book Now')]");
            List <WebElement> bookprice = driver.findElements(book);

            bookprice.get(0).click();

            driver.navigate().to(tab1url);
            Thread.sleep(3000);



            By Radiobutton = By.xpath("//body/div[@id='root']/div/div[@class='reviewTravellerAddons']/div[@class='flightBody']/div[@class='flightsContainer footerSpace']/div[@class='makeFlex spaceBetween']/div[@class='pageLeftConainer']/form[@id='mainSection_0']/div[@id='INSURANCE']/div[contains(@class,'componentContainer appendTop15')]/div[@class='insBottomSection']/div[2]/label[1]/span[1]/span[1]");
            WebElement radio =  wait.until(ExpectedConditions.elementToBeClickable(Radiobutton));


            js.executeScript("arguments[0].scrollIntoView();",radio);



            radio.click();

            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,400)","");




        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


}
