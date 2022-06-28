package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AutomationTest {

    public WebDriver driverItbi;
    public WebDriver driverDB;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup()
    {
        driverItbi = new ChromeDriver();
        driverDB = new ChromeDriver();
    }

    @After
    public void cleanup()
    {
        driverItbi.quit();
        driverDB.quit();
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        ItbiPage loginPage = new ItbiPage(driverItbi, driverDB);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("128", "162", "0050", "6", "02/06/2022");
        Thread.sleep(3000);
    }
}
