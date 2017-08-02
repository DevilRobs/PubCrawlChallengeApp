package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import utilities.ProducedChallenge;


/**
 * Created by rober on 05.07.2017.
 */

public class ChallengeActivity extends AppCompatActivity {

    LinearLayout ll_challengeActivity;

    private static int currentTaskId = -1;
    private String currentPlayer;

    private Activity activity = this;

    TextView tv_task, tv_player, tv_points;

    Button btn_done, btn_refuse, btn_score, btn_pause;

    List<String> tasks;
    List<Integer> points;
    List<String> player;

    Map<String, Integer> playerMap;

    final private long DIALOG_DISMISS_TIMER = 3000;

    PopupWindow popup_scoreboard;
    Boolean popup_scoreboard_isClicked = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        ll_challengeActivity = (LinearLayout) findViewById(R.id.ll_challengeActivity);

        tv_task = (TextView) findViewById(R.id.tv_task);
        tv_player = (TextView) findViewById(R.id.tv_player);
        tv_points = (TextView) findViewById(R.id.tv_points);

        btn_done = (Button) findViewById(R.id.btn_done);
        btn_refuse = (Button) findViewById(R.id.btn_refuse);
        btn_score = (Button) findViewById(R.id.btn_scores);
        btn_pause = (Button) findViewById(R.id.btn_pause);

        tasks = getIntent().getStringArrayListExtra("Tasks");
        points = getIntent().getIntegerArrayListExtra("Points");
        player = getIntent().getStringArrayListExtra("Players");

        playerMap = new HashMap<>();
        for (String p : player) {
            playerMap.put(p, 0);
        }


        //register listener
        btn_done.setOnClickListener(doneListener);
        btn_refuse.setOnClickListener(refuseListener);

        //Show the task
        setTask();

    }

    private View.OnClickListener doneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String earnedPoints = String.valueOf(points.get(currentTaskId));
            playerMap.put(currentPlayer, playerMap.get(currentPlayer) + points.get(currentTaskId));

            //We create and show an AlertDialog (I WANT SOME FANCY ANIMATIONS!!!!!!!)
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(currentPlayer + " -> " + earnedPoints);
            final AlertDialog dialog = builder.create();
            dialog.show();
            new CountDownTimer(DIALOG_DISMISS_TIMER, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    dialog.dismiss();
                    setTask();
                }
            }.start();
        }
    };

    private View.OnClickListener refuseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setTask();
        }
    };


    private void setTask() {
        currentTaskId++;
        currentPlayer = player.get(new Random().nextInt(player.size()));
        tv_player.setText(currentPlayer + ": ");
        tv_task.setText(tasks.get(currentTaskId));
        tv_points.setText("Reward: " + String.valueOf(points.get(currentTaskId)) + " Points!");
    }

    private View.OnClickListener scoreboardListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (popup_scoreboard_isClicked) {
                popup_scoreboard_isClicked = false;
                popup_scoreboard.showAtLocation(ll_challengeActivity, Gravity.BOTTOM, 10, 10);
                popup_scoreboard.update(50, 50, 320, 90);
            } else {
                popup_scoreboard_isClicked = true;
                popup_scoreboard.dismiss();
            }
        }
    };
};


