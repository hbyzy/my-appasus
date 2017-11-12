package com.mycompany.app.cucumber.testCase;

import com.mycompany.app.cucumber.PageAction.PageAction;
import com.mycompany.app.cucumber.PageElement.HomePage;
import com.mycompany.app.cucumber.assertTest.AssertTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class testConcordia {
    public HomePage homePage;
    public AssertTest assertTest;
    public PageAction pageActions;
    public WebDriver driver;
    public static Logger logger;
    public testConcordia() {
        System.out.println("run constructor");
        driver = Hooks.driver;
    }

    @Given("^prepare parameter$")
    public void prepare() {

        homePage = new HomePage(driver);
        assertTest = new AssertTest(driver);
        pageActions = new PageAction((driver));
        logger = Logger.getLogger(testConcordia.class);
        PropertyConfigurator.configure("log4j.properties");
        System.out.println("prepare finish");
        logger.info("prepare finish");
      //  PageFactory.initElements(driver, Homepage.class);
    }

    @When("^I open concordia website$")
    public void openConcordiaWebPage() {
        System.out.println("prepare open homepage");
        logger.info("open homepage");
        driver.get("http://www.concordia.ca");
    }

    @And("^I click topMenu in the homePage$")
    public void clickTopMenu(DataTable topMenu) throws InterruptedException {
        System.out.println("Test topMenu");
        List<String> menu=topMenu.asList(String.class);
        logger.debug("try to get ABout menu ");
        String topmenu=menu.get(1);
        System.out.println(homePage.menu_about.getText()+" topmenu="+topmenu);
        homePage.menu_about.click();
        Boolean result=assertTest.assertPageChange(topmenu);
        logger.debug("assert if change to About page");
        System.out.println(driver.getTitle());
        if (!result)
        {Assert.fail("cheange to "+topmenu+" failed");
            logger.error("change to About menu failed");}
        driver.navigate().back();
        result=assertTest.assertPageChange("Concordia University");
        System.out.println(driver.getTitle());
        if (!result)
            Assert.fail("from "+topmenu+" go back to homepage failed");
    }

    @Then("^I test subMenu linked with topMenu$")
    public void subMenuTest() throws InterruptedException {
        String[] subMenus = homePage.subMenu(homePage.menu_about, homePage.aboutCss);
        String subMenu;
        for (int i = 0; i < subMenus.length; i++) {
            subMenu = subMenus[i];
            System.out.println(subMenu);
            pageActions.hoverMenu(homePage.menu_about, subMenu);

            if (subMenu.equals("Offices A-Z"))
                subMenu = "Offices";
            boolean result = assertTest.assertPageChange(subMenu);
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
                    result = assertTest.assertPageChange("Concordia University");
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
}
