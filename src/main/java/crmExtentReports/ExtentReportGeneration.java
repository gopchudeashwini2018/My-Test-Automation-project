package crmExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGeneration {

	public static ExtentReports getExtentReport() {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Spark.html");
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("CRM Report");
		spark.config().setReportName("Free CRM");
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Tested by", "Ashvini Vaijanath Gopchude");
		extent.setSystemInfo("Environment", "QA");
		
		
		return extent;
		
	}

}
