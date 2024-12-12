package org.example;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingHTTPSCertifications {

    public static void main(String []args) throws InterruptedException {

        //chrome options (settings)
        ChromeOptions options = new ChromeOptions();

        //setting proxy value
        Proxy proxy = new Proxy();
        //proxy.setHttpProxy("ipaddress:999");
        options.setAcceptInsecureCerts(true);
        //options.setCapability("proxy", proxy);

        //instance of chrome driver
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());


        Thread.sleep(2500);
        driver.quit();

    }
}
