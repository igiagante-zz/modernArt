package com.example.ignaciogiagante.modernartui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBarFragment.onSeekChangedListener {

    private GalleryFragment mGalleryFragment;
    private DialogFragment mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        if(actionBar != null){
            actionBar.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_information) {
            // Create a new AlertDialogFragment
            mDialog = AlertDialogFragment.newInstance();
            // Show AlertDialogFragment
            mDialog.show(getFragmentManager(), "Alert");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateColors(int value) {
       mGalleryFragment = (GalleryFragment) getFragmentManager().findFragmentById(R.id.gallery_fragment);

        if(mGalleryFragment != null){
            mGalleryFragment.updateColors(value);
        }
    }

    public static class AlertDialogFragment extends DialogFragment {

        public static AlertDialogFragment newInstance(){
            return new AlertDialogFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            TextView myMsg = new TextView(getActivity());
            myMsg.setText("Inspired by the works of artists such as \n" +
                    "Check below to learn more!");
            myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
            myMsg.setTextSize(20);
            myMsg.setPadding(5, 5, 5, 5);
            myMsg.setTextColor(Color.BLACK);

            return new AlertDialog.Builder(getActivity())
                    .setView(myMsg)

                    .setCancelable(true)

                    .setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })

                    .setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org/"));
                            startActivity(browserIntent);
                            dialog.dismiss();
                        }
                    }).create();
        }
    }
}
