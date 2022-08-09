import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUI
{

    public WebDriver driver;

    static File file;
    static FileInputStream fis;
    static Properties prop;

    public String browser,url;




    public void fileLoading() {

        try {

            file= new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            fis = new FileInputStream(file);
            prop = new Properties();


            prop.load(fis);

             browser = prop.getProperty("_browserName");
             url = prop.getProperty("_url");



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
                WebDriverManager.firefoxdriver().driverVersion("0.29.1").setup();
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
}
