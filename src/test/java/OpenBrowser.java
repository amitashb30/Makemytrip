import org.testng.annotations.*;

public class OpenBrowser extends Makemytrip
{
   @Test(priority = 1)
    public void openBrowser()

    {

        fileLoading();
        invokeBrowser("chrome",url);

    }

    @Test(priority = 2)
    public void ticket(){

        booking();
    }

    @Test(priority = 3)
    public void closeBrowser()
    {

        driver.close();
        driver.quit();
    }
}
