import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Makemytrip extends BaseUI
{


    public void booking()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            //WebElement roundtrip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/ul/li[2]/span")));
            //roundtrip.click();

            //WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
            WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
            from.click();
            Thread.sleep(2000);
            from.sendKeys("Hyderabad");

            WebElement city = driver.findElement(By.xpath("//p[normalize-space()='Hyderabad, India']"));


            city.click();
            Thread.sleep(3000);






        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


}
