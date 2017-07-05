package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import utilities.Challenges;
import utilities.ChallengesListViewAdapter;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private ListView challengesListView;
    private Activity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "New Application");

        Button btndo = (Button) findViewById(R.id.btnDOOOOO);
        btndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mainActivity, PlayerSelectionActivity.class);
                startActivity(i);
            }
        });



        challengesListView = (ListView) findViewById(R.id.lv_challengesList);


        List <Challenges> challengesList = new LinkedList<>();
        challengesList.add(new Challenges("Erste Challenge",
                "Das ist nur eine Beispielbeschreibung von einer Challenge",
                 getResources().getDrawable(R.drawable.ic_android_black_24dp)));

        challengesList.add(new Challenges("Zweite Challenge",
                "Das ist nur eine Beispielbeschreibung von der zweiten Challenge",
                getResources().getDrawable(R.drawable.ic_thumb_up_black_24dp)));



        ListAdapter challengesListAdapter = new ChallengesListViewAdapter(this,
                R.layout.challenge_list_item, challengesList);

        challengesListView.setAdapter(challengesListAdapter);


    }
}
