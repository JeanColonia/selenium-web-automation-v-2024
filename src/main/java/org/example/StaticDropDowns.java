package org.example;

import org.example.utils.Dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropDowns {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        Dropdowns dropdown = new Dropdowns();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        WebElement departureCityInput = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));


        WebElement arrivalCity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));

        WebElement viewDate = driver.findElement(By.id("ctl00_mainContent_view_date1"));


        departureCityInput.click();

        departureCityInput.sendKeys("Adampur");

        arrivalCity.click();
        arrivalCity.sendKeys("Delhi");



        Select currencySelect  = dropdown.staticDropdownId(driver,"ctl00_mainContent_DropDownListCurrency");


        currencySelect.selectByIndex(2);

        Thread.sleep(1500);

        driver.quit();







    }
}
