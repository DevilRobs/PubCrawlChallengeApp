package com.example.rober.pubcrawlchallengeapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilities.Task;

/**
 * Created by rober on 12.07.2017.
 */

public class DatabaseHelper {

    private static FirebaseDatabase database;
    private static List allTasks;
    private static HashMap data;

    private List<Task> introTasks, extroTasks, sexualTasks, senselessTasks, menTasks, womenTasks;

    private String TAG = "DatabaseHelper";

    public DatabaseHelper() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                data = (HashMap) dataSnapshot.getValue();

                //Get the list of tasks
                allTasks = (ArrayList) data.get(0);

                //Get the list of something else
                //...
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    public List<Task> getTasks() {
        Log.i(TAG, "Tasks returned, size = " + allTasks.size());

        return allTasks;
    }

    private void separateTasks() {
        //for(Map hs : allTasks){

        //}
    }


}
