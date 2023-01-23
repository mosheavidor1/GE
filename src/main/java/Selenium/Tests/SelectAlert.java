package Selenium.Tests;


import Selenium.Infra.ElementConstans;
import Selenium.Infra.Wait;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class SelectAlert {

    WebDriver driver;

    ElementConstans elementConstans = new ElementConstans();

   // Clicking on the green symbol and verifying the message inside the alert.
    public void Select(WebDriver driver) throws InterruptedException {
        this.driver = driver;


        Wait wait = new Wait(driver, 30);
        wait.waitForElement(By.cssSelector(elementConstans.IconClick));

        driver.findElement(By.cssSelector(elementConstans.IconClick)).click();

        Thread.sleep(1000);
        WebElement comment = driver.findElement(By.xpath(elementConstans.CommentClick));

        String commentText = comment.getAttribute("value");
        System.out.println(commentText);
        assertEquals("Leadership Development", commentText);

    }

    //Negative test for alert message.
    public void WrongSelect(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement comment = driver.findElement(By.xpath(elementConstans.CommentClick));

        String commentText = comment.getAttribute("value");
        System.out.println(commentText);
        Assertions.assertNotEquals("Something else", commentText);
        System.out.println("Expected text is wrong");

    }
}














