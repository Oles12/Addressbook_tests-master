package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class TestBase {

    protected static ApplicationManager app;


    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();

    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupsGenerator(){
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            GroupData group = new GroupData();
            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();
            list.add(new Object[]{group});
        }
        return list.iterator();
    }
    public String generateRandomString (){
        Random rnd = new Random();
        if(rnd.nextInt(3)== 0){
            return "" ;
        }
        else {
            return "test" + rnd.nextInt();
        }
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
            ContactsData contacts = new ContactsData();
            contacts.last_name = generateRandomString();
            contacts.first_name = generateRandomString();
            contacts.address1 = generateRandomString();
            list.add(new Object[]{contacts});
        }
        return list.iterator();
    }

    }





