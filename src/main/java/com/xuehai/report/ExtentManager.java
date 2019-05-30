package com.xuehai.report;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

    public static ExtentReports getInstance(String fileName){
        if(extent == null)
            createInstance(fileName);
        return extent; 
    }

    private static ExtentReports createInstance(String fileName){
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("TestReport");
		htmlReporter.config().setReportName("TestReport");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
		htmlReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss.SSS");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		return extent;
    }
    
}
