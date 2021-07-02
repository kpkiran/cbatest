package com.cucumber.cukesproj.CukesProj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static WebDriver driver = null;
    public static Properties properties = null;

    public static WebDriver getDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/resources" +
                "/chromedriver");
        driver = new ChromeDriver();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/cucumber" +
                "/cukesproj/CukesProj/global.properties");
        properties = new Properties();
        properties.load(fis);
        driver.get(properties.getProperty("url"));
        return driver;
    }
}
