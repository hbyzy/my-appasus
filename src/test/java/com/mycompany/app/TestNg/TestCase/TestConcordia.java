package com.mycompany.app.TestNg.TestCase;

import com.mycompany.app.TestNg.PageAction;
import com.mycompany.app.TestNg.PageAssert.ResultAssert;
import com.mycompany.app.TestNg.PageElement.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class TestConcordia extends TestBase {
    WebDriver driver;
    HomePage homePage;
    ResultAssert resultAssert;
    PageAction pageActions;

    @BeforeTest
    public void startup() {
        this.driver = super.driver;
        super.pageLoad();
        homePage = new HomePage(driver);
        resultAssert = new ResultAssert(driver);
        pageActions = new PageAction(driver);
    }

    @Test
    public void test() throws InterruptedException {
        pageActions.hoverMenu(homePage.menu_about, "News");
        resultAssert.assertPageChange("News");
        System.out.println("test:" + driver.getTitle());
        driver.navigate().back();
        resultAssert.assertPageChange("Concordia University");
        System.out.println("test go back:" + driver.getTitle());

    }

    @Test
    public void submenuTest() throws InterruptedException {
        String[] subMenus = homePage.subMenu(homePage.menu_about, homePage.aboutCss);
        String subMenu;
        for (int i = 0; i < subMenus.length; i++) {
            subMenu = subMenus[i];
            System.out.println(subMenu);
            pageActions.hoverMenu(homePage.menu_about, subMenu);

            if (subMenu.equals("Offices A-Z"))
                subMenu = "Offices";
            boolean result = resultAssert.assertPageChange(subMenu);
            if (result) {
                System.out.println("success Test subMenu " + subMenus[i]);
                Set<String> handles = driver.getWindowHandles();
                String handle = driver.getWindowHandle();
                if (handles.size() > 1) {
                    for (String h : handles) {
                        if (!h.equals(handle)) {
                            driver.close();
                            driver.switchTo().window(h);
                            break;
                        }
                    }
                } else {
                    pageActions.pageBack();
                    result = resultAssert.assertPageChange("Concordia University");
                    if (result)
                        System.out.println("success go back HomePage");
                    else
                        System.out.println("failed go back HomePage");
                }
            } else {
                System.out.println("failed change to " + subMenus[i]);
                break;
            }
        }
    }

    @Test(groups = "topMenu Test")
    public void aboutMenuTest() throws InterruptedException {
        homePage.menu_about.click();
        resultAssert.assertPageChange("About");
    }

    @Test(groups = "topMenu Test")
    public void admissionsTest() throws InterruptedException {
        homePage.menu_admissions.click();
        resultAssert.assertPageChange("Admissions");
    }

    @AfterTest
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
