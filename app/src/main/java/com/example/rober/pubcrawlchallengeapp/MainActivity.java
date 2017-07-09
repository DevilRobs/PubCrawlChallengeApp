package com.example.rober.pubcrawlchallengeapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import utilities.Challenges;
import utilities.ChallengesListViewAdapter;

public class MainActivity extends Activity {

    private String TAG = "MainActivity";
    private ListView challengesListView;
    private Activity mainActivity = this;
    private ImageView iv_change_challenge_style;
    private int challengesLayout = 0;
    private ChallengesListViewAdapter challengesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_appname = (TextView) findViewById(R.id.tv_appName);
        tv_appname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(mainActivity, PlayerSelectionActivity.class));
            }
        });
        challengeListSetup();
        handleStyleChange();






    }

    private void challengeListSetup() {


        // Listview to show all available challenges (text, description and icon)
        challengesListView = (ListView) findViewById(R.id.lv_challengesList_1col);

        // create the List with the challenges to the list view - just for testing
        List <Challenges> challengesList = new LinkedList<>();
        challengesList.add(new Challenges("Erste Challenge",
                "1",
                R.drawable.ic_android_black_24dp));

        challengesList.add(new Challenges("Zweite Challenge",
                "2",
                R.drawable.ic_thumb_up_black_24dp));

        challengesList.add(new Challenges("Dritte Challenge",
                "3", R.drawable.ic_thumb_up_black_24dp));

        if(true){
            // int numberOfItems = challengesList.size();
            List<Challenges> col1 = new LinkedList<>(), col2 = new LinkedList<>();

            int numberOfItems = challengesList.size()%2 == 0 ? challengesList.size()/2 : challengesList.size()/2+1;

            Log.d("mod", "" + numberOfItems%2);

            for(int i = 0; i < numberOfItems; i++){
                col1.add(challengesList.get(i));

            }
            for(int j = numberOfItems; j < challengesList.size(); j++){
                col2.add(challengesList.get(j));
            }

            for(Challenges c : col1){
                Log.d("listed1", c.getChallengeName());
            }
            for(Challenges c : col2){
                Log.d("listed2", c.getChallengeName());
            }



        }


        // set the adapter of the listview with the custom layout + adapter
        challengesListAdapter = new ChallengesListViewAdapter(this,
                R.layout.challenge_list_item, challengesList);

        // set the adapter to show the content in the listview
        challengesListView.setAdapter(challengesListAdapter);
    }

    private void handleStyleChange() {
        iv_change_challenge_style = (ImageView) findViewById(R.id.iv_change_challenges_style);
        iv_change_challenge_style.setImageResource(R.drawable.ic_format_paint_white_24dp);

        iv_change_challenge_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog selectStyleDialog = new Dialog(mainActivity);
                selectStyleDialog.setContentView(R.layout.dialog_select_style);
                selectStyleDialog.setTitle("Custom Dialog");
                selectStyleDialog.show();



                Button btn_full = (Button) selectStyleDialog.findViewById(R.id.btn_styleFull);
                Button btn_slim = (Button) selectStyleDialog.findViewById(R.id.btn_styleSlim);
                Button btn_light = (Button) selectStyleDialog.findViewById(R.id.btn_styleLight);

                btn_full.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        challengesLayout = 1;
                        challengesListAdapter.setLayout(1);
                        challengesListView.setAdapter(challengesListAdapter);
                        challengesListAdapter.notifyDataSetChanged();
                        selectStyleDialog.dismiss();
                    }
                });

                btn_slim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        challengesLayout = 2;
                        challengesListAdapter.setLayout(2);
                        challengesListView.setAdapter(challengesListAdapter);
                        challengesListAdapter.notifyDataSetChanged();
                        selectStyleDialog.dismiss();

                    }
                });


                btn_light.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        challengesLayout = 3;
                        challengesListAdapter.setLayout(3);
                        challengesListView.setAdapter(challengesListAdapter);
                        challengesListAdapter.notifyDataSetChanged();
                        selectStyleDialog.dismiss();

                    }
                });





            }
        });

    }

}
