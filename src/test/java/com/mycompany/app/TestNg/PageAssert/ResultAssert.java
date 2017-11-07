package com.mycompany.app.TestNg.PageAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ResultAssert {
    WebDriver driver;


    public ResultAssert(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean assertPageChange(String title) throws InterruptedException {
        int timeout = 5000;
        int interval = 500;
        while (timeout > 0) {
            if (title.equals(driver.getTitle()))
                return true;
            else {
                String handle = driver.getWindowHandle();
                Set<String> handles = driver.getWindowHandles();
                if (handles.size() > 1) {
                    for (String H : handles) {
                        if (!H.equals(handle)) {
                            driver.switchTo().window(H);
                            break;
                        }
                    }
                } else {
                    Thread.sleep(interval);
                    timeout -= interval;
                }
            }
        }
        return false;
    }

    public void pageBack() {
    driver.navigate().back();
    }
}
