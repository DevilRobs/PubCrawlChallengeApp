package com.example.rober.pubcrawlchallengeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import utilities.ProducedChallenge;


/**
 * Created by rober on 05.07.2017.
 */

public class ChallengeActivity extends AppCompatActivity {

    private static int currentTaskId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        List<String> tasks = getIntent().getStringArrayListExtra("Tasks");
        List<String> player = getIntent().getStringArrayListExtra("Players");

        TextView tv_task = (TextView) findViewById(R.id.tv_task);
        TextView tv_player = (TextView) findViewById(R.id.tv_player);
        //Show the task

        tv_task.setText(tasks.get(currentTaskId));
        tv_player.setText(player.get(new Random().nextInt(player.size())));


    }
}
