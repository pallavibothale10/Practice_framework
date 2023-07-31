package Com.healthcare.Utilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsNG {

	static ExtentReports extents;
		
	public static ExtentReports getReportObject(){
		
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				
		String Name = "ExtentReport --"+Timestamp;
		
		//String Path = System.getProperty("user.dir")+"//Reporter//"+Name+" "+".html";
		
		Path resourceDirectory = Paths.get("src", "test", "resources");
		
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		
		System.out.println(absolutePath);
		
		String Path = absolutePath + "//Report//"+Name+" "+".html";
		
		ExtentHtmlReporter reporter =new ExtentHtmlReporter(Path);
		
		reporter.config().setReportName("11March Framework extent report");
		reporter.config().setDocumentTitle("11March Framework execution result");

		extents= new ExtentReports();
		
		extents.attachReporter(reporter);
		
		extents.setSystemInfo("QA Automation engineer", "Pallavi Bothale");
		extents.setSystemInfo("Suite Name", "Regression/Smoke");

       return extents;
	}
	
}
