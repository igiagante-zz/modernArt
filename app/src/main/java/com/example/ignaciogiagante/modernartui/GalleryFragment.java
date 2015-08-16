package com.example.ignaciogiagante.modernartui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class GalleryFragment extends Fragment {

    private View mRectOne;
    private View mRectTwo;
    private View mRectThree;
    private View mRectFour;
    private View mRectFive;

    private static final float proportion = 255f;

    public GalleryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    private void init(){

        mRectOne = getActivity().findViewById(R.id.first_vertical);
        mRectOne.setBackgroundColor(0xFF6A77B7);

        mRectTwo = getActivity().findViewById(R.id.second_vertical);
        mRectTwo.setBackgroundColor(0xFFD64F97);

        mRectThree = getActivity().findViewById(R.id.first_horizontal);
        mRectThree.setBackgroundColor(0xFFA31D21);

        mRectFour = getActivity().findViewById(R.id.second_horizontal);
        mRectFour.setBackgroundColor(0xFFE6E6E6);

        mRectFive = getActivity().findViewById(R.id.third_horizontal);
        mRectFive.setBackgroundColor(0xFF273A97);
    }

    public void updateColors(int value){
        updateRectOne(value);
        updateRectTwo(value);
        updateRectThree(value);
        updateRectFive(value);
    }

    private void updateRectOne(int value){
        // change top left rectange background color according
        // to seekbar progress from red to blue
        mRectOne.setBackgroundColor(interpolateColor(0xFFFFFFB7,
                0xFF6A77B7, value / proportion));

        // change middle right rectange background color according
        // to seekbar progress from blue to red
        mRectOne.setBackgroundColor(interpolateColor(0xFF6A77B7,
                0xFFFFFFB7, value / proportion));
    }

    private void updateRectTwo(int value){
        mRectTwo.setBackgroundColor(interpolateColor(0xFFFFE597,
                0xFFD64F97, value / proportion));
        mRectTwo.setBackgroundColor(interpolateColor(0xFFD64F97,
                0xFFFFE597, value / proportion));
    }

    private void updateRectThree(int value) {
        mRectThree.setBackgroundColor(interpolateColor(0xFFFFB321,
                0xFFA31D21, value / proportion));

        mRectThree.setBackgroundColor(interpolateColor(0xFFA31D21,
                0xFFFFB321, value / proportion));
    }

    private void updateRectFive(int value){
        mRectFive.setBackgroundColor(interpolateColor(0xFFBDD097,
                0xFF273A97, value / proportion));

        mRectFive.setBackgroundColor(interpolateColor(0xFF273A97,
                0xFFBDD097, value / proportion));
    }

    // used to take colors mix according to proportion
    private int interpolateColor(final int a, final int b,
                                 final float proportion) {
        final float[] hsva = new float[3];
        final float[] hsvb = new float[3];
        Color.colorToHSV(a, hsva);
        Color.colorToHSV(b, hsvb);
        for (int i = 0; i < 3; i++) {
            hsvb[i] = interpolate(hsva[i], hsvb[i], proportion);
        }
        return Color.HSVToColor(hsvb);
    }

    private float interpolate(final float a, final float b,
                              final float proportion) {
        return (a + ((b - a) * proportion));
    }
}
