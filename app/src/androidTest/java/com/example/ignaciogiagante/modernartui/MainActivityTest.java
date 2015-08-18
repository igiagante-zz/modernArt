package com.example.ignaciogiagante.modernartui;

import android.graphics.drawable.ColorDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.SeekBar;

import com.robotium.solo.Solo;

public class MainActivityTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
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

        // Wait for activity: 'com.example.ignaciogiagante.modernartui.MainActivity'
        solo.waitForActivity(com.example.ignaciogiagante.modernartui.MainActivity.class,
                delay);

        // Wait for view: 'R.id.seekbar'
        assertTrue("progressBar not found", solo.waitForView(R.id.seekbar));

        View view = solo.getCurrentActivity().findViewById(R.id.first_vertical);
        ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();

        SeekBar seekBar = (SeekBar)solo.getCurrentActivity().findViewById(R.id.seekbar);

        //Check color with progress bar position 0
        solo.setProgressBar(seekBar, 0);
        solo.sleep(delay);
        int intColor = colorDrawable.getColor();
        String strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#6A77B7", strColor);

        //Check color with progress bar position 51
        solo.setProgressBar(seekBar, 51);
        solo.sleep(delay);
        intColor = colorDrawable.getColor();
        strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#78B2C6", strColor);

        //Check color with progress bar position 102
        solo.setProgressBar(seekBar, 102);
        solo.sleep(delay);
        intColor = colorDrawable.getColor();
        strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#86D4BC", strColor);

        //Check color with progress bar position 153
        solo.setProgressBar(seekBar, 153);
        solo.sleep(delay);
        intColor = colorDrawable.getColor();
        strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#96E3A1", strColor);

        //Check color with progress bar position 204
        solo.setProgressBar(seekBar, 204);
        solo.sleep(delay);
        intColor = colorDrawable.getColor();
        strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#C7F1A6", strColor);

        //Check color with progress bar position 255
        solo.setProgressBar(seekBar, 255);
        solo.sleep(delay);
        intColor = colorDrawable.getColor();
        strColor = String.format("#%06X", 0xFFFFFF & intColor);
        assertEquals("#FFFFB7", strColor);
    }
}