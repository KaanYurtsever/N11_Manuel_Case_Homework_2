package com.n11.step_definitions;

import com.n11.pages.BasePage;
import com.n11.pages.BasketPage;
import com.n11.pages.PaymentPage;
import com.n11.pages.SearchPage;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProdsBasketStepDef {
    WebDriver driver= Driver.get();
    BasePage basePage= new BasePage();
    SearchPage searchPage=new SearchPage();
    BasketPage basketPage=new BasketPage();
    PaymentPage paymentPage=new PaymentPage();

    @Given("User opens the browser and goes to the home page and search the product {string}")
    public void user_opens_the_browser_and_goes_to_the_home_page_and_search_the_product(String product) {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Confirmation of the expected url equals current url
        Assert.assertEquals(ConfigurationReader.get("url"),driver.getCurrentUrl());
        //Searches wanted product
        basePage.searchProduct(product);
        //Confirmation of the correct list for the misspelled product
        Assert.assertTrue(searchPage.resultText.getText().contains("iphone"));
    }
    @When("User adds products to the basket and increases cheapest product quantity")
    public void user_adds_products_to_the_basket_and_increases_cheapest_product_quantity() throws InterruptedException {
        //Select wanted products
        searchPage.selectProduct();
        //Confirmation of the cheapest product number
        Assert.assertTrue(basketPage.productNumberTxt.getText().contains("3"));
        //Increase the cheapest product quantity
        basketPage.increaseCheapestProdQuantity();
        //Confirmation of basket size
        Assert.assertTrue(basketPage.productNumberTxt.getText().contains("5"));
    }
    @Then("User continues as guest and pays with wrong card number then fail")
    public void user_continues_as_guest_and_pays_with_wrong_card_number_then_fail() throws InterruptedException {
        //User continues as guest
        basketPage.continueAsGuest();
        //Confirmation of the payment page has been opened
        Assert.assertTrue(paymentPage.securePaymentTxt.getText().contains("GÜVENLİ ÖDEME"));
        //User tries to make payment
        paymentPage.makePayment();
        //Confirmation of user fails to make payment
        Assert.assertTrue(paymentPage.errorText.getText().contains("Geçersiz kredi kartı numarası"));
    }
}
