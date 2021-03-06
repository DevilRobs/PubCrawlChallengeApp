package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.content.Intent;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import utilities.Player;
import utilities.ProducedChallenge;
import utilities.ReducedChallenge;
import utilities.Task;

/**
 * Created by rober on 05.07.2017.
 */

public class PlayerSelectionActivity extends AppCompatActivity {

    private Activity activity = this;
    private String TAG = "PlayerSelection";
    private int playerCounter = 0;

    private DatabaseHelper dbh;

    private int selectedChallenge = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerselection);

        //Initialize Elements
        Button btn_addPlayer = (Button) findViewById(R.id.btn_addPlayer);
        Button btn_startChallenge = (Button) findViewById(R.id.btn_startChallenge);

        //Register the Listener
        btn_addPlayer.setOnClickListener(addPlayer);
        btn_startChallenge.setOnClickListener(startChallenge);

        //Initialize with 4 players
        for (int i = 0; i < 4; i++) {
            createPlayerElement();
        }

        //Initialize task database
        dbh = new DatabaseHelper();

    }

    private View.OnClickListener addPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i(TAG, "Add Player!");
            createPlayerElement();
        }
    };

    private View.OnClickListener startChallenge = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            List players = getPlayers();
            AlgorithmGenerator ag = new AlgorithmGenerator(dbh, selectedChallenge, players);
            ProducedChallenge pc = ag.generateChallenge();

            //Time to send the challenge
            Intent intent = new Intent(activity, ChallengeActivity.class);
            ReducedChallenge rc = new ReducedChallenge(pc.getTasks(), pc.getPlayers(), true);


            intent.putStringArrayListExtra("Tasks" , rc.getTasks());
            intent.putIntegerArrayListExtra("Points", rc.getTasksPoints());
            intent.putStringArrayListExtra("Players", rc.getPlayers());
            startActivity(intent);
        }
    };

    private void createPlayerElement() {
        Log.i(TAG, "Create Player!");
        //Initalize Parameter for the layout
        LinearLayout.LayoutParams ll_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 10
        );
        //Initialize Parameter for the edit text
        LinearLayout.LayoutParams et_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 9

        );
        //Initialize Parameter for the switch
        LinearLayout.LayoutParams sw_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1
        );

        //create a new LinearLayout
        LinearLayout ll_player = new LinearLayout(activity);
        ll_player.setLayoutParams(ll_params);
        ll_player.setOrientation(LinearLayout.HORIZONTAL);
        ll_player.setPadding(10, 10, 10, 10);
        ll_player.setWeightSum(10);


        //create a new EditText
        EditText et_playerName = new EditText(activity);
        et_playerName.setLayoutParams(et_params);
        playerCounter += 1;
        et_playerName.setHint("Player " + playerCounter);


        //create a new Switch
        final Switch sw_playerGender = new Switch(activity);
        sw_playerGender.setLayoutParams(sw_params);
        sw_playerGender.setPadding(10, 0, 0, 0);
        sw_playerGender.setText(R.string.sw_gender_male);
        sw_playerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw_playerGender.isChecked()) {
                    sw_playerGender.setText(R.string.sw_gender_female);
                } else {
                    sw_playerGender.setText(R.string.sw_gender_male);
                }
            }
        });

        //register elements
        ll_player.addView(et_playerName);
        ll_player.addView(sw_playerGender);
        LinearLayout lv = (LinearLayout) findViewById(R.id.layout_player);
        lv.addView(ll_player);

    }

    private List getPlayers(){

        List<Player> l = new LinkedList<>();

        LinearLayout lv = (LinearLayout) findViewById(R.id.layout_player);
        final int childCount = lv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout ll = (LinearLayout) lv.getChildAt(i);
            EditText et = (EditText) ll.getChildAt(0);
            String name = et.getText().toString();

            Switch sw = (Switch) ll.getChildAt(1);
            boolean gender = sw.getText().equals("Boy");

            l.add(new Player(name, gender));
        }
        return l;
    }


}
