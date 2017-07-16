package utilities;

import java.io.Serializable;

/**
 * Created by rober on 14.07.2017.
 */

public class Player {

    private String name;
    private boolean gender;
    //male is true
    //female is false

    private int points;

    public Player(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
