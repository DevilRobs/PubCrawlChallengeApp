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

        // Button to change the activity - just for testing
        Button btndo = (Button) findViewById(R.id.btnDOOOOO);
        btndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mainActivity, PlayerSelectionActivity.class);
                startActivity(i);
            }
        });


        // Listview to show all available challenges (text, description and icon)
        challengesListView = (ListView) findViewById(R.id.lv_challengesList);

        // create the List with the challenges to the list view - just for testing
        List <Challenges> challengesList = new LinkedList<>();
        challengesList.add(new Challenges("Erste Challenge",
                "Das ist nur eine Beispielbeschreibung von einer Challenge",
                 R.drawable.ic_android_black_24dp));

        challengesList.add(new Challenges("Zweite Challenge",
                "Das ist nur eine Beispielbeschreibung von der zweiten Challenge",
               R.drawable.ic_thumb_up_black_24dp));


        // set the adapter of the listview with the custom layout + adapter
        ListAdapter challengesListAdapter = new ChallengesListViewAdapter(this,
                R.layout.challenge_list_item, challengesList);

        // set the adapter to show the content in the listview
        challengesListView.setAdapter(challengesListAdapter);


    }
}
