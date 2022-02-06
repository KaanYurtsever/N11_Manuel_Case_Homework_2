package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {PageFactory.initElements(Driver.get(), this);}

    //The field which for search product
    @FindBy(id = "searchData")
    public WebElement searchField;

    //Search button
    @FindBy(className = "searchBtn")
    public WebElement searchBtn;

    public void searchProduct(String product){
        //Writes a product to search field then search
        searchField.sendKeys(product);
        searchBtn.click();
    }
}
