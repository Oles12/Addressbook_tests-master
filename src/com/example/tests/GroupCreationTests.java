
package com.example.tests;

import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends TestBase{

        @Test(dataProvider = "randomValidGroupsGenerator")
        public void testGroupCreationWithValidData(GroupData group) throws Exception {
            app.getNavigationHelper().openMainPage();
            app.getNavigationHelper().goToGroupsPage();
            // save old state
            List<GroupData> oldList = app.getGroupHelper().getGroups();

            //actions
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().returnToGroupsPage();

            //save new state
            List<GroupData> newList = app.getGroupHelper().getGroups();

            //compare states
            oldList.add(group);
            Collections.sort(oldList);
            assertEquals(newList, oldList);
        }
    }



