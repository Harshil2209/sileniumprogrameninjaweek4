package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class LogoutPage extends Utility {
    By logoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

    public String getTextFromLogout() {
        return getTextFromElement(logoutText);
    }

}
