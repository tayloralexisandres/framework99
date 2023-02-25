package com.alzir.step_definitions;

import com.alzir.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {



   @After
    public static void teardown(Scenario scenario){

      if(scenario.isFailed()) {
          byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
          scenario.attach(screenshot, "image/png", scenario.getName());
      }
          Driver.closeDriver();

      }

       @After
       public void tearDown(){

           Driver.closeDriver();

       }


   }


