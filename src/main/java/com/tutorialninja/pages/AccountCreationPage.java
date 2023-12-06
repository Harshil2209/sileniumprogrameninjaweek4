package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class AccountCreationPage extends Utility {
    By accountCreationText = By.xpath("//div[@id='content']/h1");
    By continueAfterAccountCreation = By.xpath("//a[text()='Continue']");

    public String getAccountCreationMessage() {
        return getTextFromElement(accountCreationText);

    }

    public void clickOnContinueAfterAccountCreation() {
        clickOnElement(continueAfterAccountCreation);
    }

}
