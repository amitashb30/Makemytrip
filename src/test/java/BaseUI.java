import ReadExcel.ExcelFlipkart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class BaseUI
{

    public WebDriver driver;

    static File file;
    static FileInputStream fis;
    static Properties prop,properties;

    public String browser,url,tab1url,shopnow,dropdown,ratings;
    public String close,compare1,compare2,compare_button,choosebrand;
    public String mobile_tab,input,oneplus,choose_a_product,nord_ce2;

    static FileOutputStream fos;
    int start,stop;



    public void fileLoading() {

        try {

            file= new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            fis = new FileInputStream(file);
            prop = new Properties();


            prop.load(fis);

             browser = prop.getProperty("_browserName");
             url = prop.getProperty("_url");
             tab1url = prop.getProperty("_tab1url");
            close = prop.getProperty("_close");
            mobile_tab = prop.getProperty("_mobile_tab");
            shopnow = prop.getProperty("_shopnow");
            dropdown = prop.getProperty("_dropdown");
            ratings = prop.getProperty("_ratings");
            compare1 = prop.getProperty("_compare1");
            compare2 = prop.getProperty("_compare2");
            compare_button = prop.getProperty("_compare_button");
            choosebrand = prop.getProperty("_choosebrand");
            input = prop.getProperty("_input");
            oneplus = prop.getProperty("_oneplus");
            choose_a_product = prop.getProperty("_choose_a_product");
            nord_ce2 = prop.getProperty("_nord_ce2");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void invokeBrowser(String Browser,String url)
    {
        try
        {

            if(Browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
                driver = new ChromeDriver();

            }

            else if(Browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();


            }
            else if(Browser.equalsIgnoreCase("ie"))
            {
                WebDriverManager.iedriver().driverVersion("104.0.1293.47").setup();
                driver = new FirefoxDriver();


            }

            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public void screenshot(){

        TakesScreenshot ts = (TakesScreenshot) driver;

        File pic = ts.getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(pic,new File(System.getProperty("user.dir")+"/src/results/"+Dateutils.timestamp()+".png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void propwrite(){

        try
        {
            fos = new FileOutputStream("C:\\Users\\abhat357\\Automation\\ODS-QA-Automation-serenity-framework\\MavenSelenium\\src\\test\\resources\\write.properties");
            properties = new Properties();

            Dateutils.timestamp();
            properties.setProperty("flipkart","https://www.flipkart.com/");
            properties.store(fos,null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }







}
