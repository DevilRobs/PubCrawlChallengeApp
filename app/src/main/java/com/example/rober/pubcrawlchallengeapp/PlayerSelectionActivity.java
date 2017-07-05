package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rober on 05.07.2017.
 */

public class PlayerSelectionActivity extends AppCompatActivity {

    private Activity activity = this;
    private String TAG = "PlayerSelection";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerselection);
        addPlayer();
    }

    public void addPlayer(){
        System.out.println("test");
        Log.i(TAG, "aufgerufen");
        Button b = (Button) findViewById(R.id.b_addPlayer);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "clicked");
                ActionBar.LayoutParams lparams = new ActionBar.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                TextView tv=new TextView(activity);
                tv.setLayoutParams(lparams);
                tv.setText("test");
                LinearLayout lv = (LinearLayout) findViewById(R.id.layoutlinear);
                lv.addView(tv);
            }
        });
    }
}
