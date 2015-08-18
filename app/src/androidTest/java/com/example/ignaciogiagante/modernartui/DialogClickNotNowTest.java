package com.example.ignaciogiagante.modernartui;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by ignaciogiagante on 8/17/15.
 */
public class DialogClickNotNowTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public DialogClickNotNowTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testRun() {

        int delay = 2000;

        // Wait for activity: 'com.example.ignaciogiagante.modernartui.MainActivity'
        solo.waitForActivity(com.example.ignaciogiagante.modernartui.MainActivity.class,
                delay);

        solo.clickOnActionBarHomeButton();

        //click item menu
        solo.clickOnMenuItem(getActivity().getString(R.string.more_information));
        solo.sleep(delay);

        //click on Not Now button
        solo.waitForDialogToOpen();
        solo.clickOnButton("Not Now");

        //check if dialog is still opened
        assertTrue("Dialog was not closed", solo.waitForDialogToClose());
    }
}
