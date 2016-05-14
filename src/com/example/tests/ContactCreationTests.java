
package com.example.tests;

import org.testng.annotations.*;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {


    @Test
    public void testNonEmptyContactsCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactsData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initContactsCreation();
        ContactsData contacts = new ContactsData();
        contacts.first_name = "first name 1";
        contacts.last_name = "last name 1";
        contacts.address1 = "address 1";
        contacts.homePhone = "0000";
        contacts.mobilePhone = "0971112233";
        contacts.email = "test@test.ua";
        contacts.birthDay = "1";
        contacts.birthMonth = "January";
        contacts.birthYear = "1970";
        app.getContactHelper().fillContactsForm(contacts);
        app.getContactHelper().submitContactsForm();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactsData> newList = app.getContactHelper().getContacts();

        //compare states

        oldList.add(contacts);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }


    @Test
    public void testEmptyContactsCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        // save old state
        List<ContactsData> oldList = app.getContactHelper().getContacts();

        //actions
        ContactsData contacts = new ContactsData("", "", "", "", "", "", "-", "-", "");
        app.getContactHelper().initContactsCreation();
        app.getContactHelper().fillContactsForm(contacts);
        app.getContactHelper().submitContactsForm();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactsData> newList = app.getContactHelper().getContacts();

        //compare states

        oldList.add(contacts);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }
}