package utilities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rober on 15.07.2017.
 */

public class ProducedChallenge {

    private int id;
    private List tasks;
    private List players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getTasks() {
        return tasks;
    }

    public void setTasks(List tasks) {
        this.tasks = tasks;
    }

    public List getPlayers() {
        return players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }
}
