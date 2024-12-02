package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LimitedLinkCount {

    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().window().maximize();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));



        WebElement footerContainer = driver.findElement(By.id("gf-BIG"));


        WebElement discountCouponsFooter = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/child::td[1]/ul"));


        List<WebElement> discountCouponsLinks = discountCouponsFooter.findElements(By.tagName("a"));


        for(int i=0; i<discountCouponsLinks.size(); i++){
            if(i!=0){

                String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

                discountCouponsLinks.get(i).sendKeys(clickLink);
            }
        }


        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        //first method
 /**       for (int i = 0; i <windows.size() ; i++) {
           String window_ = iterator.next();

           driver.switchTo().window(window_);
            System.out.println( driver.getTitle());
        }
**/
        //second method

        while(iterator.hasNext()){

            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }

        Thread.sleep(2500);
        driver.quit();
    }
}
