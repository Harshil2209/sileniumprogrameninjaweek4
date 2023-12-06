package com.tutorialninja.testsuite;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCartPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //choose desktop dropdown
        homePage.mouseHoverAndClickOnDesktop();
        //show all desktops
        homePage.selectMenu("Show All Desktops");
        desktopPage.clickOnSortByPosition();
        //store all products in the expected order in a List
        List<String> expectedOrder = desktopPage.expectedList();
        //store all products in the actual order in a List
        List<String> actualOrder = desktopPage.getSortByAlphabeticalSelection();
        System.out.println("expected: " + expectedOrder);
        System.out.println("actual: " + actualOrder);
        Assert.assertEquals(actualOrder, expectedOrder, "Product not sorted into Z to A order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverAndClickOnDesktop();
        homePage.selectMenu("Show All Desktops");
        desktopPage.clickOnSortByPosition();
        desktopPage.selectSortByAToZ();
        desktopPage.clickOnHPLP3065();
        String expectedProduct = "HP LP3065";
        String actualProduct = productPage.getHPLP3065text();
        Assert.assertEquals(actualProduct, expectedProduct, "HP LP3065 not displayed");
        productPage.selectDate("30", "November", "2022");
        productPage.clearAndAddQuantity("1");
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.isSuccessMessageAppearing(), "Success: You have added HP LP3065 to your shopping cart!" + "\n×");
        Thread.sleep(500);
        productPage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065", "Product Name Doesn't appear");
        Assert.assertTrue(shoppingCartPage.isDeliveryDateAppearing(), "Delivery Date Doesn't Appear");
        Assert.assertEquals(shoppingCartPage.getModelText(), "Product 21", "Model Name Doesn't appear");
        Assert.assertEquals(shoppingCartPage.getTotalText(), "$122.00", "Total Doesn't appear");
    }

}
