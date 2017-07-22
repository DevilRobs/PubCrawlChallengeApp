package com.example.rober.pubcrawlchallengeapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilities.Task;

/**
 * Created by rober on 12.07.2017.
 */

public class DatabaseHelper {

    private  FirebaseDatabase database;
    private  List allTasks;
    private  List allChallenges;
    private  HashMap data;

    private  List introTasks, extroTasks, sexualTasks, senselessTasks, menTasks, womenTasks, genderlessTasks;

    private  String TAG = "DatabaseHelper";

    public DatabaseHelper() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                data = (HashMap) dataSnapshot.getValue();
                Log.i(TAG, "Database created");

                //Get the list of tasks
                allTasks = (ArrayList) data.get("Tasks");
                allChallenges = (ArrayList) data.get("Challenges");
                separateTasks();

                //Get the list of something else
                //...
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i(TAG, "Failed to read value.", error.toException());
            }
        });

        introTasks = new ArrayList();
        extroTasks = new ArrayList();
        womenTasks = new ArrayList();
        menTasks = new ArrayList();
        senselessTasks = new ArrayList();
        sexualTasks = new ArrayList();
        genderlessTasks = new ArrayList();
    }

    public  List getIntroTasks() {
        return introTasks;
    }

    public  List getExtroTasks() {
        return extroTasks;
    }

    public  List getSexualTasks() {
        return sexualTasks;
    }

    public  List getSenselessTasks() {
        return senselessTasks;
    }

    public  List getMenTasks() {
        return menTasks;
    }

    public  List getWomenTasks() {
        return womenTasks;
    }

    public  List getGenderlessTasks() {
        return genderlessTasks;
    }

    public  List getAllChallenges(){
        return allChallenges;
    }


    public  List<Task> getTasks() {
        Log.i(TAG, "Tasks returned");
        return allTasks;
    }

    private void separateTasks() {

        if (allTasks != null) for (Object obj : allTasks) {
            Map hs = (HashMap) obj;


            //Iterator to go through all keys.
            /*Iterator<Integer> keySetIterator = hs.keySet().iterator();

                while (keySetIterator.hasNext()) {

                    //As the keys are also String we need to take the value of the int
                    String key = String.valueOf(keySetIterator.next());

                    Log.i(TAG, "key: " + key + " value: " + hs.get(key));


                }*/

            //Assign all the tasks
            if (hs.get("Women").equals("Y") && hs.get("Men").equals("N")) womenTasks.add(obj);
            if (hs.get("Men").equals("Y") && hs.get("Women").equals("N")) menTasks.add(obj);
            if (hs.get("Introvertiert").equals("Y")) introTasks.add(obj);
            if (hs.get("Extrovertiert").equals("Y")) extroTasks.add(obj);
            if (hs.get("Sexual").equals("Y")) sexualTasks.add(obj);
            if (hs.get("Senseless").equals("Y")) senselessTasks.add(obj);

            if (hs.get("Women").equals("Y") && hs.get("Men").equals("Y")) {
                genderlessTasks.add(obj);
            }

            Log.i(TAG, "Tasks seperated!");
        }
    }

    public Task getTasksWithId(int id){
        return (Task)allTasks.get(id);
    }

}
