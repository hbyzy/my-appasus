package com.mycompany.app.cucumber.testCase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    // Start Webdriver and delete all cookies
    public void Startup() {
        System.out.println("open Browser....");

        String os = System.getProperty("os.name");
        if (os.equalsIgnoreCase("Mac Os X"))
            System.setProperty("webdriver.chorme.driver", "src/test/resources/drivers/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        System.out.println("driver loaded");
        driver.manage().deleteAllCookies();

    }

    @After
    //embed an acreen shot if test is marked as failed
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Failed at webPage with URL:" + driver.getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.close();
        driver.quit();
    }
}
