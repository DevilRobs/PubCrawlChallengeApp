package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by rober on 05.07.2017.
 */

public class PlayerSelectionActivity extends AppCompatActivity {

    private Activity activity = this;
    private String TAG = "PlayerSelection";
    private int playerCounter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerselection);

        //Initialize Elements
        Button btn_addPlayer = (Button) findViewById(R.id.btn_addPlayer);

        //Register the Listener
        btn_addPlayer.setOnClickListener(addPlayer);

        //Initialize with 4 players
        for(int i = 0; i < 4; i++){
            createPlayerElement();
        }
    }

    private View.OnClickListener addPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i(TAG, "Add Player!");
            createPlayerElement();
        }
    };

    private void createPlayerElement() {
        Log.i(TAG, "Create Player!");
        //Initalize Parameter for the layout
        LinearLayout.LayoutParams ll_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        //Initialize Paramter for the edit text
        LinearLayout.LayoutParams et_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 7

        );
        //Initialize Paramter for the switch
        LinearLayout.LayoutParams sw_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 2
        );

        //create a new LinearLayout
        LinearLayout ll_player = new LinearLayout(activity);
        ll_player.setLayoutParams(ll_params);
        ll_player.setOrientation(LinearLayout.HORIZONTAL);
        ll_player.setPadding(10,10,10,10);
        ll_player.setWeightSum(10);


        //create a new EditText
        EditText et_playerName = new EditText(activity);
        et_playerName.setLayoutParams(et_params);
        playerCounter += 1;
        et_playerName.setHint("Player "+playerCounter);


        //create a new Switch
        Switch sw_playerGender = new Switch(activity);
        sw_playerGender.setLayoutParams(sw_params);
        sw_playerGender.setPadding(15,0,0,0);
        sw_playerGender.setTextOff("HALO");
        sw_playerGender.setTextOn(getString(R.string.sw_gender_female));


        //register elements
        ll_player.addView(et_playerName);
        ll_player.addView(sw_playerGender);
        LinearLayout lv = (LinearLayout) findViewById(R.id.layout_player);
        lv.addView(ll_player);
    }
}
