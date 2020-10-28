package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends Util {
    LoadProp loadProp = new LoadProp();


    public static final String UserName = "Manorma1";
    public static final String Access_Key = "ca10916e-5ce4-402b-a796-4eeff0066d57";
    public static final String URL = "https://" + UserName + ":" + Access_Key + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static final String browserName = "chrome";
    public static final boolean sauce_Lab = false;


    public void setBrowser() {

// if sauce lab is true than browser open and run in saucelab

        if (sauce_Lab) {    // run in firefox;
            if (browserName.equalsIgnoreCase("firefox")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();  //firefox object

                DesiredCapabilities caps = DesiredCapabilities.firefox();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                // if browser is chrom than run in chrome browser
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();
                ChromeOptions browserOptions = new ChromeOptions();
                //  browserOptions.setExperimentalOption("w3c", true);
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {             // try and cach exception handle;
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // if browsername is internalexplorar than run in i.e
            } else if (browserName.equalsIgnoreCase("I.E")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                browserOptions.setCapability("platformName", "Windows 7");
                browserOptions.setCapability("browserVersion", "latest");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // if browser is safari than run in safari
            } else if (browserName.equalsIgnoreCase("safari")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                EdgeOptions browserOptions = new EdgeOptions();
                DesiredCapabilities caps = DesiredCapabilities.safari();
                browserOptions.setCapability("platformName", "macOS 10.15");
                browserOptions.setCapability("browserVersion", "84.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            }

        }


        // if saucelab is false than run in webdriver;

        else {
            //Check if parameter passed from TestNG is 'firefox'

            if (browserName.equalsIgnoreCase("firefox")) {
                //create firefox instance
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }   // check if parameter passed is internal explorer
            else if (browserName.equalsIgnoreCase("I.E")) {
                // create i.e  instatnce
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDrivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


            }
            //Check if parameter passed as 'chrome'
            else if (browserName.equalsIgnoreCase("chrome")) {
                //creat webdriver instance;

                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDrivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();

                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                driver = new ChromeDriver(options);
            } else {
                //If no browser passed throw exception
                //throw new Exception("Browser is not correct");
                System.out.println("Browser is not correct");
            }
        }


        // System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        //driver =new ChromeDriver();

        driver.manage().window().maximize();  // window maximise;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // implicity wait
        driver.get("https://opensource-demo.orangehrmlive.com/"); //url

    }

    // driver is close

    public void CloseBrowser() {
        driver.close();
    }


}








