package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTest extends TestBase{

    @Test

    public void deleteSomeContacts() {
        app.getNavigationHelper().openMainPage();
        // save old state
        List<ContactsData> oldList = app.getContactHelper().getContacts();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        //actions
        app.getContactHelper().initDeleteEditContact(index);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
        //save new state
        List<ContactsData> newList = app.getContactHelper().getContacts();


        //compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }
}
