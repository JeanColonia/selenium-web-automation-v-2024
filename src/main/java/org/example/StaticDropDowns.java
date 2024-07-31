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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Dropdowns dropdown = new Dropdowns();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        WebElement departureCityInput = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

        WebElement departureCity = driver.findElement(By.xpath("//a[@value='AIP']"));

        WebElement arrivalCity = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
        //WebElement arrivalCity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));

        WebElement viewDate = driver.findElement(By.id("ctl00_mainContent_view_date1"));

        WebElement passengersContainer = driver.findElement(By.id("divpaxinfo"));

        WebElement addPassenger = driver.findElement(By.id("hrefIncAdt"));

        Select currencySelect  = dropdown.staticDropdownId(driver,"ctl00_mainContent_DropDownListCurrency");

        departureCityInput.click();
        departureCity.click();
        arrivalCity.click();


        int totalPassengers= 3;







        currencySelect.selectByIndex(2);


        passengersContainer.click();


        int i=1;
        while(i<=totalPassengers){

            addPassenger.click();
            i++;
        }




        driver.quit();







    }
}
