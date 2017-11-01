package com.mycompany.app.selenium.page_object.Page_Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HomePageAsser {
    public int timeOut = 5000;
    public int interval = 500;
    WebDriver driver;

    public HomePageAsser(WebDriver wdriver) {
        this.driver = wdriver;
    }

    public boolean PageChangeAssert(String rname) throws InterruptedException {

        while (timeOut > 0) {
            String Title = driver.getTitle();
            System.out.println("assert:get title:"+Title);
            if (rname.equals(Title)) {
                System.out.println("assert:chang to right page-->" + Title);
                return true;
            } else {
                Thread.sleep(interval);
                timeOut -= interval;
            }

        }
        System.out.println("assert can not chage to right page-->" + rname);
        return false;
    }


}