package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasketPage extends BasePage {

    //Guest customer lighting text close button
    @FindBy(xpath = "(//*[@class=\"closeBtn\"])[3]")
    public WebElement closeMessageBtn;

    //Prices of products in the basket
    @FindBy(name = "productDisplayPrice")
    public List<WebElement> productPrice;

    //increase product quantity
    @FindBy(className = "spinnerUp")
    public List<WebElement> quantityUp;

    //Buy products in the basket
    @FindBy(id = "js-buyBtn")
    public WebElement buyBtn;

    //Continue as guest
    @FindBy(className = "btn-continue")
    public WebElement continueBtn;

    //Email field for guest
    @FindBy(id = "guestEmail")
    public WebElement emailField;

    //Guest email check button
    @FindBy(id ="js-guestEmailCheck")
    public WebElement emailCheckBtn;

    //Full name field
    @FindBy(id ="fullName")
    public WebElement fullName;

    //City name field
    @FindBy(id ="cityId")
    public WebElement cityId;

    //District name field
    @FindBy(id ="districtId")
    public WebElement districtId;

    //Neighbourhood name field
    @FindBy(id ="neighbourhoodId")
    public WebElement neighbourhoodId;

    //Address details field
    @FindBy(id ="addressDetail")
    public WebElement addressDetail;

    //Phone number field
    @FindBy(id ="gsm")
    public WebElement phoneNum;

    //National ID field
    @FindBy(id ="shippingAddresstcNO")
    public WebElement shippingAddresstcNO;

    //Address name field
    @FindBy(id ="addressName")
    public WebElement addressName;

    //Go to payment button
    @FindBy(id="js-goToPaymentBtn")
    public WebElement goToPaymentBtn;

    //Total product
    @FindBy(css =".dtl.header")
    public WebElement productNumberTxt;

    public void increaseCheapestProdQuantity() throws InterruptedException {
        //Clicks guest customer lighting text
        closeMessageBtn.click();
        //Cheapest product price
        int cheapestProd=0;
        //Assuming the cheapest product is the first product
        int cheapestPrice = Integer.parseInt(productPrice.get(0).getAttribute("value"));
        for (int i = 0; i < productPrice.size(); i++) {//Gives us how many products on the basket page or number of products on the basket page
            //Prices of each product on the page
            int actualPrice = Integer.parseInt(productPrice.get(i).getAttribute("value"));
            //Compares that actual price of product in for loop is less than the cheapest product
            if (actualPrice < cheapestPrice) {
                cheapestPrice = actualPrice;
                //Index of the cheapest product on the basket page
                cheapestProd= i;
            }
        }

        Thread.sleep(2000);
        //Increases the cheapest product quantity by 1 to 3
        BrowserUtils.doubleClick(quantityUp.get(cheapestProd));
        Thread.sleep(6000);
    }

    public void continueAsGuest() throws InterruptedException {
        //To buy all products in the basket
        buyBtn.click();
        //Wait for continue as guest button is visible
        BrowserUtils.waitForVisibility(continueBtn, 10);
        //Click continue as guest
        continueBtn.click();
        //Wait for email field is visible
        BrowserUtils.waitForVisibility(emailField, 10);
        //Write email
        emailField.sendKeys("asdasdsdfsdf32323423fdsasdsa@gmail.com");
        //Clicks email check button
        emailCheckBtn.click();
        //Write full name
        fullName.sendKeys("Kaan Yurtsever");
        //Create an object for dropdown and select the city
        Select city = new Select(cityId);
        city.selectByVisibleText("İzmir");
        //Create an object for dropdown and select the district
        Select district = new Select(districtId);
        district.selectByVisibleText("Karşıyaka");
        //Create an object for dropdown and select the neighbourhood
        Select neighbourhood = new Select(neighbourhoodId);
        neighbourhood.selectByVisibleText("Atakent");
        //Write address details
        addressDetail.sendKeys("Atakent mahallesi");
        //Click on phone number field and write a number
        phoneNum.click();
        phoneNum.sendKeys("328887766");
        //Write national ID
        shippingAddresstcNO.sendKeys("18934465314");
        //Write address name
        addressName.sendKeys("Atakent mahallesi migros");
        //To go to make payment
        goToPaymentBtn.click();
        Thread.sleep(1500);
    }
}
