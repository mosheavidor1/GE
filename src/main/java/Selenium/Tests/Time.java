package Selenium.Tests;

import Selenium.Infra.ElementConstans;
import Selenium.Infra.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Time {
WebDriver driver;

    ElementConstans elementConstans =new ElementConstans();
    //Click on Time icon
    public void ClickOnTime(WebDriver driver) {

        this.driver=driver;
        Wait wait = new Wait(driver, 30);
        wait.waitForElement(By.xpath(elementConstans.TimeClick));
        driver.findElement(By.xpath(elementConstans.TimeClick)).click();
        driver.manage().window().fullscreen();

    }
    //Clicking on view button next to the expected date.
    public void SelectTimePeriod(WebDriver driver){
        this.driver=driver;
        Wait wait = new Wait(driver, 30);
        wait.waitForElement(By.xpath(elementConstans.ViewClick));
        driver.findElement(By.xpath(elementConstans.ViewClick)).click();
        driver.manage().window().fullscreen();



    }





}
