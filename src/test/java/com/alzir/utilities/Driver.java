package com.alzir.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}


    public static InheritableThreadLocal<WebDriver> driverpool=new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverpool.get()==null){

            String browsertype= ConfigReader.getProperty("browser");
            switch (browsertype){
                case "chrome":
                    driverpool.set(new ChromeDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverpool.set(new FirefoxDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverpool.get();
    }

    public static void closeDriver(){
        if(driverpool.get()!=null){
            driverpool.get().quit();
            driverpool.remove();
        }
    }
}
