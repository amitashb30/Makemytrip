import org.testng.annotations.*;

public class OpenBrowser extends Makemytrip
{
   @BeforeTest
    public void openBrowser()

    {

        fileLoading();
        invokeBrowser("chrome",url);

    }

    @Test
    public void ticket(){

        booking();
    }

    @AfterTest
    public void closeBrowser()
    {

        driver.close();
        driver.quit();
    }
}
