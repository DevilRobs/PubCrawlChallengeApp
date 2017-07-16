package com.example.rober.pubcrawlchallengeapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utilities.ProducedChallenge;

/**
 * Created by rober on 14.07.2017.
 */

public class AlgorithmGenerator {

    private DatabaseHelper dbh;
    private int selectedChallenge;
    private List players;

    final int NR_OF_TASKS = 3;

    public AlgorithmGenerator(DatabaseHelper dbh, int selectedChallenge, List players) {
        this.dbh = dbh;
        this.selectedChallenge = selectedChallenge;
        this.players = players;
    }

    public ProducedChallenge generateChallenge() {

        ProducedChallenge pc = new ProducedChallenge();
        pc.setPlayers(players);


        //0 = extrovertedChallenge
        //1 = introvertedChallenge
        //2 = senseless
        //3 = sexual
        switch (selectedChallenge) {
            case 0:
                addTasksToChallenge(dbh.getExtroTasks(), pc);
                break;
            case 1:
                addTasksToChallenge(dbh.getIntroTasks(), pc);
                break;
            case 2:
                addTasksToChallenge(dbh.getSenselessTasks(), pc);
                break;
            case 3:
                addTasksToChallenge(dbh.getSexualTasks(), pc);
                break;
        }




        return pc;
    }


    private void addTasksToChallenge(List mainTasks, ProducedChallenge pc) {
        List listOfTasks = new ArrayList();

        //Nr of taken main tasks
        int nrOfMainTasks = (int) Math.round(NR_OF_TASKS * 0.6);

        Random r = new Random();
        List usedInts = new ArrayList();
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

    private List getRemainingTasks(int nrOfRemainingTasks, List mainTasks) {
        List listOfTasks = new ArrayList();

        List remainingTasks = dbh.getTasks();
        remainingTasks.removeAll(mainTasks);

        Random r = new Random();
        List usedInts = new ArrayList();
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
