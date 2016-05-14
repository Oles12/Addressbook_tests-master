package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;


import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase{
   @Test
    public void modifySomeContacts() {

        app.getNavigationHelper().openMainPage();

       // save old state
       List<ContactsData> oldList = app.getContactHelper().getContacts();



       //actions
       app.getContactHelper().initDeleteEditContact(0);
       ContactsData contacts = new ContactsData();
       contacts.first_name = "New first name";
       contacts.last_name = "New last name";
       contacts.address1 = "New Address1";
       app.getContactHelper().fillContactsForm(contacts);
       app.getContactHelper().submitContactsModification();
       app.getContactHelper().returnToHomePage();

       //save new state
       List<ContactsData> newList = app.getContactHelper().getContacts();

       //compare states
       oldList.remove(0);
       oldList.add(contacts);
       Collections.sort(oldList);
       assertEquals(newList, oldList);
    }

}
