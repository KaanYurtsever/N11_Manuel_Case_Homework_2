package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    //Result text of searched product
    @FindBy(className = "result-item")
    public WebElement resultText;

    //Number of products in a page
    @FindBy(css = "[content='TRY']")
    public List<WebElement> productsNum;

    //Third page button
    @FindBy(xpath = "//*[@class=\"pagination\"]/a[3]")
    public WebElement thirdPageBtn;

    //Add basket button
    @FindBy(className = "icon-white-basket")
    public WebElement addBasketBtn;

    //Go basket button
    @FindBy(className = "btnGoBasket")
    public WebElement basketBtn;

    //Get driver
    WebDriver driver = Driver.get();

    public void selectProduct() {
        //Get products page url
        String actualUrl = Driver.get().getCurrentUrl();
        Actions actions = new Actions(Driver.get());
        //Scroll to first product
        actions.moveToElement(productsNum.get(0)).perform();
        //Get first product
        productsNum.get(0).click();
        //Add product to basket
        addBasketBtn.click();

        //Back to products page
        driver.get(actualUrl);
        //Index of last product
        int lastProduct = productsNum.size() - 1;
        //Scroll to first product
        actions.moveToElement(productsNum.get(lastProduct)).perform();
        //Get last product
        productsNum.get(lastProduct).click();
        //Add product to basket
        addBasketBtn.click();

        //Back to products page
        driver.get(actualUrl);
        //Goes to the third page
        thirdPageBtn.click();
        //Scroll to fourth product
        actions.moveToElement(productsNum.get(4)).perform();
        //Get fourth product
        productsNum.get(4).click();
        //Add product to basket
        addBasketBtn.click();

        //Goes to the basket
        basketBtn.click();
    }
}
