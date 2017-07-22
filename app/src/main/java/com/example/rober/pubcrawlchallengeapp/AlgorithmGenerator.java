package com.example.rober.pubcrawlchallengeapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utilities.Player;
import utilities.ProducedChallenge;
import utilities.Task;

/**
 * Created by rober on 14.07.2017.
 */

public class AlgorithmGenerator {

    String TAG = "AlgorithmGenerator";

    private List tasksToUse;
    private int selectedChallenge;
    private List<Player> players;
    private DatabaseHelper dbh;

    final int NR_OF_TASKS = 3;

    private int genderPercentage;


    public AlgorithmGenerator(DatabaseHelper dbh, int selectedChallenge, List players) {
        this.dbh = dbh;
        this.selectedChallenge = selectedChallenge;
        this.players = players;
        this.genderPercentage = getGenderPercentage();

        tasksToUse = new ArrayList(this.dbh.getTasks());

        if(genderPercentage == 100){
            tasksToUse.removeAll(this.dbh.getWomenTasks());
        }else if(genderPercentage == 0){
            tasksToUse.removeAll(this.dbh.getMenTasks());
        }else{
            tasksToUse.removeAll(this.dbh.getMenTasks());
            tasksToUse.removeAll(this.dbh.getWomenTasks());
        }
    }

    //Calculate the genderPercentage
    private int getGenderPercentage(){
        int nrOfMen = 0;
        for(int i = 0; i < players.size(); i++){
            Player p = players.get(i);
            if(p.isGender()) nrOfMen++;
        }
        return(Math.round((nrOfMen*100)/players.size()));
    }

    //Generates the challenge
    public ProducedChallenge generateChallenge() {

        ProducedChallenge pc = new ProducedChallenge();
        pc.setPlayers(players);


        //0 = extrovertedChallenge
        //1 = introvertedChallenge
        //2 = senseless
        //3 = sexual
        switch (selectedChallenge) {
            case 0:
                tasksToUse.retainAll(dbh.getExtroTasks());
                break;
            case 1:
                tasksToUse.retainAll(dbh.getIntroTasks());
                break;
            case 2:
                tasksToUse.retainAll(dbh.getSenselessTasks());
                break;
            case 3:
                tasksToUse.retainAll(dbh.getSexualTasks());
                break;
        }

        addTasksToChallenge(tasksToUse, pc);

        return pc;
    }

    //Adds the main tasks to the challenge
    private void addTasksToChallenge(List mainTasks, ProducedChallenge pc) {
        List listOfTasks = new ArrayList();

        //Nr of taken main tasks
        int nrOfMainTasks = (int) Math.round(NR_OF_TASKS * 0.6);

        Random r = new Random();
        List<Integer> usedInts = new ArrayList<>();
        for (int i = 0; i < nrOfMainTasks; i++) {
            //Generate a random Int to take a random tasks
            int randomInt = r.nextInt(mainTasks.size());

            //If this tasks is already taken then choose another one
            if (!usedInts.contains(randomInt)) {
                listOfTasks.add(mainTasks.get(randomInt));
                usedInts.add(randomInt);
            } else {
                i--;
                if (usedInts.size() == mainTasks.size()) break;
            }
        }

        List remainingTasks = getRemainingTasks(NR_OF_TASKS - nrOfMainTasks, mainTasks);
        listOfTasks.addAll(remainingTasks);

        //also shuffle the list
        long seed = System.nanoTime();
        Collections.shuffle(listOfTasks, new Random(seed));

        pc.setTasks(listOfTasks);

    }

    //Adds the remaining tasks to the challenge
    private List getRemainingTasks(int nrOfRemainingTasks, List mainTasks) {
        List listOfTasks = new ArrayList();

        List<utilities.Task> remainingTasks = dbh.getTasks();
        remainingTasks.removeAll(mainTasks);

        Random r = new Random();
        List<Integer> usedInts = new ArrayList<>();
        for (int i = 0; i < nrOfRemainingTasks; i++) {
            //Generate a random Int to take a random tasks
            int randomInt = r.nextInt(remainingTasks.size());

            //If this tasks is already taken then choose another one
            if (!usedInts.contains(randomInt)) {
                listOfTasks.add(mainTasks.get(randomInt));
                usedInts.add(randomInt);
            } else {
                i--;
                if (usedInts.size() == mainTasks.size()) break;
            }
        }
        return listOfTasks;
    }

}
