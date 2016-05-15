
package com.example.tests;

import org.testng.annotations.*;

import java.util.*;

import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactsCreationWithValidData(ContactsData contacts) throws Exception {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactsData> oldList = app.getContactHelper().getContacts();

        //actions
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