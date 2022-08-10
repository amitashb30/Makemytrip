import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@aria-label,'Sat Aug 27 2022')]//p[contains(text(),'27')]"))).click();

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,100)","");

            screenshot();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']"))).click();

            js.executeScript("window.scrollBy(0,200)","");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='bookbutton-RKEY:fdce6722-56f1-4b53-8fa0-7f123548a55c:5_0']//span[@class='appendRight8'][normalize-space()='View Prices']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//div[@class='viewFareBtnCol ']//button[@id='bookbutton-RKEY:432ede2c-10d4-48cd-a59d-7e2e8be18c37:5_0']"))).click();







            Thread.sleep(5000);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


}
