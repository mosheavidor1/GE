package Selenium.Run.TestNG;


import Selenium.Infra.DriverConstans;
import Selenium.Tests.Login;
import Selenium.Tests.SelectAlert;
import Selenium.Tests.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGRun {



    WebDriver driver;


//Setup Driver
    @BeforeTest
    public void setUp() {
        DriverConstans driverConstans = new DriverConstans();
        System.setProperty(driverConstans.ChromeWebDriver, driverConstans.ChromePath);
        driver = new ChromeDriver();

    }

//Login screen
    @Test(priority = 1)

    public void Login() throws InterruptedException {
        Login login = new Login();
        login.LoginSet(driver);


    }

//Click on Time icon.
    @Test(priority = 2)

    public void Time() {
        Time time = new Time();
        time.ClickOnTime(driver);


    }
//clicking on view button next to the expected date.
    @Test(priority = 3)

    public void SelectTimePeriod() {
        Time selectP = new Time();
        selectP.SelectTimePeriod(driver);


    }
//Clicking on the green symbol and verifying the message inside the alert.
    @Test(priority = 4)

    public void VerifyAlert() throws InterruptedException {
    SelectAlert selectAlert=new SelectAlert();
    selectAlert.Select(driver);
    }
//Negative test for alert message.
    @Test(priority = 5)

    public void WrongAlert()throws InterruptedException{
    SelectAlert wrong=new SelectAlert();
    wrong.WrongSelect(driver);



    }
//Close the browser
    @AfterClass
    public void tearDown() {

            driver.quit();
        }
    }






