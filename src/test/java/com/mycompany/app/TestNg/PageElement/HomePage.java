package com.mycompany.app.TestNg.PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage {
    @FindBy(xpath="//a[@href=\"/about.html\" and @class]")
   public WebElement menu_about;
    @FindBy(xpath="//a[@href=\"/admissions.html\" and @class]")
    public WebElement menu_admissions;
    @FindBy(xpath="//a[@href=\"/campus-life.html\" and @class]")
    public WebElement menu_campuslife;
    @FindBy(xpath="//a[@href=\"/research.html\" and @class]")
    public WebElement menu_research;
    @FindBy(xpath="//a[@href=\"/international.html\" and @class]")
    public   WebElement menu_international;

//    public By sub_About_1 = By.linkText("Administration & governance");
//    public By sub_About_2 = By.linkText("Strategic directions");
//    public By sub_Adimissions_1 = By.linkText("Undergraduate programs");
//    public By sub_Adimissions_2 = By.linkText("Graduate programs");
    @FindBy(css= "ul.nav:nth-child(2) > li:nth-child(1)")
    public    WebElement aboutCss;
    @FindBy(css= "ul.nav:nth-child(2) > li:nth-child(2)")
    public    WebElement admissionsCss;
    @FindBy(css="ul.nav:nth-child(2) > li:nth-child(3)")
    public    WebElement campuslifeCss;
    @FindBy(css="ul.nav:nth-child(2) > li:nth-child(4)")
    public    WebElement researchCss;
    @FindBy(css="ul.nav:nth-child(2) > li:nth-child(5)")
    public    WebElement InternationalCss;

    WebDriver driver;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver,this);
    }

    public String[] subMenu(WebElement topMenu, WebElement topCSS) throws InterruptedException {
        WebElement aboutMenu;
        String[] subMenu;
        Actions actions = new Actions(driver);
        actions.moveToElement(topMenu).perform();
        System.out.println("top menu=" + topMenu.getText());

        aboutMenu = topCSS;
        List<WebElement> subMenuAbout = aboutMenu.findElements(By.xpath(".//a[@tabindex='-1']"));
        subMenu = new String[subMenuAbout.size()];
        for (int i = 0; i < subMenuAbout.size(); i++) {
            subMenu[i] = subMenuAbout.get(i).getText();
            System.out.println("inside menu " + i + " " + subMenu[i]);
        }
        return subMenu;
    }
}


