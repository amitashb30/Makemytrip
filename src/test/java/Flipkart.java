import ReadExcel.ExcelFlipkart;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Vector;

public class Flipkart extends BaseUI {

    public void ordering() {
        try {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            test = ExtentReport.report.createTest("Mobile ordering");

            test.log(Status.INFO, "CLOSING THE POP UP");

            clickElement("close_xpath");

            clickElement("_mobile_tab_xpath");

            clickElement("_shopnow_xpath");


            Thread.sleep(3000);
            Select select = new Select(driver.findElement(By.xpath(prop.getProperty("_dropdown_xpath"))));
            select.selectByValue("10000");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600)", "");

            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='4★ & above']//div[@class='_24_Dny']"))).click();
            Thread.sleep(3000);
            clickElement("_compare1_xpath");

            Thread.sleep(3000);

            clickElement("_compare_button_xpath");

            Thread.sleep(3000);

            clickElement("_choosebrand_xpath");

            sendData("_input_xpath", model);

            clickElement("_oneplus_xpath");

            Thread.sleep(3000);
            clickElement("_choose_a_product_xpath");

            clickElement("_nord_ce2_xpath");

            //screenshot();
            Thread.sleep(3000);
            propwrite();
            test.log(Status.PASS, "Test Executed Successfully");


        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, ExceptionUtils.getMessage(e));
        }


    }

    public void excelloading() {


        try {

            ExcelFlipkart ef = new ExcelFlipkart();
            Vector dataholder = ef.readexcelfile();

            int size = dataholder.size();
            start = 1;
            stop = 1;

            for (int j = start; j <= stop; j++) {

                int x = 0;
                Vector cellstorevalue = (Vector) dataholder.elementAt(j);
                XSSFCell name = (XSSFCell) cellstorevalue.elementAt(x++);
                model = name.toString().trim();


            }
            System.out.println(model);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
