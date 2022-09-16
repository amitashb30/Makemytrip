import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentReport {

    public static ExtentReports report;


    public static ExtentHtmlReporter htmlReporter;

    public void  getReportInstance() {

        if (report == null) {
            File file = new File(System.getProperty("user.dir") + "/src/reports/"+Dateutils.timestamp()+"report.html");
            report = new ExtentReports();
            htmlReporter = new ExtentHtmlReporter(file);


            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "Windows");
            report.setSystemInfo("Env", "Local");
            report.setSystemInfo("Build", "Integration");
            report.setSystemInfo("Browser", "Chrome");
        }

    }


    /*public void verifyTittleTest() {
        ExtentTest logger = report.createTest("verifyTittleTest");
        logger.log(Status.PASS,"Test passed");

    }*/

    public void endTest() {

        report.flush();
    }








}
