package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utilities.Player;
import utilities.ProducedChallenge;
import utilities.Task;

/**
 * Created by rober on 16.07.2017.
 */

public class ReducedChallenge {

    private ArrayList<String> listtasks;
    private ArrayList<Integer> listtaskpoints;
    private ArrayList<String> players;



    public ReducedChallenge(List<Task> fullTasks, List<Player> fullPlayers, boolean ger){
        listtasks = new ArrayList<>();
        listtaskpoints = new ArrayList<>();

        for(Object t : fullTasks){
            HashMap hs = (HashMap) t;
            if(ger) {
                listtasks.add((String) hs.get("Aufgabe"));
            }
            else if(!ger){
                listtasks.add((String) hs.get("Task"));
            }
            listtaskpoints.add((int)(long) hs.get("Points"));
        }
        //tasks = (String[])listtasks.toArray();

        players = new ArrayList<>();
        for(Player p : fullPlayers){
            players.add(p.getName());
        }

        //players = (String[]) playerslist.toArray();

    }


    public ArrayList getTasks() {
        return listtasks;
    }

    public ArrayList getTasksPoints() {
        return listtaskpoints;
    }

    public ArrayList getPlayers() {
        return players;
    }
}
