
package com.example.tests;

import org.testng.annotations.*;


public class ContactCreationTests extends TestBase {


    @Test
    public void testNonEmptyContactsCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactsCreation();

        ContactsData contacts = new ContactsData();
        contacts.first_name = "first name 1";
        contacts.last_name = "last name 1";
        contacts.address1 = "address 1";
        contacts.homePhone = "123456";
        contacts.mobilePhone = "0971112233";
        contacts.email = "test@test.ua";
        contacts.birthDay = "1";
        contacts.birthMonth = "January";
        contacts.birthYear = "1970";


        app.getContactHelper().fillContactsForm(contacts);
        app.getContactHelper().submitContactsForm();
        app.getContactHelper().returnToHomePage();
    }


    @Test
    public void testEmptyContactsCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactsCreation();
        app.getContactHelper().fillContactsForm(new ContactsData("", "", "", "", "", "", "-", "-", ""));
        app.getContactHelper().submitContactsForm();
        app.getContactHelper().returnToHomePage();

    }
}