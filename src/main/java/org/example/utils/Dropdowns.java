package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {


    public Select staticDropdownId(WebDriver driver, String elementId){

        Select departureCity = new Select(driver.findElement(By.id(elementId)));

        return departureCity;
    }
}
