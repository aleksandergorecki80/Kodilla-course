package com.kodilla.testing2.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class FacebookTestingApp {
    public static final String XPATH_COOKIES_BUTTON_PL = "//div[2]/div[1]/div/div[1]/div/span/span[contains(text(),'Zezwól na wszystkie pliki cookie')]";
    public static final String XPATH_CREATE_ACCOUNT_BUTTON = "//a[@data-testid='open-registration-form-button']";
    public static final String XPATH_DAY_PICKER = "//select[@name='birthday_day']";
    public static final String XPATH_MONTH_PICKER = "//select[@name='birthday_month']";
    public static final String XPATH_YEAR_PICKER = "//select[@name='birthday_year']";


    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.facebook.com/");

        WebElement allowCookiesButton = driver.findElement(By.xpath(XPATH_COOKIES_BUTTON_PL));
        allowCookiesButton.click();

        WebElement createNewAccountButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT_BUTTON));
        createNewAccountButton.click();

        WebElement dayPicker = driver.findElement(By.xpath(XPATH_DAY_PICKER));
        Select selectDay = new Select(dayPicker);
        selectDay.selectByIndex(3);

        WebElement monthPicker = driver.findElement(By.xpath(XPATH_MONTH_PICKER));
        Select selectMonth = new Select(monthPicker);
        selectMonth.selectByIndex(3);

        WebElement yearPicker = driver.findElement(By.xpath(XPATH_YEAR_PICKER));
        Select selectYear = new Select(yearPicker);
        selectYear.selectByIndex(3);
    }
}
