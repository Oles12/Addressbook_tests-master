package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTest extends TestBase{

    @Test

    public void deleteSomeContacts() {
        app.getNavigationHelper().openMainPage();
        // save old state
        List<ContactsData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initDeleteEditContact(0);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
        //save new state
        List<ContactsData> newList = app.getContactHelper().getContacts();

        //compare states

        oldList.remove(0);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }
}
