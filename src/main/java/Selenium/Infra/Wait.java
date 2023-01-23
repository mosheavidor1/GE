package Selenium.Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Wait for expected element
public class Wait {
    WebDriver driver;
    Duration timeOut;
    public Wait(WebDriver driver, int timeOut){
        this.driver=driver;
        this.timeOut= Duration.ofDays(timeOut);
    }

    public void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void until(ExpectedCondition<WebElement> visibilityOfElementLocated) {
    }
}