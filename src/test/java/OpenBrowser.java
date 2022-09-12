import org.testng.annotations.*;

public class OpenBrowser extends Flipkart
{
   @BeforeTest
    public void openBrowser()

    {

        fileLoading();
        invokeBrowser(browser,url);

    }

    @Test
    public void ticket(){


        excelloading();
        ordering();
    }



    @AfterTest
    public void closeBrowser()
    {

        driver.close();
        driver.quit();
    }
}
