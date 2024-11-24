package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class windowHandles {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();


        WebElement multipleWindowsOptions = driver.findElement(By.xpath("//a[contains(text(), 'Multiple Windows')]"));

        Actions actions = new Actions(driver, Duration.ofSeconds(5));

        actions.moveToElement(multipleWindowsOptions).click().build().perform();

        WebElement newWindow = driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]"));

        newWindow.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it =  windows.iterator();

        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        WebElement newWindowText = driver.findElement(By.cssSelector(".example h3"));

        System.out.println(newWindowText.getText());

        driver.close();

        driver.switchTo().window(parentId);

        WebElement parentWindowText = driver.findElement(By.cssSelector(".example h3"));

        System.out.println(parentWindowText.getText());

        Thread.sleep(2000);

        driver.quit();

    }

}
