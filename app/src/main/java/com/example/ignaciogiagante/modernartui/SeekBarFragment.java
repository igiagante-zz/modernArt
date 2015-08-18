package com.example.ignaciogiagante.modernartui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by ignaciogiagante on 8/16/15.
 */
public class SeekBarFragment extends Fragment {

    private onSeekChangedListener mOnSeekChangedListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View viewContainer = inflater.inflate(R.layout.fragment_seek_bar, container);

        SeekBar seekBar = (SeekBar) viewContainer.findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                mOnSeekChangedListener.updateColors(progressChanged);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getActivity(), "Progress: " + progressChanged, Toast.LENGTH_SHORT).show();
            }
        });

        return  viewContainer;
    }

    public interface onSeekChangedListener{
       void updateColors(int value);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mOnSeekChangedListener = (onSeekChangedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSeekChangedListener");
        }
    }
}
