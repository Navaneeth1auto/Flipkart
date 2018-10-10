package baseClassFloder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass 
{
	
	public static WebDriver driver;
	public static Logger log;
	public WebDriver browserInitialization(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.navigate().to("https://www.flipkart.com/");
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}
	
	public static void loggerSetup()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public String getScreenShot(String testName)
	{
		TakesScreenshot shots=(TakesScreenshot)driver;
		File scrFile= shots.getScreenshotAs(OutputType.FILE);
		String destFile="./Screenshots/"+testName+".png";
		try {
			FileUtils.copyFile(scrFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
	
}
