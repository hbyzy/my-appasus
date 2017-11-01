package com.mycompany.app.selenium.page_object.Test_Case;

import com.mycompany.app.selenium.page_object.Page_Elements.HomePage;

import com.mycompany.app.selenium.page_object.Page_Assert.HomePageAsser;
import com.mycompany.app.selenium.page_object.page_actions.HomePageActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_concordia extends TestBase {
    public Boolean result = false;
    public String[] subMenu1;
    WebDriver driver;

    @Before
    public void setup() {
        driver = super.driver;
        super.pageLoad();
    }

    /*
        @Test
        public void testAbout() throws Exception {
            HomePageActions homePageAction = new HomePageActions(driver);
            HomePageAsser homePageAsser = new HomePageAsser((driver));

            homePageAction.mAboutClick();
            homePageAsser.PageChangeAssert("About");
        }

        @Test
        public void testAdmission() throws Exception {
            HomePageActions homePageAction = new HomePageActions(driver);
            HomePageAsser homePageAsser = new HomePageAsser(driver);

            homePageAction.mAdmissionsClick();
            homePageAsser.PageChangeAssert("Admission");
        }

        @Test
        public void testCampusLife() throws Exception {
            HomePageActions homePageAction = new HomePageActions(driver);
            HomePageAsser homePageAsser = new HomePageAsser(driver);

            homePageAction.mCampusLifeClick();
            homePageAsser.PageChangeAssert("Campus-life");

        }

        @Test
        public void testResearch() throws Exception {
            HomePageActions homePageAction = new HomePageActions(driver);
            HomePageAsser homePageAsser = new HomePageAsser(driver);

            homePageAction.mResearchClick();
            homePageAsser.PageChangeAssert("Research");

        }

            @Test
        public void testInternational() throws Exception {
            HomePageActions homePageAction = new HomePageActions(driver);
            HomePageAsser homePageAsser = new HomePageAsser(driver);

            homePageAction.mInternationalClick();
            homePageAsser.PageChangeAssert("International");
        }
    */
    @Test
    public void test() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        HomePageActions homePageAction = new HomePageActions(driver);

        homePageAction.hovermenu(homePage.menu_about,"Working at Concordia");

        System.out.println(driver.getTitle());
    }
    /*@Test
    public void aboutSubMenuTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);
        String[] subMenu;

        subMenu = homePage.subMenu(homePage.menu_about, homePage.aboutCss);
        for (int i = 0; i < subMenu.length; i++) {
            homePageAction.hovermenu(homePage.menu_about, subMenu[i]);
            System.out.println(subMenu[i]);
            result = homePageAsser.PageChangeAssert(subMenu[i]);
            if (result) {
                System.out.println("----------------------------------------");
                System.out.println("succese change to " + subMenu[i] + " page");
            } else {
                System.out.println(("failed on submenu " + subMenu[i]));
                break;
            }
            homePageAction.pageBack();

            if (homePageAsser.PageChangeAssert("Concordia University")) {
                System.out.println("（go back homepage form):" + subMenu[i] + " page");
                Thread.sleep(2000);
            } else
                System.out.println(("(can not goback homepage from): " + subMenu[i]) + " page");
        }
    }
*/
/*
    @Test
    public void testSubMenuA2() throws Exception {
        HomePage homePage = new HomePage(driver);
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);

        homePageAction.hovermenu(homePage.menu_about, homePage.sub_About_2);
        homePageAsser.PageChangeAssert("Strategic directions");
        driver.navigate().back();
        if (homePageAsser.PageChangeAssert("Concordia University")){
            homePageAction.hovermenu(homePage.menu_about, homePage.sub_About_1);
            homePageAsser.PageChangeAssert("Administration & governance");
        }else
            System.out.println("not go back HomePage");


    }
*/

    @After
    public void tearDown() throws Exception {
        super.tearDown();

    }
}