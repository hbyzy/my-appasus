package com.mycompany.app.TestNg;

import com.mycompany.app.TestNg.PageElement.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageAction {
    WebDriver driver;
    HomePage homePage;

    public PageAction(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void hoverMenu(WebElement topMenu, String subMenu) throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(topMenu).perform();
        WebElement ws=driver.findElement(By.linkText(subMenu));

        actions.moveToElement(ws);
        actions.click().build().perform();
    }
    public void pageBack(){
        driver.navigate().back();
    }
}
