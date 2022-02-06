package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage{

    //Card number field
    @FindBy(className = "cardNumberInput")
    public WebElement cardNo;

    //Card's owner name field
    @FindBy(id = "cardOwnerName")
    public WebElement cardOwnerName;

    //Expire month of card
    @FindBy(id = "expireMonth")
    public WebElement cardMonth;

    //Expire year of card
    @FindBy(id = "expireYear")
    public WebElement cardYear;

    //Security code of card
    @FindBy(id = "securityCode")
    public WebElement cardSecurityCode;

    //Make payment button
    @FindBy(id = "js-paymentBtn")
    public WebElement makePaymentBtn;

    //Invalid card number text
    @FindBy(className = "errorText")
    public WebElement errorText;

    //Secure payment text which is on the payment page
    @FindBy(className = "securePayment")
    public WebElement securePaymentTxt;

    public void makePayment(){

        //Write card's number
        cardNo.sendKeys("2222");
        //Write card's owner name
        cardOwnerName.sendKeys("Kaan Yurtsever");
        //Create an object for dropdown and select the card month
        Select month = new Select(cardMonth);
        month.selectByVisibleText("7");
        //Create an object for dropdown and select the card year
        Select year = new Select(cardYear);
        year.selectByVisibleText("2027");
        //Write card's security code
        cardSecurityCode.sendKeys("3333");
        //To make payment
        makePaymentBtn.click();
    }
}
