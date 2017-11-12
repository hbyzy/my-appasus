package com.mycompany.app.kijiji;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class kijiji {
    WebDriver driver;

    @Before
    public void kijiji() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        String url = "http://www.kijiji.ca";
        driver.get(url);
    }

    @Test
    public void homepage() throws InterruptedException {
        WebElement searchkey = driver.findElement(By.xpath("//*[@id='SearchKeyword']"));
        searchkey.sendKeys("free");
        Thread.sleep(1000);

        WebElement keyBase = driver.findElement(By.cssSelector(".container-4056795851"));
        List<WebElement> skey = keyBase.findElements(By.cssSelector(".itemLink-4149465275>span"));
        String[] sKey = new String[skey.size()];
        for (int i = 0; i < skey.size(); i++) {
            sKey[i] = skey.get(i).getText();
            System.out.print(sKey[i] + "\t");
        }
        System.out.println("\r\n" + "-----------------");
        WebElement sel = driver.findElement(By.id("SearchCategory"));
        //sel.click();

        Select select = new Select(sel);
        List<WebElement> skey1 = select.getOptions();
        String[] sKey1 = new String[skey1.size()];
        for (int i = 0; i < skey1.size(); i++) {
            sKey1[i] = skey1.get(i).getText();
            System.out.print(sKey1[i] + "\t");
        }
        System.out.println("\r\n" + "-----------------------");
        select.selectByVisibleText(sKey1[3]);
        driver.findElement(By.cssSelector("#SearchLocationPicker")).click();
        WebElement loc = driver.findElement(By.cssSelector(".formFieldLocationPicker-195107693"));
        List<WebElement> locWeb = loc.findElements(By.tagName("li"));
        for (WebElement lw : locWeb) {
            //if (!lw.getText().equalsIgnoreCase(""))
                System.out.println(lw.getText())；
        }
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }

}
