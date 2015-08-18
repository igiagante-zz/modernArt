package com.example.ignaciogiagante.modernartui;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.robotium.solo.Solo;

/**
 * Created by ignaciogiagante on 8/17/15.
 */
public class BrowserTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public BrowserTest(){
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testRun(){

        int delay = 2000;

        //click item menu
        solo.clickOnMenuItem(getActivity().getString(R.string.more_information));
        solo.sleep(delay);

        //click on Not Now button
        solo.waitForDialogToOpen();
        solo.clickOnButton("Visit MOMA");

    }
}
