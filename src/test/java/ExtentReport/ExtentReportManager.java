package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static String homeDir = System.getProperty("user.dir");

    public static ExtentReports extemtSetup() {

        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(new File(homeDir + "/Reports/ExtendReport.html"));
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Extent Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Automation Report");

        extentReports.setSystemInfo("browser", System.getProperty("browser.name"));
        extentReports.setSystemInfo("os", System.getProperty("os.name"));
        extentReports.setSystemInfo("url", (" https://www.demoblaze.com/index.html"));
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        return extentReports;

    }

}
