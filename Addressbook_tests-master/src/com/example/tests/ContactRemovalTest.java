package com.example.tests;


import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase{

    @Test

    public void deleteSomeContacts() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initDeleteEditContact(1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
    }
}
