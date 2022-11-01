package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Creating Private Constructor, so we are closing access to the object of this class
    //from outside of any class

    private Driver(){

    }
    /*
    Making our 'driver' instance private, so that it is not reachable from outside of any class we make it static, because we want it to run before anything else, also we will use it in static method
     */

    private static WebDriver driver;

    /*
    Create re-usable utility method which will return same driver instance when we call it
     */

    public static WebDriver getDriver(){
        if(driver == null){

            String browserType = ConfigurationReader.getProperty("browser");
            //Depending on the browserType our switch statment will determine
            //to open specific type of browser/driver
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;



            }



        }
        //same driver instance will be returned every time we call Driver.getDriver() method
        return driver;
    }

    public static void closeDriver(){
        if(driver != null) {
            driver.quit(); // this line will kill this section, value will noy be null
            driver = null;
        }


    }


}

